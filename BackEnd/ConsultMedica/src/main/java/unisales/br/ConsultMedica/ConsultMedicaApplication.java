package unisales.br.ConsultMedica;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class ConsultMedicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsultMedicaApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
//não exige credenciais
        config.setAllowCredentials(false);
//permite acesso de qualquer origem
        config.addAllowedOrigin("*");
//permite acesso com qualquer header http
        config.addAllowedHeader("*");
//essas configurações são para permitir métodos específicos
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
//aplica esse filtro em todos os endpoints da API
        source.registerCorsConfiguration("/**", config);
//registra o filtro na aplicação
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//indica ordem de execução desse filtro (no caso será o primeiro a ser executado sempre em todas as requisições)
        bean.setOrder(0);
        return bean;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("Auth JWT"))
                .components(new Components()
                        .addSecuritySchemes("Auth JWT",
                                new SecurityScheme()
                                        .name("Auth JWT")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("Bearer")
                                        .bearerFormat("JWT")
                        )
                )
                .info(new Info()
                        .title("Agenda Clinica")
                        .version("1.0.0")
                        .description("REST API para agenda clinica")
                );
    }
}
