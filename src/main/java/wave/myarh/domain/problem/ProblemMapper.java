package wave.myarh.domain.problem;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wave.myarh.domain.problem.domain.Problem;
import wave.myarh.domain.problem.dto.request.ProblemRequestDto;
import wave.myarh.domain.problem.dto.response.ProblemOnlyDto;
import wave.myarh.domain.problem.dto.response.ProblemResponseDto;

@Mapper(componentModel = "spring") // 스프링 빈으로 등록
public interface ProblemMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "problemTagList",ignore = true)
    @Mapping(target = "reviewList", ignore = true)
    Problem toEntity(ProblemRequestDto requestDto);

    ProblemResponseDto toDto(Problem problem);

    ProblemOnlyDto toReviewExcludeDto(Problem problem);
}
