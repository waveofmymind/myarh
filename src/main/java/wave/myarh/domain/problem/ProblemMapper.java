package wave.myarh.domain.problem;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wave.myarh.domain.member.domain.Member;
import wave.myarh.domain.problem.domain.Problem;
import wave.myarh.domain.problem.dto.request.ProblemRequestDto;
import wave.myarh.domain.problem.dto.response.ProblemOnlyDto;
import wave.myarh.domain.problem.dto.response.ProblemResponseDto;
import wave.myarh.domain.review.dto.ReviewRequestDto;

@Mapper(componentModel = "spring") // 스프링 빈으로 등록
public interface ProblemMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "writer", source = "member")
    @Mapping(target = "problemTagList",ignore = true)
    @Mapping(target = "reviewList", ignore = true)
    Problem toEntity(ProblemRequestDto requestDto, Member member);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "writer", source = "member")
    @Mapping(target = "problemTagList", ignore = true)
    @Mapping(target = "link", ignore = true)
    @Mapping(target = "level", ignore = true)
    @Mapping(target = "reviewList", ignore = true)
    @Mapping(target = "title", ignore = true)
    Problem toEntity(Long id, ReviewRequestDto requestDto, Member member);

    ProblemResponseDto toDto(Problem problem);

    ProblemOnlyDto toReviewExcludeDto(Problem problem);
}
