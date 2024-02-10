package ayb.app.movieapp.WS.convertor;

import ayb.app.movieapp.WS.dto.MovieDto;
import ayb.app.movieapp.bean.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieConvertor {
    public Movie toBean(MovieDto movieDto){
        Movie bean = new Movie();
        bean.setId(movieDto.getId());
        bean.setImdbId(movieDto.getImdbId());
        bean.setTitle(movieDto.getTitle());
        bean.setPoster(movieDto.getPoster());
        bean.setReleaseDate(movieDto.getReleaseDate());
        bean.setBackdrops(movieDto.getBackdrops());
        bean.setReviewIds(movieDto.getReviewIds());
        bean.setGenres(movieDto.getGenres());
        bean.setTrailerLink(movieDto.getTrailerLink());
        return bean;
    }

    public List<Movie> toBeans(List<MovieDto> movieDtos){
        return movieDtos.stream().map(e->toBean(e)).collect(Collectors.toList());
    }

    public MovieDto toDto(Movie movie){
        MovieDto dto = new MovieDto();
        dto.setId(movie.getId());
        dto.setImdbId(movie.getImdbId());
        dto.setTitle(movie.getTitle());
        dto.setPoster(movie.getPoster());
        dto.setReleaseDate(movie.getReleaseDate());
        dto.setBackdrops(movie.getBackdrops());
        dto.setReviewIds(movie.getReviewIds());
        dto.setGenres(movie.getGenres());
        dto.setTrailerLink(movie.getTrailerLink());
        return dto;
    }

    public List<MovieDto> toDtos(List<Movie> movies){
        return movies.stream().map(e->toDto(e)).collect(Collectors.toList());
    }
}
