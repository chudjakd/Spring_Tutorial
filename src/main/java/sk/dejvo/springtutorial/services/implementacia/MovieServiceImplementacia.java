package sk.dejvo.springtutorial.services.implementacia;

import org.springframework.stereotype.Service;
import sk.dejvo.springtutorial.mappers.MovieMapper;
import sk.dejvo.springtutorial.mappers.MovieMapperImpl;
import sk.dejvo.springtutorial.model.Movie;
import sk.dejvo.springtutorial.modeldto.MovieDTO;
import sk.dejvo.springtutorial.repositories.MovieRepository;
import sk.dejvo.springtutorial.services.MovieService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImplementacia implements MovieService {

    MovieMapper movieMapper;
    MovieRepository movieRepository;

    public MovieServiceImplementacia(MovieRepository movieRepository, MovieMapper movieMapper)
    {
        this.movieRepository = movieRepository;
        this.movieMapper= movieMapper;
    }

    @Override
    public MovieDTO addMovie(MovieDTO movieDTO) {

        return movieMapper.movieToMovieDTO(movieRepository
                .save(movieMapper.movieDTOtoMovie(movieDTO)));
    }

    @Override
    public Movie createAndAddMovie() {

        Movie movie= new Movie();
        movie.setName("Jazda");

        return movieRepository.save(movie);
    }

    @Override
    public Movie createFilmWithName() {
        Movie movie= new Movie();
        movie.setName("Eldorado");

        return movieRepository.save(movie);
    }

    @Override
    public MovieDTO getMovieById(Long id) {
        return MovieMapper.instance.movieToMovieDTO(movieRepository.findById(id).orElse(null));
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieDTO> movieDTOList = new ArrayList<>();
        MovieDTO movieDTO= new MovieDTO();
        for(Movie movie: movieRepository.findAll()){
            movieDTO= MovieMapperImpl.instance.movieToMovieDTO(movie);
            movieDTOList.add(movieDTO);
        }
        return movieDTOList;
    }

    @Override
    public List<MovieDTO> findMovieByName(String name) {

        return movieRepository.findByName(name).stream()
               .map(movie -> movieMapper.movieToMovieDTO(movie)).collect(Collectors.toList());
    }

    @Override
    public MovieDTO updateMovie(MovieDTO moviedto, Long movieId) {
        return movieMapper.movieToMovieDTO(movieRepository.findById(movieId)
                .map(movie ->{
                    movie.setName(moviedto.getName());
                    movie.setDirectors(moviedto.getDirectorsofdto());
                    return movieRepository.save(movie);
                }
                ).orElseGet(() -> {
                    moviedto.setId(movieId);
                    return movieRepository.save(movieMapper.movieDTOtoMovie(moviedto));
                }
                )
        );

    }

    @Override
    public void deleteMovieByID(Long movieid) {
        movieRepository.deleteById(movieid);
    }
}
