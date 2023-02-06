package wave.myarh.domain.problem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wave.myarh.domain.problem.domain.Problem;
import wave.myarh.domain.problem.dto.request.ProblemRequestDto;
import wave.myarh.domain.problem.dto.response.ProblemResponseDto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProblemMapperTest {

    @Autowired ProblemMapper problemMapper;

    @Test
    void toEntity_테스트() {
        //given
        ProblemRequestDto requestDto = ProblemRequestDto.builder()
                .title("제목")
                .link("waveofmymind.site")
                .level(2)
                .content("내용")
                .build();
        //when
        Problem problem = problemMapper.toEntity(requestDto);
        //then
        assertThat(problem.getLink()).isEqualTo(requestDto.getLink());
        assertThat(problem.getTitle()).isEqualTo(requestDto.getTitle());
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

}