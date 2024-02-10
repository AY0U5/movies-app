package ayb.app.movieapp.WS.facade;

import ayb.app.movieapp.WS.convertor.MovieConvertor;
import ayb.app.movieapp.WS.dto.MovieDto;
import ayb.app.movieapp.bean.Movie;
import ayb.app.movieapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie/")
public class MovieWS {
    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieConvertor convertor;

    @GetMapping("/imdbId/{imdbId}")
    public MovieDto findByImdbId(@PathVariable String imdbId) {
        Movie movie = movieService.findByImdbId(imdbId);
        return convertor.toDto(movie);
    }
    @GetMapping("/")
    public List<MovieDto> findAll() {
        List<Movie> movies = movieService.findAll();
        return convertor.toDtos(movies);
    }
    @GetMapping("/title/{title}")
    public MovieDto findByTitle(@PathVariable String title) {
        Movie movie = movieService.findByTitle(title);
        return convertor.toDto(movie);
    }
}
