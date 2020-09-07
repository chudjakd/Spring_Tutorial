package sk.dejvo.springtutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sk.dejvo.springtutorial.model.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    List<Movie> findByName(String name);    // o implementaciu sa stara spring
}
