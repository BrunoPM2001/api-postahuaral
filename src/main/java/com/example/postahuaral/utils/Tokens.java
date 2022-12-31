package com.example.postahuaral.utils;

import com.example.postahuaral.models.Usuario;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
@Component
public class Tokens {

    @Value("${security.jwt.secret}")
    private String key;

    @Value("${security.jwt.issuer}")
    private String issuer;

    @Value("${security.jwt.ttlMillis}")
    private long ttlMillis;

    private final Logger log = LoggerFactory
            .getLogger(Tokens.class);


    public String createToken(Usuario usuario) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] apiKey = Base64.getDecoder().decode(key);
        Key signinKey = new SecretKeySpec(apiKey, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder()
                .setId(Integer.toString(usuario.getIdusuario()))
                .setIssuedAt(now)
                .setSubject(usuario.getCorreo())
                .claim("nombre", usuario.getPaciente().getNombres())
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signinKey);

        if(ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    public String validateToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(Base64.getDecoder().decode(key))
                .parseClaimsJws(token).getBody();

        return claims.get("nombre", String.class);
    }
}
