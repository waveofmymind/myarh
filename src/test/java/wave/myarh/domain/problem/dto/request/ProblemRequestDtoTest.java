package wave.myarh.domain.problem.dto.request;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ProblemRequestDtoTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    public static void init(){
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    public static void close() {
        validatorFactory.close();
    }

    @Test
    void NotNull_유효성O_테스트() {
        // given
        ProblemRequestDto requestDto = ProblemRequestDto.builder()
                .title("테스트")
                .content("테스트")
                .link("ㄹㄴㅇ")
                .level(3)
                .tagList(new ArrayList<>(Arrays.asList("테스트1", "테스트2", "테스트3")))
                .build();
        //when
        Set<ConstraintViolation<ProblemRequestDto>> violations = validator.validate(requestDto);

        //then
        assertThat(violations).isEmpty();
    }

    @Test
    void 리스트_NotNull_유효X_테스트() {

        // given
        ProblemRequestDto requestDto = ProblemRequestDto.builder()
                .title("테스트")
                .content("테스트")
                .link("test.com")
                .level(3)
                .tagList(null)
                .build();

        // when
        Set<ConstraintViolation<ProblemRequestDto>> violations = validator.validate(requestDto);

        // then
        assertThat(violations).isNotEmpty();

    }

    @Test
    void int_NotNull_유효성_테스트() {

        // given
        ProblemRequestDto requestDto = ProblemRequestDto.builder()
                .title("테스트")
                .content("테스트")
                .level(1)
                .link("test.com")
                .tagList(new ArrayList<>(Arrays.asList("테스트1", "테스트2", "테스트3")))
                .build();

        // when
        Set<ConstraintViolation<ProblemRequestDto>> violations = validator.validate(requestDto);

        // then
        assertThat(violations).isEmpty();
        assertThat(requestDto.getLevel()).isEqualTo(1);

    }

}