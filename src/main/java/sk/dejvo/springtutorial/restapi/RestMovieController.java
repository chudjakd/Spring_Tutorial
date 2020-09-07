package sk.dejvo.springtutorial.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import sk.dejvo.springtutorial.modeldto.MovieDTO;
import sk.dejvo.springtutorial.services.MovieService;

import java.util.List;



@RestController
@RequestMapping("/api")
public class RestMovieController {

    @Autowired
    MovieService movieService;
    @Autowired
    MovieResourceAssembler movieResourceAssembler;

    @GetMapping("/movies")
    List<MovieDTO> getMovies(@RequestParam(required = false) String name,@RequestParam(required = false) String surname){

        if(name!=null && !name.isEmpty()){
            return movieService.findMovieByName(name);
        } else if(surname!=null && !surname.isEmpty()) {
            return movieService.findMovieBySurname(surname);
        }
        else {
            return movieService.getAllMovies();
        }

    }

    @GetMapping("/movies/{id}")
    EntityModel<MovieDTO> getMovieById(@PathVariable("id") Long movieId){
        MovieDTO movieDTO= movieService.getMovieById(movieId);
        return movieResourceAssembler.toModel(movieDTO);
    }

    @PostMapping("/movies")
    MovieDTO addMovie(@RequestBody MovieDTO moviedto){
        return movieService.addMovie(moviedto);
    }

    @PutMapping("/movies/{id}")
    MovieDTO updateMovie(@RequestBody MovieDTO moviedto,@PathVariable("id") Long movieId){
        return movieService.updateMovie(moviedto,movieId);
    }

    @DeleteMapping("movies/{id}")
    void deleteMovieById(@PathVariable("id") Long movieId){
        movieService.deleteMovieByID(movieId);
    }

}
