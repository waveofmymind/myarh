package wave.myarh.domain.problem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProblemRequestDto {

    @NotBlank
    private String title;

    @NotNull
    private String link;

    private int level;

    @NotNull
    private ArrayList<String> tagList;

    @NotBlank
    private String content;

}