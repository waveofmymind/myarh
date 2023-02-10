package wave.myarh.domain.problem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wave.myarh.domain.problem.ProblemMapper;
import wave.myarh.domain.problem.domain.Problem;
import wave.myarh.domain.problem.domain.ProblemTag;
import wave.myarh.domain.problem.dto.request.ProblemRequestDto;
import wave.myarh.domain.problem.repository.ProblemRepository;
import wave.myarh.domain.problem.repository.TagRepository;
import wave.myarh.domain.review.ReviewMapper;
import wave.myarh.domain.review.domain.Review;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemRepository problemRepository;
    private final TagRepository tagRepository;

    private final ProblemMapper problemMapper;
    private final ReviewMapper reviewMapper;

    public Long registerProblem(ProblemRequestDto requestDto) {
        Problem problem = problemMapper.toEntity(requestDto);
        Review review = reviewMapper.toEntity(requestDto,problem);
        requestDto.getTagList().stream().map(tagName -> tagRepository.findByTagName(tagName))
                .map(tag -> new ProblemTag(problem,tag)).orElseGet()//todo

        })



    }


}
