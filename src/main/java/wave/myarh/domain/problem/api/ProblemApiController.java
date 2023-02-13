package wave.myarh.domain.problem.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wave.myarh.domain.problem.dto.request.ProblemRequestDto;
import wave.myarh.domain.problem.dto.response.ProblemResponseDto;
import wave.myarh.domain.problem.service.ProblemService;
import wave.myarh.global.dto.ResponseApiDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/problems")
public class ProblemApiController {

    private final ProblemService problemService;

    @PostMapping
    public ResponseEntity<?> addProblem(@RequestBody ProblemRequestDto requestDto) {
        Long problemId = problemService.registerProblem(requestDto);
        return ResponseEntity.ok().body(ResponseApiDto.of(HttpStatus.OK,"문제_등록_성공",problemId));
    }

    @GetMapping("/{problemId}")
    public ResponseEntity<?> getProblem(@PathVariable("problemId") Long problemId) {
        ProblemResponseDto responseDto = problemService.findProblemById(problemId);

        return ResponseEntity.ok().body(ResponseApiDto.of(HttpStatus.OK,"문제_조회_성공",responseDto));
    }

    @DeleteMapping("/{problemId}")
    public ResponseEntity<?> deleteProblem(@PathVariable("problemId") Long problemId) {
        problemService.deleteProblem(problemId);
        return ResponseEntity.ok().body(ResponseApiDto.of(HttpStatus.OK,"문제_삭제_성공"));
    }
}
