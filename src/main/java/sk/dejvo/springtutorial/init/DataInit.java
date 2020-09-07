package sk.dejvo.springtutorial.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sk.dejvo.springtutorial.model.Movie;
import sk.dejvo.springtutorial.repositories.MovieRepository;
import sk.dejvo.springtutorial.services.MovieService;
@Component
public class DataInit implements ApplicationListener<ContextRefreshedEvent> {

    MovieService movieService;

    public DataInit(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        movieService.createAndAddMovie();
        movieService.createAndAddMovie();
        movieService.createFilmWithName();


    }
}
