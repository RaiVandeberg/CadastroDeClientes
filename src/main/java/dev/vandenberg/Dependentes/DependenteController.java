package dev.vandenberg.Dependentes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dependentes")
public class DependenteController {

    @PostMapping("/criar")
    public String dependentes (){ return "Dependentes";}

    @GetMapping("/all")
    public String listarDependentes(){
        return "Dependentes";
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
