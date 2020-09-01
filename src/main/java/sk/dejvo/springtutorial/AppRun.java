package sk.dejvo.springtutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sk.dejvo.springtutorial.services.DirectorService;
import sk.dejvo.springtutorial.services.HelloWorldService;
import sk.dejvo.springtutorial.services.MovieService;

@Component
public class AppRun {

    @Autowired
    //  @Qualifier("helloWorldSlovakia")
    HelloWorldService helloWorldService;
    @Autowired
    DirectorService directorService;

    public void run(){
        helloWorldService.sayHelloWorld();
        directorService.createDirectorAndAddToDatabase();
    }
}
