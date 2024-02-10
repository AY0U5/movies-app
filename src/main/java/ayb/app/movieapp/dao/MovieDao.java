package ayb.app.movieapp.dao;

import ayb.app.movieapp.bean.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDao extends MongoRepository<Movie, ObjectId> {
    Movie findByImdbId(String imdbId);
    Movie findByTitle(String title);
}
