package sk.dejvo.springtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringTutorialApplication {

	public static void main(String[] args) {

		ApplicationContext kontext=SpringApplication.run(SpringTutorialApplication.class, args);
		AppRun appRun= kontext.getBean(AppRun.class);
		appRun.run();
	}

}
