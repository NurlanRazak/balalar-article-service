package kz.balalar.balalararticleservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.balalar.balalararticleservice.models.Trends;
import kz.balalar.balalararticleservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingInfo {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        return restTemplate.getForObject("http://balalar-trends-service/trends/users/" + userId, UserRating.class);
    }

    public UserRating getFallbackUserRating(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();

        userRating.setUserRating(Arrays.asList(
                new Trends("0","0", "", "", "0")
        ));
        return userRating;
    }
}
