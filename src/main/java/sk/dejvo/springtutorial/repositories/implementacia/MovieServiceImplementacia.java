package sk.dejvo.springtutorial.repositories.implementacia;

import sk.dejvo.springtutorial.model.Movie;
import sk.dejvo.springtutorial.repositories.MovieRepository;
import sk.dejvo.springtutorial.services.MovieService;

public class MovieServiceImplementacia implements MovieService {

    MovieRepository movieRepository;
    @Override
    public Movie createAndAddMovie() {

        Movie movie= new Movie();
        movie.setName("Jazda");

        return movieRepository.save(movie);
    }
}
