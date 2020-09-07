package sk.dejvo.springtutorial.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sk.dejvo.springtutorial.model.Movie;
import sk.dejvo.springtutorial.modeldto.MovieDTO;
@Mapper
public interface MovieMapper {

    MovieMapper instance = Mappers.getMapper(MovieMapper.class);

    @Mapping(target = "directorsofdto",source = "directors")
    MovieDTO movieToMovieDTO(Movie movie);

    @Mapping(source = "directorsofdto",target = "directors")
    Movie movieDTOtoMovie(MovieDTO moviedto);
}
