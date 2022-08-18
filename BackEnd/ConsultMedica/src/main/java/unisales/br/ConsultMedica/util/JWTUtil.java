package unisales.br.ConsultMedica.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil implements Serializable {

    public static final long VALIDADE_TOKEN_JWT = 5 * 60 * 60 * 1000; // 5 horas
    private final String SEGREDO = "SEGREDOsegreDAO45622__)()(asasdsdsds___sXXSDS!|7454545ddsddsDDDD";

    private SecretKey CHAVE() {
        return Keys.hmacShaKeyFor(SEGREDO.getBytes(StandardCharsets.UTF_8));
    }

    public Claims extraiTodosDados(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(CHAVE())
                .build().parseClaimsJws(token).getBody();
    }

    public <T> T extraiDado(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extraiTodosDados(token);
        return claimsResolver.apply(claims);
    }

    public String getUsuarioNoToken(String token) {
        if (token == null) {
            return null;
        }

        return extraiDado(token, Claims::getSubject);
    }

    public Date getDataValidadeToken(String token) {
        return extraiDado(token, Claims::getExpiration);
    }

    private Boolean tokenExpirado(String token) {
        if (token == null) {
            return true;
        }
        final Date expiration = getDataValidadeToken(token);
        return expiration.before(new Date());
    }

    public String geraTokenUsuario(String nomeUsuario) {
        Map<String, Object> claims = new HashMap<>();
        return geraToken(claims, nomeUsuario);
    }

    public String geraTokenUsuario(String nomeUsuario, Map<String, Object> claims) {
        return geraToken(claims, nomeUsuario);
    }

    private String geraToken(Map<String, Object> claims, String nomeUsuario) {
        JwtBuilder builder = Jwts.builder()
                .setSubject(nomeUsuario)
                .setExpiration(new Date(System.currentTimeMillis() + VALIDADE_TOKEN_JWT))
                .signWith(CHAVE(), SignatureAlgorithm.HS256);
        builder.addClaims(claims);
        String jwtToken = builder.compact();
        return jwtToken;
    }

  
    public Boolean validaToken(String token, String nomeUsuario) {
        final String _nomeUsuario = getUsuarioNoToken(token);
        return (nomeUsuario.equals(_nomeUsuario) && !tokenExpirado(token));
    }

   
    public Boolean validaToken(String token) {
        return (!tokenExpirado(token));
    }


    public String recuperaTokenRequisicao(HttpServletRequest request) {
        String requestTokenHeader = request.getHeader("Authorization");
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            return requestTokenHeader.substring(7);
        }
        return null;
    }
}
