package sk.dejvo.springtutorial.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.dejvo.springtutorial.model.Movie;

public interface movieRepository extends CrudRepository<Movie,Long> {
}
