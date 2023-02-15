package wave.myarh.domain.review;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wave.myarh.domain.problem.domain.Problem;
import wave.myarh.domain.problem.dto.request.ProblemRequestDto;
import wave.myarh.domain.review.domain.Review;
import wave.myarh.domain.review.dto.ReviewRequestDto;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(target="problem", source = "problem")
    @Mapping(target = "id",ignore = true)
    Review toEntity(ProblemRequestDto requestDto,Problem problem);

    @Mapping(target = "problem", source = "problem")
    @Mapping(target = "id", ignore = true)
    Review toEntity(Problem problem, ReviewRequestDto requestDto);

    //문제 수정할 때
    @Mapping(target = "problem", ignore = true)
    @Mapping(target = "id", source = "id")
    Review toEntity(Long id, ReviewRequestDto requestDto);
}
