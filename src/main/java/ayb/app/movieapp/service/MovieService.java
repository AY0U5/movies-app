package ayb.app.movieapp.service;

import ayb.app.movieapp.bean.Movie;
import ayb.app.movieapp.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieDao movieDao;

    public Movie findByImdbId(String imdbId) {
        return movieDao.findByImdbId(imdbId);
    }

    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    public Movie findByTitle(String title) {
        return movieDao.findByTitle(title);
    }
}
