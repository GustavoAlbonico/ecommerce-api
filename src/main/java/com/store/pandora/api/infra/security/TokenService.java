package com.store.pandora.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.store.pandora.api.entitys.Usuario;
import com.store.pandora.api.utils.CustomException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${spring.security.token.secret}")
    private  String secret;
    public String gerarToken(Usuario usuario) throws CustomException {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer("store-pandora-api")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(this.gerarExpiracaoData())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException ex){
            ex.printStackTrace();
            throw new CustomException("Erro ao gerar token!");
        }
    }

    public String validaToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("store-pandora-api")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException ex){
            return null;
        }
    }

    private Instant gerarExpiracaoData(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
