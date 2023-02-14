package wave.myarh.domain.review.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;
import wave.myarh.domain.problem.domain.Problem;
import wave.myarh.domain.review.domain.Review;
import wave.myarh.domain.review.repository.ReviewRepository;

import static org.assertj.core.api.Assertions.*;


@Transactional
@ExtendWith(MockitoExtension.class)
public class ReviewServiceTest {

    @Mock
    ReviewService reviewService;

    @Mock
    ReviewRepository reviewRepository;

    @Test
    @DisplayName("의존성_주입_테스트")
    void 의존성_주입_테스트() {
        assertThat(reviewService).isNotNull();
    }

    @Test
    @DisplayName("리뷰_등록_테스트")
    void 리뷰_등록_테스트() {
        Problem problem = Problem.builder().build();
        Review review = Review.builder()
                .problem(problem).content("내용").build();
        reviewRepository.save(review);
    }

    //todo
}
