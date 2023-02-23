package wave.myarh.domain.member.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.xml.bind.DatatypeConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wave.myarh.domain.member.dto.JwtPayload;
import wave.myarh.global.exception.JsonWriteException;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;

@Slf4j
@Service
public class JwtService {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    @Value("$(jwt.secret}")
    private String SECRET_KEY;

    public String createToken(JwtPayload jwtPayload) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date expireTime = new Date();
        expireTime.setTime(expireTime.getTime() + 1000*60*30*60);
        byte[] decodeSecret = DatatypeConverter.parseBase64Binary(SECRET_KEY);

        HashMap<String, Object> headerMap = new HashMap<>();

        headerMap.put("typ", "JWT");
        headerMap.put("alg", "HS256");

        Key signingKey = new SecretKeySpec(decodeSecret, signatureAlgorithm.getJcaName());

        try {
            return Jwts.builder()
                    .setHeader(headerMap)
                    .setSubject(objectMapper.writeValueAsString(jwtPayload))
                    .setExpiration(expireTime)
                    .signWith(signingKey,signatureAlgorithm)
                    .compact();
        } catch (JsonProcessingException e) {
            throw new JsonWriteException();
        }

    }

    public JwtPayload getPayload(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return objectMapper.readValue(claims.getSubject(), JwtPayload.class);

        } catch (JsonProcessingException | IllegalArgumentException | MalformedJwtException e) {
            throw new JsonWriteException();
        }
    }
}
