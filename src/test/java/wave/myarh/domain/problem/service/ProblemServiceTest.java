package wave.myarh.domain.problem.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProblemServiceTest {

    @Autowired
    ProblemService problemService;

    @Test
    @DisplayName("의존성_주입")
    void 의존성_주입Test() {
        Assertions.assertThat(problemService).isNotNull();
    }


}