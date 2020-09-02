package sk.dejvo.springtutorial.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.dejvo.springtutorial.repositories.DirectorRepository;


@Controller

public class DirectorsController {

    DirectorRepository directorRepository;

    public DirectorsController(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @RequestMapping("/directors")
    public String getAllDirectors(Model model){
    model.addAttribute("directors",directorRepository.findAll());
    return "directors";
    }
}
