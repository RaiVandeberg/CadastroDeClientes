package dev.vandenberg.Dependentes.controller;


import dev.vandenberg.Dependentes.DependenteDTO;
import dev.vandenberg.Dependentes.DependenteModel;
import dev.vandenberg.Dependentes.services.DependenteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dependentes")
public class DependenteController {

    private DependenteService dependenteService;

    public DependenteController(DependenteService dependenteService) {
        this.dependenteService = dependenteService;
    }

    @PostMapping
    public DependenteDTO criarDependente(@RequestBody DependenteDTO dependente) {
        return dependenteService.criarDependente(dependente);
    }


    @GetMapping("/all")
    public List<DependenteDTO> listarDependentes(){
        return dependenteService.listarDependentes();
    }

    @PutMapping("/{id}")
    public DependenteDTO atualizarDependente(@PathVariable Long id, @RequestBody DependenteDTO dependente) {
        return dependenteService.atualizarDependente(id, dependente);
    }

    @GetMapping("/{id}")
    public  DependenteDTO buscarDependentePorId(@PathVariable Long id){
        return dependenteService.buscarDependentePorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarDependentePorId(@PathVariable Long id){
         dependenteService.deletarDependentePorId(id);
    }
}
