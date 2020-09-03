package sk.dejvo.springtutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sk.dejvo.springtutorial.services.HelloWorldService;
import sk.dejvo.springtutorial.services.implementacia.HelloWorldServiceFactory;

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public HelloWorldServiceFactory createHelloWorldServiceFactory(){
        return new HelloWorldServiceFactory();
    }

    @Bean
    @Profile("sk")
    public HelloWorldService czechHelloWorld(HelloWorldServiceFactory helloWorldServiceFactory){
        return helloWorldServiceFactory.createHelloWorldService("sk");
    }

    @Bean
    @Profile("eng")
    public HelloWorldService englishHelloWorld(HelloWorldServiceFactory helloWorldServiceFactory){
        return helloWorldServiceFactory.createHelloWorldService("eng");
    }
    @Bean
    @Primary
    @Profile("primary")
    public HelloWorldService primaryHelloWorld(HelloWorldServiceFactory helloWorldServiceFactory){
        return helloWorldServiceFactory.createHelloWorldService("primary");
    }

}
