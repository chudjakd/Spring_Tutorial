package sk.dejvo.springtutorial.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "directors")
    Set<Movie> movies= new HashSet<>();
}
