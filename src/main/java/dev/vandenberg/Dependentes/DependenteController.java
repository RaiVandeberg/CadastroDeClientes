package dev.vandenberg.Dependentes;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dependentes")
public class DependenteController {

    private  DependenteService dependenteService;

    public DependenteController(DependenteService dependenteService) {
        this.dependenteService = dependenteService;
    }

    @PostMapping("/criar")
    public String dependentes (){
        return "Dependentes";
    }

    @GetMapping("/all")
    public List<DependenteModel> listarDependentes(){
        return dependenteService.listarDependentes();
    }

    @PutMapping("/id")
    public  String atualizarDependentePorId(){
        return "Atualizar dependente";
    }

    @GetMapping("/id")
    public  String mostrarDependentePorId(){
        return "Mostrar dependente";
    }

    @DeleteMapping("/id")
    public  String deletarDependentePorId(){
        return "Deletar dependente";
    }
}
