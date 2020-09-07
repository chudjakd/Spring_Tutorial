package sk.dejvo.springtutorial.services;


import sk.dejvo.springtutorial.model.Movie;
import sk.dejvo.springtutorial.modeldto.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO addMovie(MovieDTO movieDTO);

    Movie createAndAddMovie();

    Movie createFilmWithName();

    MovieDTO getMovieById(Long id);

    List<MovieDTO> getAllMovies();

    List<MovieDTO> findMovieByName(String name);

    MovieDTO updateMovie(MovieDTO moviedto, Long movieId);

    void deleteMovieByID(Long movieid);

    List<MovieDTO> findMovieBySurname(String surname);
}
