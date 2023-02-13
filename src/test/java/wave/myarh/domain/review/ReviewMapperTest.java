package wave.myarh.domain.review;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import wave.myarh.domain.problem.ProblemMapper;
import wave.myarh.domain.problem.domain.Problem;
import wave.myarh.domain.problem.dto.request.ProblemRequestDto;
import wave.myarh.domain.review.domain.Review;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class ReviewMapperTest {

    @Autowired
    ReviewMapper reviewMapper;

    @Autowired
    ProblemMapper problemMapper;

    @Test
    @DisplayName("toEntity 테스트")
    void toEntity() {
        //given
        ProblemRequestDto requestDto = ProblemRequestDto.builder().title("제목입니다")
                .link("링크입니다.")
                .level(3)
                .content("내용입니다")
                .tagList(new ArrayList<String>(Arrays.asList("태그1","태그2","태그3")))
                .build();
        Problem problem = problemMapper.toEntity(requestDto);
        //when
        Review review = reviewMapper.toEntity(requestDto, problem);

        //then
        assertThat(review.getContent()).isEqualTo(requestDto.getContent());
        assertThat(review.getProblem().getProblemTagList()).isEqualTo(problem.getProblemTagList());
    }





}