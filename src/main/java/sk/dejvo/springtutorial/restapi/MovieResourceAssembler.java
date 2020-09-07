package sk.dejvo.springtutorial.restapi;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import sk.dejvo.springtutorial.modeldto.MovieDTO;
import sk.dejvo.springtutorial.restapi.RestMovieController;

import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.methodOn;

@Component
public class MovieResourceAssembler implements RepresentationModelAssembler<MovieDTO, EntityModel<MovieDTO>> {
    @Override
    public EntityModel<MovieDTO> toModel(MovieDTO movieDTO) {
        return new EntityModel<> (movieDTO
                ,linkTo(methodOn(RestMovieController.class)
                        .getMovieById(movieDTO.getId())).withSelfRel(),
                linkTo(methodOn(RestMovieController.class)
                        .getMovies("")).withRel("movies")
        ) ;
    }
}
