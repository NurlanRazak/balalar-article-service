package kz.balalar.balalararticleservice.resources;

import kz.balalar.balalararticleservice.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/info")
public class BalalarInfoResource {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/{userId}")
    public List<ArticleItem> getArticle(@PathVariable("userId") String userId) {
        ArticleInfo comments = restTemplate.getForObject("http://balalar-comments-service/comments/articles/"+userId, ArticleInfo.class);
        return comments.getArticleInfo().stream().map(comment -> {
            PodcastItem podcast = restTemplate.getForObject("http://balalar-podcasts-service/podcast/" + comment.getName(), PodcastItem.class);

            return new ArticleItem(comment.getName(), podcast.getDesc(), podcast.getLink(), "12", podcast.getName(), comment.getCommentId(), comment.getImage(), comment.getAuthor(), comment.getTimes());

        }).collect(Collectors.toList());


    }
}
