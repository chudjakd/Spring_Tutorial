package sk.dejvo.springtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import sk.Random.RandomWord;
import sk.dejvo.springtutorial.services.HelloWorldService;
import sk.dejvo.springtutorial.services.RestApiService;
import sk.dejvo.springtutorial.services.implementacia.PrintService;

@SpringBootApplication
public class SpringTutorialApplication {

	public static void main(String[] args) {

		ApplicationContext kontext=SpringApplication.run(SpringTutorialApplication.class, args);
		String word=kontext.getBean(RandomWord.class).getRandomWord();
		System.out.println(word);
        System.out.println(kontext.getBean(RestApiService.class).getTodo(1L));
	}

}
