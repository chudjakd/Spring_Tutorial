package sk.dejvo.springtutorial.services.implementacia;

import net.bytebuddy.build.Plugin;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sk.dejvo.springtutorial.model.Clovek;
import sk.dejvo.springtutorial.model.Todo;
import sk.dejvo.springtutorial.services.RestApiService;

import java.util.List;
@Service
public class RestApiServiceImplementacia implements RestApiService {

    RestTemplate restTemplate;

    public RestApiServiceImplementacia(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Clovek getClovek(Long id) {
        Clovek clovek =restTemplate.
                getForObject("http://dummy.restapiexample.com/api/v1/employee/"+id.toString(), Clovek.class);
        return clovek;
    }

    @Override
    public Todo getTodo(Long id) {
        return restTemplate.
                getForObject("https://jsonplaceholder.typicode.com/todos/"+id.toString(),Todo.class);
    }

    @Override
    public List<Todo> getTodos() {
        ResponseEntity<List<Todo>> responseEntity = restTemplate.
                exchange("https://jsonplaceholder.typicode.com/todos",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Todo>>(){}
                        );
        return responseEntity.getBody();
    }


    public static void main(String[] args) {
//        RestApiServiceImplementacia restApiServiceImplementacia= new RestApiServiceImplementacia();
//        Clovek clovek =restApiServiceImplementacia.getClovek(2L);
//        Todo todo= restApiServiceImplementacia.getTodo(1L);
//        System.out.println(clovek.getData().getEmployeeName());
//        System.out.println(todo.getTitle());
//        System.out.println(restApiServiceImplementacia.getTodos());

    }
}
