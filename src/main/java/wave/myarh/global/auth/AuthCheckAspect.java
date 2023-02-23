package wave.myarh.global.auth;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import wave.myarh.domain.member.domain.Member;
import wave.myarh.domain.member.dto.JwtPayload;
import wave.myarh.domain.member.repository.MemberRepository;
import wave.myarh.domain.member.service.JwtService;
import wave.myarh.global.exception.UserAuthenticationException;

import java.util.Optional;

@Slf4j
@Aspect
@RequiredArgsConstructor
@Component
public class AuthCheckAspect {

    private static final String AUTHORIZATION = "Authorization";

    private final JwtService jwtService;
    private final MemberRepository memberRepository;

    private final HttpServletRequest httpServletRequest;

    @Around("@annotation(wave.myarh.global.auth.AuthCheck)")
    public Object authCheck(ProceedingJoinPoint pjp) throws Throwable {
        String token = httpServletRequest.getHeader(AUTHORIZATION);

        JwtPayload payload = jwtService.getPayload(token);
        log.info("AuthCheck(email) : " + payload.getEmail());

        Optional<Member> member = memberRepository.findByEmail(payload.getEmail());
        if (member.isEmpty()) {
            throw new UserAuthenticationException();
        }

        MemberContext.currentMember.set(member.get());
        return pjp.proceed();

    }
}
