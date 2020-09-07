package sk.dejvo.springtutorial.modeldto;

import sk.dejvo.springtutorial.model.Director;

import java.util.HashSet;
import java.util.Set;

public class MovieDTO {

    private Long id;

    private String name;

    private String surname;

    Set<Director> directorsofdto= new HashSet<>();


    public MovieDTO() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Director> getDirectorsofdto() {
        return directorsofdto;
    }

    public void setDirectorsofdto(Set<Director> directorsofdto) {
        this.directorsofdto = directorsofdto;
    }
}
