package dev.vandenberg.Dependentes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependenteService {

    private DependenteRepository dependenteRepository;

    public DependenteService(DependenteRepository dependenteRepository) {
        this.dependenteRepository = dependenteRepository;
    }

    public List<DependenteModel> listarDependentes(){
      return dependenteRepository.findAll();
    }
}
