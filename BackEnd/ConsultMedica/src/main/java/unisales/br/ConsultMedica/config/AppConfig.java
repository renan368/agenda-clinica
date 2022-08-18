
package unisales.br.ConsultMedica.config;

import unisales.br.ConsultMedica.filter.AutFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Autowired
    private AutFilter autFilter;

  
    @Bean
    public FilterRegistrationBean<AutFilter> filterRegistrationBean() {
        FilterRegistrationBean<AutFilter> registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(autFilter);
        registrationBean.addUrlPatterns("/tarefa/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
