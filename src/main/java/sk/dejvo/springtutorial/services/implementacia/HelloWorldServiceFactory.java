package sk.dejvo.springtutorial.services.implementacia;

import sk.dejvo.springtutorial.services.HelloWorldService;

public class HelloWorldServiceFactory {

    public HelloWorldService createHelloWorldService(String language){
        switch (language){
            case "eng":
                return new HelloWorldEnglish();
            case "sk":
                return new HelloWorldSlovakia();
            case "primary":
                return new HelloWorldPrimary();
            default:
                return new HelloWorldPrimary();
        }
    }

}
