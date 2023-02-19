package wave.myarh.domain.problem.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wave.myarh.domain.problem.dto.request.ProblemRequestDto;
import wave.myarh.domain.problem.dto.response.ProblemOnlyDto;
import wave.myarh.domain.problem.dto.response.ProblemResponseDto;
import wave.myarh.domain.problem.service.ProblemService;
import wave.myarh.global.dto.ResponseApiDto;

import java.util.List;

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
        ProblemResponseDto responseDto = problemService.getProblemById(problemId);

        return ResponseEntity.ok().body(ResponseApiDto.of(HttpStatus.OK,"문제_조회_성공",responseDto));
    }

    @GetMapping
    public ResponseEntity<?> getProblemList(@RequestParam("page") int size) {

        List<ProblemOnlyDto> problemDtoList = problemService.getProblemList(PageRequest.of(0,size));
        return ResponseEntity.ok().body(ResponseApiDto.of(HttpStatus.OK,"문제_전체_조회_성공",problemDtoList));
    }

    @DeleteMapping("/{problemId}")
    public ResponseEntity<?> deleteProblem(@PathVariable("problemId") Long problemId) {
        problemService.deleteProblem(problemId);
        return ResponseEntity.ok().body(ResponseApiDto.of(HttpStatus.OK,"문제_삭제_성공"));
    }
}
