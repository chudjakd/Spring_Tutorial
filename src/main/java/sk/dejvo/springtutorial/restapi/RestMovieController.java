package sk.dejvo.springtutorial.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Links;
import org.springframework.web.bind.annotation.*;
import sk.dejvo.springtutorial.model.Movie;
import sk.dejvo.springtutorial.modeldto.MovieDTO;
import sk.dejvo.springtutorial.repositories.MovieRepository;
import sk.dejvo.springtutorial.services.MovieService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
public class RestMovieController {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieService movieService;
    @Autowired
    MovieResourceAssembler movieResourceAssembler;

//    public RestMovieController(MovieRepository movieRepository) {
//        this.movieRepository = movieRepository;
//    }


    // TODO: 7. 9. 2020 Doplnit do movie dalsi parameter(napr priezvisko) a skusit zobrat z get requestu oba parametre
    // TODO: 7. 9. 2020 Skusit napisat metodu ktora bude jedna davat zoznam podla mena a druha podla priezviska
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
