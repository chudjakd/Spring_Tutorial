package sk.dejvo.springtutorial.services;


import sk.dejvo.springtutorial.model.Clovek;
import sk.dejvo.springtutorial.model.Todo;

import java.util.List;

public interface RestApiService {

    Clovek getClovek(Long id);
    Todo getTodo(Long id);
    List<Todo> getTodos();

}
