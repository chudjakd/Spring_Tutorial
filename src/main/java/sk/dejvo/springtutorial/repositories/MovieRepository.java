package sk.dejvo.springtutorial.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.dejvo.springtutorial.model.Movie;

public interface MovieRepository extends CrudRepository<Movie,Long> {
}
