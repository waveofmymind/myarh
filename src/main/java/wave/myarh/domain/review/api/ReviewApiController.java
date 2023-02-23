package wave.myarh.domain.review.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wave.myarh.domain.member.domain.Member;
import wave.myarh.domain.problem.service.ProblemService;
import wave.myarh.domain.review.dto.ReviewRequestDto;
import wave.myarh.domain.review.service.ReviewService;
import wave.myarh.global.auth.MemberContext;
import wave.myarh.global.dto.ResponseApiDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewApiController {

    private final ProblemService problemService;
    
    private final ReviewService reviewService;
    @GetMapping("/problems/{problemId}/reviews")
    public ResponseEntity<?> addReview (@PathVariable("problemId") Long problemId,
                                                     @RequestBody ReviewRequestDto requestDto) {
        Member member = MemberContext.currentMember.get();
        reviewService.addReview(problemId,requestDto,member);
        return ResponseEntity.ok().body(ResponseApiDto.of(HttpStatus.OK,"리뷰_등록_성공"));
    }

    @PutMapping("/problems/{problemId}/reviews/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable("problemId") Long problemId,
                                          @PathVariable("reviewId") Long reviewId,
                                          @RequestBody @Valid ReviewRequestDto requestDto) {
        //todo
        return ResponseEntity.ok().body(ResponseApiDto.of(HttpStatus.OK,"리뷰_수정_완료"));
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable("reviewId") Long reviewId) {

        reviewService.deleteReview(reviewId);
        return ResponseEntity.ok().body(ResponseApiDto.of(HttpStatus.OK, "리뷰_삭제_완료"));
    }
}
