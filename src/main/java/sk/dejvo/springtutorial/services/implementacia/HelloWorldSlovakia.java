package sk.dejvo.springtutorial.services.implementacia;

import org.springframework.stereotype.Service;
import sk.dejvo.springtutorial.services.HelloWorldService;
@Service
public class HelloWorldSlovakia implements HelloWorldService {
    @Override
    public void sayHelloWorld() {
        System.out.println("Ahoj, Pane");
    }
}
