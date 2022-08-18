package unisales.br.ConsultMedica.control;

import unisales.br.ConsultMedica.model.Consulta;
import unisales.br.ConsultMedica.model.ConsultaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unisales.br.ConsultMedica.model.ConsultaRepository;

/**
 *
 * @author Jean Carlos
 */
@RestController
@RequestMapping("/consulta")
//@Controller
public class ConsultaController {

    @Autowired
    ConsultaRepository repo;

    @GetMapping({"/", "/index"})
    public List lista(Model model) {

        List tarefas = repo.findAll(Sort.by("paciente"));
        //model.addAttribute("consulta", tarefas);
        //return "consulta";
        return tarefas;
    }

    @PostMapping({"/cadastro"})
    public Consulta adiciona(@RequestBody Consulta consulta) {

        return repo.save(consulta);
    }

    @GetMapping("/exclui")
    public void esclui(Long id) {

        repo.deleteById(id);
    }

    @GetMapping("/get")
    public Consulta edita(Long id) {

        Consulta consulta = repo.findById(id).get();
        return consulta;
    }

    @GetMapping("/atender")
    public Consulta atender( Long id) {

        Consulta consulta = repo.findById(id).get();
        consulta.setAtendido(Boolean.TRUE);
        return repo.save(consulta);
    }

    @GetMapping("/reabrir")
    public Consulta reabrir(Long id) {

        Consulta consulta = repo.findById(id).get();
        consulta.setAtendido(Boolean.FALSE);
        return repo.save(consulta);
    }

    @RequestMapping(value = "/")
    public String index() {
        return "API de consulta rodando";
    }

}
