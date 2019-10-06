package kz.balalar.balalararticleservice.resources;

import kz.balalar.balalararticleservice.models.ArticleItem;
import kz.balalar.balalararticleservice.models.Comment;
import kz.balalar.balalararticleservice.models.PodcastItem;
import kz.balalar.balalararticleservice.models.UserRating;
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
//            Comment comment = webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:8082/comments/" + trend.getTrendId())
//                    .retrieve()
//                    .bodyToMono(Comment.class)
//                    .block();

            return new ArticleItem(comment.getName(), "Аким алматы Сагинтаев прошло 3 месяца как он приступил к работе", trend.getTrendId(), podcast.getLink());

        }).collect(Collectors.toList());


    }
}
