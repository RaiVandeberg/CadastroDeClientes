package dev.vandenberg.Dependentes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependenteService {

    private DependenteRepository dependenteRepository;

    public DependenteService(DependenteRepository dependenteRepository) {
        this.dependenteRepository = dependenteRepository;
    }

    public List<DependenteModel> listarDependentes(){

        return dependenteRepository.findAll();
    }
    public DependenteModel buscarDependentePorId(Long id){
        Optional<DependenteModel> dependenteId = dependenteRepository.findById(id);
        return dependenteId.orElse(null);
        //ou ele vai buscar o id ou vai retornar null
    }
    public DependenteModel criarDependente(DependenteModel dependente){
        return dependenteRepository.save(dependente);
    }

    public void deletarDependentePorId(Long id){
       dependenteRepository.deleteById(id);
    }

    public DependenteModel atualizarDependente(Long id, DependenteModel dependente){
        if(dependenteRepository.existsById(id)) {
            dependente.setId(id);
            return dependenteRepository.save(dependente);

        }
        return null;
    }

}
