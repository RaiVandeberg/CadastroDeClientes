package dev.vandenberg.CadastroDeDependetes.Dependentes;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DependenteController {

    @GetMapping("/dependentes")
    public String dependentes (){ return "Dependentes";}
}
