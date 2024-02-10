package ayb.app.movieapp.service;

import ayb.app.movieapp.bean.Movie;
import ayb.app.movieapp.bean.Review;
import ayb.app.movieapp.dao.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewDao reviewDao;
    @Autowired
    private MongoTemplate template;
    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewDao.insert(new Review(reviewBody));

        template.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
