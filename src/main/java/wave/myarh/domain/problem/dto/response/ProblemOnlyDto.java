package wave.myarh.domain.problem.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import wave.myarh.domain.problem.domain.ProblemTag;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProblemOnlyDto {

    private Long id;

    private String title;

    private String link;

    private int level;

    private LocalDateTime modifiedDate;

    @JsonIgnoreProperties({"problem"})
    private List<ProblemTag> problemTagList;
}