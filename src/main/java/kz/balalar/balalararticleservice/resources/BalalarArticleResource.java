package kz.balalar.balalararticleservice.resources;

import kz.balalar.balalararticleservice.models.ArticleItem;
import kz.balalar.balalararticleservice.models.UserRating;
import kz.balalar.balalararticleservice.services.ArticleItenInfo;
import kz.balalar.balalararticleservice.services.UserRatingInfo;
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


    @Autowired
    ArticleItenInfo articleItenInfo;

    @Autowired
    UserRatingInfo userRatingInfo;

    @RequestMapping("/{userId}")
    public List<ArticleItem> getArticle(@PathVariable("userId") String userId) {
        UserRating trends = userRatingInfo.getUserRating(userId);
        return trends.getUserRating().stream().map(trend -> articleItenInfo.getArticleItem(trend))
                .collect(Collectors.toList());
    }




}
