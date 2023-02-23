package wave.myarh.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class TokenDto {

    @NotBlank
    private String accessToken;

}
