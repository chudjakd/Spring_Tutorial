package sk.dejvo.springtutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sk.dejvo.springtutorial.model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
