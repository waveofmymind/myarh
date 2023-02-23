package wave.myarh.domain.review.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wave.myarh.domain.member.domain.Member;
import wave.myarh.domain.problem.domain.Problem;
import wave.myarh.domain.problem.repository.ProblemRepository;
import wave.myarh.domain.review.ReviewMapper;
import wave.myarh.domain.review.domain.Review;
import wave.myarh.domain.review.dto.ReviewRequestDto;
import wave.myarh.domain.review.repository.ReviewRepository;
import wave.myarh.global.exception.EntityNotFoundException;
import wave.myarh.global.exception.UserAuthenticationException;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ReviewService {

    private final ReviewMapper reviewMapper;
    private final ReviewRepository reviewRepository;
    private final ProblemRepository problemRepository;
    public void addReview(Long problemId, ReviewRequestDto requestDto, Member member) {
        Problem findProblem = problemRepository.findById(problemId).orElseThrow(EntityNotFoundException::new);
        if (!findProblem.getWriter().getId().equals(member.getId())) {
            throw new UserAuthenticationException();
        }
        problemRepository.save(findProblem);
        reviewRepository.save(reviewMapper.toEntity(findProblem,requestDto));
    }

    @Transactional(readOnly = true)
    public Review getReview(Long reviewId) {
        return reviewRepository.findById(reviewId).orElseThrow(EntityNotFoundException::new);
    }

    public void editReview(Review review) {
        reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
