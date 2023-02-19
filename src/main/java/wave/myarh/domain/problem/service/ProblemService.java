package wave.myarh.domain.problem.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wave.myarh.domain.problem.ProblemMapper;
import wave.myarh.domain.problem.domain.Problem;
import wave.myarh.domain.problem.domain.ProblemTag;
import wave.myarh.domain.problem.domain.Tag;
import wave.myarh.domain.problem.dto.request.ProblemRequestDto;
import wave.myarh.domain.problem.dto.response.ProblemOnlyDto;
import wave.myarh.domain.problem.dto.response.ProblemResponseDto;
import wave.myarh.domain.problem.repository.ProblemRepository;
import wave.myarh.domain.problem.repository.TagRepository;
import wave.myarh.domain.review.ReviewMapper;
import wave.myarh.domain.review.domain.Review;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProblemService {

    private final ProblemRepository problemRepository;
    private final TagRepository tagRepository;

    private final ProblemMapper problemMapper;
    private final ReviewMapper reviewMapper;
    @Transactional
    public Long registerProblem(ProblemRequestDto requestDto) {
        Problem problem = problemMapper.toEntity(requestDto);
        Review review = reviewMapper.toEntity(problem, requestDto);
        List<ProblemTag> problemTagList = requestDto.getTagList().stream().map(tagName -> tagRepository.findByTagName(tagName)
                        .map(tag -> new ProblemTag(problem, tag)).orElseGet(
                                () -> new ProblemTag(problem, new Tag(tagName))))
                .toList();
        problem.setReview(review);
        problem.setProblemTagList(problemTagList);

        return problemRepository.save(problem).getId();
    }

    public ProblemResponseDto getProblemById(Long problemId) {
        Problem problem = problemRepository.findById(problemId)
                .orElseThrow(EntityNotFoundException::new);
        return problemMapper.toDto(problem);
    }

    @Transactional(readOnly = true)
    public List<ProblemOnlyDto> getProblemList(Pageable pageable) {
        List<Problem> problems = problemRepository.findByOrderByCreatedDateDesc(pageable);
        return problems.stream().map(problemMapper::toReviewExcludeDto).toList();

    }

    //페이징 리스트 todo





    public void deleteProblem(Long problemId) {
        problemRepository.deleteById(problemId);
    }





}



