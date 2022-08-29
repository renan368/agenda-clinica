
package unisales.br.ConsultMedica.control;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unisales.br.ConsultMedica.model.Medico;
import unisales.br.ConsultMedica.model.MedicoRepository;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    
    @Autowired
    MedicoRepository repo;

    @GetMapping({"/medicos"})
    public List lista(Model model) {

        List medicos = repo.findAll(Sort.by("name"));
        return medicos;
    }

    @PostMapping({"/cadastro-medico"})
    public Medico adiciona(@RequestBody Medico medico) {

        return repo.save(medico);
    }
    
    @GetMapping("/getById")
    public Medico edita(Long id) {

        Medico medico = repo.findById(id).get();
        return medico;
    }

    @GetMapping("/exclui")
    public void exclui(Long id) {

        repo.deleteById(id);
    }
}
