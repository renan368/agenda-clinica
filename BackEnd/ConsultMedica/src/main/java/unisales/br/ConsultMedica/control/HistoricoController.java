package unisales.br.ConsultMedica.control;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unisales.br.ConsultMedica.model.ConsultaRepository;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    private ConsultaRepository repository;

    @GetMapping({"/exibir"})
    public List lista(Model model) {
        List consultas = repository.findAll(Sort.by("paciente"));
        return consultas;
    }
    
    @DeleteMapping("/exclui")
    public void exclui(Long id) {
        repository.deleteById(id);
    }

}
