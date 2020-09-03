package sk.dejvo.springtutorial.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.dejvo.springtutorial.model.Movie;
import sk.dejvo.springtutorial.repositories.MovieRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestMovieController {

    @Autowired
    MovieRepository movieRepository;

//    public RestMovieController(MovieRepository movieRepository) {
//        this.movieRepository = movieRepository;
//    }

    @GetMapping("/movies")
    List<Movie> allMovies(){
        return movieRepository.findAll();
    }


    @RequestMapping("/movies/id/{id}")
    Movie getMovieByID(@RequestParam(value="id") int id){

        List<Movie> movies=movieRepository.findAll();
        return movies.get(id);
    }
}
