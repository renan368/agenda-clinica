package unisales.br.ConsultMedica.control;

import unisales.br.ConsultMedica.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LoginController {

    @Autowired
    JWTUtil jwtUtil;

   
    @PostMapping("/login")
    public String logar(String usuario, String senha) {
        if (usuario != null && !usuario.isEmpty() && senha != null && !senha.isEmpty()) {
            if (usuario.equals("usuario") && senha.equals("1234")) {
                String token = jwtUtil.geraTokenUsuario(usuario);
                return token;
            } else {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "USUÁRIO OU SENHA INVÁLIDOS");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "CREDENCIAIS INVÁLIDAS");
        }
    }
}

