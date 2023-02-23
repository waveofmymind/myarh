package wave.myarh.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginSuccessDto {
    private String nickname;
    private String access_token;
}