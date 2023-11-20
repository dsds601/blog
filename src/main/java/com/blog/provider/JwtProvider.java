package com.blog.provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtProvider {

    private static String SK ;

    @Value("${blog.sk}")
    public static void setSK(String SK) {
        JwtProvider.SK = SK;
    }

    public String create(String email) {

        // 만료 시간 설정
        java.util.Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.ES256, SK)
                .setSubject(email).setIssuedAt(new Date()).setExpiration(expiredDate)
                .compact();

        return jwt;
    }

    // JWT 검증
    public String validate(String jwt) {
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(SK)
                    .parseClaimsJws(jwt).getBody();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return claims.getSubject();
    }
}
