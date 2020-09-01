package sk.dejvo.springtutorial.services.implementacia;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sk.dejvo.springtutorial.services.HelloWorldService;
@Service
@Primary
@Profile("primary")
public class HelloWorldPrimary implements HelloWorldService {
    @Override
    public void sayHelloWorld() {
        System.out.println("Je to outik tento soutik");
    }
}
