package wave.myarh.domain.problem.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import wave.myarh.domain.problem.domain.Problem;
import wave.myarh.domain.problem.domain.ProblemTag;
import wave.myarh.domain.problem.domain.Tag;
import wave.myarh.domain.problem.dto.request.ProblemRequestDto;
import wave.myarh.domain.problem.dto.response.ProblemResponseDto;
import wave.myarh.domain.problem.repository.ProblemRepository;
import wave.myarh.domain.problem.repository.TagRepository;
import wave.myarh.domain.review.domain.Review;
import wave.myarh.domain.review.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional

class ProblemServiceTest {

    @Autowired
    ProblemService problemService;
    @Autowired
    ProblemRepository problemRepository;
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    TagRepository tagRepository;

//    @BeforeEach
//    void beforeEach() {
//        for (int i = 0; i < 50; i++) {
//            Problem problem = Problem.builder().build();
//            Review review = Review.builder()
//                    .problem(problem)
//                    .content("테스트"+i)
//                    .build();
//
//            problem.setReview(review);
//            problem.setProblemTagList(null);
//            problemRepository.save(problem);
//        }

//    }
    @Test
    @DisplayName("의존성_주입")
    void 의존성_주입Test() {
        assertThat(problemService).isNotNull();
    }

    @Test
    @DisplayName("문제, 리뷰 등록 테스트")
    void 문제_리뷰_등록_테스트() {
        Problem problem = Problem.builder().build();
        Review review = Review.builder()
                .problem(problem)
                .content("테스트")
                .build();

        problem.setReview(review);
        problem.setProblemTagList(null);
        problemRepository.save(problem);

        ProblemResponseDto saveProblemDto = problemService.getProblemById(problem.getId());
        assertThat(reviewRepository.existsById(review.getId())).isTrue();
        assertThat(saveProblemDto.getReviewList().size()).isEqualTo(1);
    }

    @Test
    @Transactional
    @DisplayName("문제_전체_조회_테스트")
    void 문제_전체_조회() {
        Problem problem = Problem.builder().build();
        Review review = Review.builder()
                .problem(problem)
                .content("테스트")
                .build();
        problem.setReview(review);
        problem.setProblemTagList(null);

        problemRepository.save(problem);
        PageRequest page = PageRequest.of(0, 5);
        assertThat(problemRepository.findByOrderByCreatedDateDesc(page).size())
                .isEqualTo(1);


    }

    @Test
    @Transactional
    @DisplayName("문제, 태그 등록 테스트")
    void 문제_태그_등록_테스트() {
        Problem problem = Problem.builder().build();
        List<String> tagStringList = List.of("태그1", "태그2");
        List<ProblemTag> tagList = tagStringList.stream().map(tag -> new ProblemTag(problem, new Tag(tag))).toList();
        problem.setReview(null);
        problem.setProblemTagList(tagList);
        problemRepository.save(problem);

        ProblemResponseDto saveProblem = problemService.getProblemById(problem.getId());
        assertThat(saveProblem.getProblemTagList().size()).isEqualTo(tagStringList.size());
    }

    @Test
    @Transactional
    @DisplayName("문제 저장 통합 테스트")
    void 문제_저장_테스트() {
        Tag saveTag = new Tag("테스트1");
        tagRepository.save(saveTag);
        ArrayList<String> tagStringList = new ArrayList<>(Arrays.asList("테스트1", "테스트2"));
        ProblemRequestDto requestDto = ProblemRequestDto.builder()
                .tagList(tagStringList)
                .content("테스트")
                .build();
        Long problemId = problemService.registerProblem(requestDto);

        ProblemResponseDto saveProblem = problemService.getProblemById(problemId);
        assertThat(saveProblem.getProblemTagList().size()).isEqualTo(tagStringList.size());
        assertThat(saveProblem.getReviewList().get(0).getContent()).isEqualTo(requestDto.getContent());
    }

//    @Test
//    @Transactional
//    @DisplayName("문제 삭제 테스트")
//    void 문제_삭제_테스트() {
//        Long targetId = 52L;
//        problemRepository.deleteById(targetId);
//    }
}
