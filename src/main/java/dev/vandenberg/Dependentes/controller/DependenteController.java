package dev.vandenberg.Dependentes.controller;


import dev.vandenberg.Dependentes.DependenteDTO;
import dev.vandenberg.Dependentes.DependenteModel;
import dev.vandenberg.Dependentes.services.DependenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarDependente(@RequestBody DependenteDTO dependente) {
        DependenteDTO dependenteDTO = dependenteService.criarDependente(dependente);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("dependente cadastrado com sucesso: " + dependenteDTO.getNome() + " (ID: " + dependenteDTO.getId() + ")");
    }


    @GetMapping("/all")
    public ResponseEntity<List<DependenteDTO>> listarDependentes(){

        List <DependenteDTO> dependentes = dependenteService.listarDependentes();
        return ResponseEntity.ok(dependentes);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarDependente(@PathVariable Long id, @RequestBody DependenteDTO dependente) {
       DependenteDTO dependenteDTO = dependenteService.atualizarDependente(id, dependente);

       if(dependenteDTO != null){
           return ResponseEntity.ok(dependenteDTO);
       } else  {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("dependete com o id " + id + " nao encontrado");
       }
    }


    @GetMapping("/{id}")
    public  ResponseEntity<?> buscarDependentePorId(@PathVariable Long id) {
        DependenteDTO dependenteDTO =  dependenteService.buscarDependentePorId(id);

        if( dependenteDTO != null){
            return ResponseEntity.ok(dependenteDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" depende com o id " + id + " nao existe");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarDependentePorId(@PathVariable Long id){

        if(dependenteService.buscarDependentePorId(id) != null){
         dependenteService.deletarDependentePorId(id);
         return ResponseEntity.ok(" Dependente removido com sucesso! id: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(" dependente nao encontrado " + id);
        }
    }
}
