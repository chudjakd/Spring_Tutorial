package sk.dejvo.springtutorial.services.implementacia;

import org.springframework.stereotype.Service;
import sk.dejvo.springtutorial.model.Director;
import sk.dejvo.springtutorial.repositories.DirectorRepository;
import sk.dejvo.springtutorial.services.DirectorService;
@Service
public class DirectorServiceImp implements DirectorService {

    DirectorRepository directorRepository;

    public DirectorServiceImp(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public void createDirectorAndAddToDatabase() {
        Director director= new Director();
        director.setName("Jozko");
        directorRepository.save(director);
    }
}
