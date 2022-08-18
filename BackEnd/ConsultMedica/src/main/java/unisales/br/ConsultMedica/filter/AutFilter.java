package unisales.br.ConsultMedica.filter;

import unisales.br.ConsultMedica.util.JWTUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutFilter implements Filter {


    @Autowired
    private JWTUtil jwtUtil;

 
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String caminho = ((HttpServletRequest) request).getRequestURI();
        String token = jwtUtil.recuperaTokenRequisicao(request);
        String nomeUsuario = jwtUtil.getUsuarioNoToken(token);
        if (nomeUsuario != null) {
            filterChain.doFilter(request, response);
        } else {
        }
    }
}
