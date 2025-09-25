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
}
