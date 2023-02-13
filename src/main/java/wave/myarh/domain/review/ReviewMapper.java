package wave.myarh.domain.review;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wave.myarh.domain.problem.domain.Problem;
import wave.myarh.domain.problem.dto.request.ProblemRequestDto;
import wave.myarh.domain.review.domain.Review;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(target="problem", source = "problem")
    @Mapping(target = "id",ignore = true)
    Review toEntity(ProblemRequestDto requestDto,Problem problem);


}
