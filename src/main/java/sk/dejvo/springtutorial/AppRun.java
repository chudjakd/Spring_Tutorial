package sk.dejvo.springtutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.dejvo.springtutorial.services.MovieService;

@Component
public class AppRun {
    @Autowired
    MovieService movieService;
    public void run(){
        movieService.createAndAddMovie();
    }
}
