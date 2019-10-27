package kz.balalar.balalararticleservice.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.balalar.balalararticleservice.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/info")
public class BalalarInfoResource {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/{userId}")
    public List<ArticleItem> getArticle(@PathVariable("userId") String userId) {
        ArticleInfo comments = getArticleComments(userId);
        return comments.getArticleInfo().stream().map(comment -> getArticleItem(comment))
                .collect(Collectors.toList());
    }

    @HystrixCommand(fallbackMethod = "getFallbackArticleItem")
    private ArticleItem getArticleItem(Comment comment) {
        PodcastItem podcast = restTemplate.getForObject("http://balalar-podcasts-service/podcast/" + comment.getName(), PodcastItem.class);
        return new ArticleItem(comment.getName(), podcast.getDesc(), podcast.getLink(), "12", podcast.getName(), comment.getCommentId(), comment.getImage(), comment.getAuthor(), comment.getTimes());
    }

    private ArticleItem getFallbackArticleItem(Comment comment) {
        return new ArticleItem("article name not found", "no desc", "null", "", "", "", "", "", "");
    }

    @HystrixCommand(fallbackMethod = "getFallbackArticleComments")
    private ArticleInfo getArticleComments(@PathVariable("userId") String userId) {
        return restTemplate.getForObject("http://balalar-comments-service/comments/articles/"+userId, ArticleInfo.class);
    }

    private ArticleInfo getFallbackArticleComments(@PathVariable("userId") String userId) {
        ArticleInfo articleInfo = new ArticleInfo();

        articleInfo.setArticleInfo(Arrays.asList(
                new Comment("null", "null", "", "", "")
        ));
        return articleInfo;
    }

}
