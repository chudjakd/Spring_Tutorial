package sk.dejvo.springtutorial.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import sk.Random.RandomWord;

@Configuration
public class BeanConfiguration {
    @Bean
    public RandomWord createRandomWordLikeBean(){
        return new RandomWord();
    }

    @Bean
    RestTemplate createRestTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
