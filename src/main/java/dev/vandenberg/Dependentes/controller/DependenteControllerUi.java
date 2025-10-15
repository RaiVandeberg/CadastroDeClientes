package dev.vandenberg.Dependentes.controller;

import dev.vandenberg.Dependentes.DependenteDTO;
import dev.vandenberg.Dependentes.services.DependenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dependentes/ui")
public class DependenteControllerUi {

    private final DependenteService dependenteService;

    public DependenteControllerUi(DependenteService dependenteService) {
        this.dependenteService = dependenteService;
    }

    @GetMapping("/all")
    public String listarDependentes(Model model) {

        List <DependenteDTO> dependentes = dependenteService.listarDependentes();
        model.addAttribute("dependentes", dependentes);
        return  "dependentes";
    }
}
