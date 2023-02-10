package wave.myarh.domain.problem.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wave.myarh.domain.problem.dto.request.ProblemRequestDto;
import wave.myarh.domain.problem.service.ProblemService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/problems")
public class ProblemApiController {

    private final ProblemService problemService;

    @PostMapping
    public ResponseEntity<?> addProblem(@RequestBody ProblemRequestDto requestDto) {
        problemService.registerProblem(requestDto);
    }
}
