package sk.dejvo.springtutorial.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.dejvo.springtutorial.model.Director;

public interface DirectorRepository extends CrudRepository<Director, Long> {
}
