package kz.balalar.balalararticleservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.balalar.balalararticleservice.models.ArticleItem;
import kz.balalar.balalararticleservice.models.Comment;
import kz.balalar.balalararticleservice.models.PodcastItem;
import kz.balalar.balalararticleservice.models.Trends;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ArticleItenInfo {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(
            fallbackMethod = "getFallbackArticleCommentPodcastItem",
            threadPoolKey = "articleItemPool",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="20"),
                    @HystrixProperty(name="maxQueueSize", value="10"),
            }
    )
    public ArticleItem getArticleItem(Trends trend) {
        Comment comment = restTemplate.getForObject("http://balalar-comments-service/comments/" + trend.getTrendId(), Comment.class);
        PodcastItem podcast = restTemplate.getForObject("http://balalar-podcasts-service/podcast/" + trend.getTrendId(), PodcastItem.class);

        return new ArticleItem(comment.getName(), "Аким алматы Сагинтаев прошло 3 месяца как он приступил к работе", trend.getTrendId(), podcast.getLink(), trend.getCategoryName(), trend.getTags(), "https://www.pixelstalk.net/wp-content/uploads/2016/06/HD-pictures-of-nature-download.jpg", "Tame Impala", "13 minutes");
    }

    public ArticleItem getFallbackArticleCommentPodcastItem(Trends trend) {
        return new ArticleItem("article name not found", "no desc", "null", "", "", "", "", "", "");
    }

}
