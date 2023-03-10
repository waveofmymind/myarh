package wave.myarh.domain.review.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;
import wave.myarh.domain.member.domain.Member;
import wave.myarh.domain.problem.domain.Problem;
import wave.myarh.domain.problem.repository.ProblemRepository;
import wave.myarh.domain.review.ReviewMapper;
import wave.myarh.domain.review.domain.Review;
import wave.myarh.domain.review.dto.ReviewRequestDto;
import wave.myarh.domain.review.repository.ReviewRepository;
import wave.myarh.global.exception.EntityNotFoundException;
import wave.myarh.global.exception.ErrorCode;
import wave.myarh.global.exception.UserAuthenticationException;


import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@Transactional
@ExtendWith(MockitoExtension.class)
public class ReviewServiceTest {

    @InjectMocks
    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private ProblemRepository problemRepository;

    @Mock
    private ReviewMapper reviewMapper;

    final Member member = Member.builder()
            .id(1L)
            .email("test")
            .nickname("test")
            .build();

    void setup() {
        final Problem problem = Problem.builder()
                .writer(member)
                .build();

        given(problemRepository.findById(1L)).willReturn(Optional.of(problem));
    }

    @Test
    @DisplayName("의존성_주입_테스트")
    void 의존성_주입_테스트() {
        assertThat(reviewService).isNotNull();
    }

    @Test
    @DisplayName("리뷰_등록_테스트")
    void 리뷰_등록_테스트() {
        setup();
        //given
        Long problemId = 1L;

        final ReviewRequestDto requestDto = ReviewRequestDto.builder()
                .content("리뷰 테스트입니다.")
                .build();
        //when
        reviewService.addReview(problemId,requestDto,member);
    }

    @Test
    @DisplayName("문제가_존재하지_않을_경우_테스트")
    void 리뷰_등록_실패() {
        //given
        given(problemRepository.findById(2L)).willReturn(Optional.empty());
        Long problemId = 2L;

        final ReviewRequestDto requestDto = ReviewRequestDto.builder()
                .content("리뷰 테스트입니다.")
                .build();

        //when
        EntityNotFoundException e = assertThrows(EntityNotFoundException.class,
                () -> reviewService.addReview(problemId,requestDto,member));

        //then
        assertThat(e.getMessage()).isEqualTo(ErrorCode.ENTITY_NOT_FOUND.getMessage());
    }

    @Test
    @DisplayName("리뷰 등록 실패_권한 없는 경우")
    void 리뷰_등록_권한X_테스트() {
        setup();
        //given
        final Member member = Member.builder()
                .build();

        Long problemId = 1L;

        final ReviewRequestDto requestDto = ReviewRequestDto.builder()
                .content("리뷰 등록 테스트")
                .build();

        // when
        UserAuthenticationException e = assertThrows(UserAuthenticationException.class,
                () -> reviewService.addReview(problemId, requestDto, member)); // 예외가 발생해야 한다.

        //then
        assertThat(e.getMessage()).isEqualTo(ErrorCode.NOT_VALID_USER.getMessage());
    }


}
