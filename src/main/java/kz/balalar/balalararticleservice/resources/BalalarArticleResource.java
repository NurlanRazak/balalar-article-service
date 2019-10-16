package kz.balalar.balalararticleservice.resources;

import kz.balalar.balalararticleservice.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/article")
public class BalalarArticleResource {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<ArticleItem> getArticle(@PathVariable("userId") String userId) {
        UserRating trends = restTemplate.getForObject("http://balalar-trends-service/trends/users/" + userId, UserRating.class);
        return trends.getUserRating().stream().map(trend -> {
            Comment comment = restTemplate.getForObject("http://balalar-comments-service/comments/" + trend.getTrendId(), Comment.class);
            PodcastItem podcast = restTemplate.getForObject("http://balalar-podcasts-service/podcast/" + trend.getTrendId(), PodcastItem.class);

            return new ArticleItem(comment.getName(), "Аким алматы Сагинтаев прошло 3 месяца как он приступил к работе", trend.getTrendId(), podcast.getLink(), trend.getCategoryName(), trend.getTags(), "https://www.pixelstalk.net/wp-content/uploads/2016/06/HD-pictures-of-nature-download.jpg", "Tame Impala", "13 minutes");

        }).collect(Collectors.toList());


    }
}
