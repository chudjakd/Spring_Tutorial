package sk.dejvo.springtutorial.mappers;

import org.junit.jupiter.api.Test;
import sk.dejvo.springtutorial.model.Director;
import sk.dejvo.springtutorial.model.Movie;
import sk.dejvo.springtutorial.modeldto.MovieDTO;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MovieMapperTest {
    @Test
    public void movieToMovieDtoIsTheSame(){
        Movie movie = new Movie();
        movie.setName("Jazda");
        movie.setId(1L);
        Director director= new Director();
        director.setName("Piciak");
        Set<Director> directorsSet= new HashSet<>();
        directorsSet.add(director);
        movie.setDirectors(directorsSet);
        MovieDTO movieDTO= MovieMapper.instance.movieToMovieDTO(movie);

        assertEquals(movieDTO.getName(),movie.getName());
        assertEquals(movieDTO.getId(),movie.getId());
        assertArrayEquals(movieDTO.getDirectorsofdto().toArray(),movie.getDirectors().toArray());
    }

}