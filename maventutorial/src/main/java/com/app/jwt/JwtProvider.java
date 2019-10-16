package com.app.jwt;

import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final String jwt_secret = "secret";
    private final long jwt_expiration = 604800000L;

    public String generateJwtToken(User user) {
        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + jwt_expiration);
        return
                Jwts.builder()
                        .setSubject(user.getUsername())
                        .setIssuedAt(now)
                        .setExpiration(expiredDate)
                        .signWith(SignatureAlgorithm.HS512, jwt_secret)
                        .compact();
    }

    public String getUserEmailFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwt_secret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwt_secret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            System.out.println("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            System.out.println("JWT claims string is empty.");
        }
        return false;
    }
}
