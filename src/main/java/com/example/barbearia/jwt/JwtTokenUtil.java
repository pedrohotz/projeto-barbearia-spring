package com.example.barbearia.jwt;

import com.example.barbearia.models.Usuario;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;
    private String secretKey = "secreto";
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);

    public String generateAcessToken(Usuario user) {
        return Jwts.builder().setSubject(user.getId() + "," + user.getEmail())
                .setIssuer("CodeJava")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error("Expired Token", ex);
        } catch (IllegalArgumentException ex) {
            LOGGER.error("Empty token", ex);
        } catch (MalformedJwtException ex) {
            LOGGER.error("Invalid Token", ex);
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("Not supported token", ex);
        } catch (SignatureException ex) {
            LOGGER.error("Token sign not valid", ex);
        }

        return false;
    }

    public String getSubject(String token) {
        return parseClaims(token).getSubject();
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
