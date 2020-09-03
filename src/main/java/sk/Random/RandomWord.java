package sk.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
@Controller
public class RandomWord {
    private List<String> words=null;

    public RandomWord() {
        this.words = Arrays.asList("Jazda","IDK","Opel");
    }
    @Bean
    public String getRandomWord(){
        Random random= new Random();
        int randomNumber=random.nextInt(this.words.size());
        return this.words.get(randomNumber);
    }
}
