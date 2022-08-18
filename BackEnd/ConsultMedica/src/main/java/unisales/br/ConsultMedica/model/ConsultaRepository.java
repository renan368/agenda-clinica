package unisales.br.ConsultMedica.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jean Carlos
 */
@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    
    
    
}
