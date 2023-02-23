package wave.myarh.domain.member.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wave.myarh.domain.member.dto.LoginSuccessDto;
import wave.myarh.domain.member.dto.TokenDto;
import wave.myarh.domain.member.service.OAuthService;
import wave.myarh.global.auth.AuthCheck;
import wave.myarh.global.dto.ResponseApiDto;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberApiController {

    private final OAuthService oauthService;



    @AuthCheck
    @GetMapping("/check")
    public ResponseEntity<?> checkAuth() {
        return ResponseEntity.ok().body(ResponseApiDto.of(HttpStatus.OK,"권한_확인"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid TokenDto tokenDto) {
        return ResponseEntity.ok().body(ResponseApiDto.of(
                HttpStatus.OK,"토큰_검증_완료",oauthService.googleLogin(tokenDto.getAccessToken()))//todo
        );
    }


}
