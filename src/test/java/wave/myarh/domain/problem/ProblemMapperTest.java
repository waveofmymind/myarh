package wave.myarh.domain.problem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wave.myarh.domain.member.domain.Member;
import wave.myarh.domain.problem.domain.Problem;
import wave.myarh.domain.problem.dto.request.ProblemRequestDto;
import wave.myarh.domain.problem.dto.response.ProblemOnlyDto;
import wave.myarh.domain.problem.dto.response.ProblemResponseDto;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProblemMapperTest {

    @Autowired ProblemMapper problemMapper;

    @Test
    void toEntity_테스트() {
        // given
        final ProblemRequestDto registerDto = ProblemRequestDto.builder()
                .content("hi")
                .title("hi")
                .level(3)
                .build();
        final Member member = null;
        // when
        final Problem problem = problemMapper.toEntity(registerDto, member);
        //then
        assertThat(problem.getLevel()).isEqualTo(3);
        assertThat(problem.getTitle()).isEqualTo(registerDto.getTitle());
    }

    @Test
    void toDto_테스트() {
        //given
        Problem problem = Problem.builder()
                .title("제목2")
                .link("localhost:8080")
                .level(3)
                .build();
        //when
        ProblemResponseDto responseDto = problemMapper.toDto(problem);
        //then
        assertThat(responseDto.getTitle()).isEqualTo(problem.getTitle());
    }

    @Test
    void problemOnly_toDto_테스트() {
        // given
        final Problem problem = Problem.builder()
                .writer(null)
                .link("test.com")
                .title("test")
                .problemTagList(null)
                .reviewList(null)
                .build();
        // when
        final ProblemOnlyDto problemDto = problemMapper.toReviewExcludeDto(problem);
        // given
        assertThat(problemDto.getTitle()).isEqualTo(problem.getTitle());
    }

}