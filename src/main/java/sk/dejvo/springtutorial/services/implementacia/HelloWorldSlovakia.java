package sk.dejvo.springtutorial.services.implementacia;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sk.dejvo.springtutorial.services.HelloWorldService;
@Service
@Primary
@Profile({"sk","eng"})
public class HelloWorldSlovakia implements HelloWorldService {
    @Override
    public void sayHelloWorld() {
        System.out.println("Ahoj, Pane");
    }
}
