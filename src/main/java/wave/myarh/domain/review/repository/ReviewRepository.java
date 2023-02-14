package wave.myarh.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wave.myarh.domain.review.domain.Review;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    boolean existsById(Long reviewId);
}
