package wave.myarh.domain.problem.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import wave.myarh.domain.review.domain.Review;
import wave.myarh.domain.tag.domain.ProblemTag;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProblemResponseDto {

    private Long id;

    private String title;

    private String link;

    private int level;

    @JsonIgnoreProperties({"problem"})
    private List<Review> reviewList;

    @JsonIgnoreProperties({"problem"})
    private List<ProblemTag> tagList;
}