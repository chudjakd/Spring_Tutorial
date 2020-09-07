package sk.dejvo.springtutorial.services.implementacia;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sk.dejvo.springtutorial.mappers.MovieMapper;
import sk.dejvo.springtutorial.model.Movie;
import sk.dejvo.springtutorial.modeldto.MovieDTO;
import sk.dejvo.springtutorial.services.MovieService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class MovieServiceImplementaciaTest {

    @Autowired
    MovieService movieService;


    @Test
    public void getMovieDTOById1(){
        Movie movie = new Movie();
        movie.setName("Jazda");
        movie.setId(1L);

        MovieDTO movieDTO= MovieMapper.instance.movieToMovieDTO(movie);

        assertEquals(movie.getId(),movieDTO.getId());
        assertEquals(movie.getName(),movieDTO.getName());
    }
    @Test
    @Transactional
    public void getAllMoviesToMovieDTO(){
        Movie movie = new Movie();
        movie.setName("Jazda");
        movie.setId(1L);

        Movie movie1 = new Movie();
        movie1.setName("Jazda");
        movie1.setId(2L);

        List<Movie> movies= new ArrayList<>();
        movies.add(movie);
        movies.add(movie1);
        List<MovieDTO> movieDTOList= movieService.getAllMovies();
        assertEquals(movieDTOList.get(0).getName(),movies.get(0).getName());
        assertEquals(movieDTOList.get(0).getId(),movies.get(0).getId());
        assertEquals(movieDTOList.get(1).getId(),movies.get(1).getId());
        assertEquals(movieDTOList.get(1).getName(),movies.get(1).getName());
    }
    @Test
    @Transactional
    public void movieFromDatabaseIsJazda(){
        List<MovieDTO> movieDTOList= movieService.findMovieByName("Jazda");
        assertEquals(movieDTOList.get(0).getName(),"Jazda");
        assertEquals(movieDTOList.get(1).getName(),"Jazda");
    }

}