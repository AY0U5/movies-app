package ayb.app.movieapp.dao;

import ayb.app.movieapp.bean.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDao extends MongoRepository<Review, ObjectId> {
}
