package sk.dejvo.springtutorial.repositories.implementacia;

import org.springframework.stereotype.Service;
import sk.dejvo.springtutorial.model.Movie;
import sk.dejvo.springtutorial.repositories.MovieRepository;
import sk.dejvo.springtutorial.services.MovieService;

@Service
public class MovieServiceImplementacia implements MovieService {

    MovieRepository movieRepository;

    public MovieServiceImplementacia(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie createAndAddMovie() {

        Movie movie= new Movie();
        movie.setName("Jazda");

        return movieRepository.save(movie);
    }
}
