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

    @PostMapping
    public DependenteModel criarDependente(@RequestBody DependenteModel dependente) {
        return dependenteService.criarDependente(dependente);
    }


    @GetMapping("/all")
    public List<DependenteModel> listarDependentes(){
        return dependenteService.listarDependentes();
    }

    @PutMapping("/{id}")
    public DependenteModel atualizarDependente(@PathVariable Long id, @RequestBody DependenteModel dependente) {
        return dependenteService.atualizarDependente(id, dependente);
    }

    @GetMapping("/{id}")
    public  DependenteModel buscarDependentePorId(@PathVariable Long id){
        return dependenteService.buscarDependentePorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarDependentePorId(@PathVariable Long id){
         dependenteService.deletarDependentePorId(id);
    }
}
