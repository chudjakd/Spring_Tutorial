package sk.dejvo.springtutorial.services.implementacia;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sk.dejvo.springtutorial.services.HelloWorldService;

public class HelloWorldEnglish implements HelloWorldService {
    @Override
    public void sayHelloWorld() {
        System.out.println("Hello, Sir");
    }
}
