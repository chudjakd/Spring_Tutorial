package sk.dejvo.springtutorial.services;

import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewResolverMethodReturnValueHandler;
import sk.dejvo.springtutorial.model.Movie;

public interface MovieService {

    Movie createAndAddMovie();
}
