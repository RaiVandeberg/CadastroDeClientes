package dev.vandenberg.Dependentes.services;

import dev.vandenberg.Dependentes.DependenteDTO;
import dev.vandenberg.Dependentes.DependenteMapper;
import dev.vandenberg.Dependentes.DependenteModel;
import dev.vandenberg.Dependentes.DependenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependenteService {

    private DependenteRepository dependenteRepository;
    private DependenteMapper dependenteMapper;

    public DependenteService(DependenteRepository dependenteRepository, DependenteMapper dependenteMapper) {
        this.dependenteRepository = dependenteRepository;
        this.dependenteMapper = dependenteMapper;
    }

    public List<DependenteModel> listarDependentes(){

        return dependenteRepository.findAll();
    }
    public DependenteModel buscarDependentePorId(Long id){
        Optional<DependenteModel> dependenteId = dependenteRepository.findById(id);
        return dependenteId.orElse(null);
        //ou ele vai buscar o id ou vai retornar null
    }
    public DependenteDTO criarDependente(DependenteDTO dependenteDTO){
        DependenteModel dependente = dependenteMapper.map(dependenteDTO);
        dependente = dependenteRepository.save(dependente);
       return dependenteMapper.map(dependente);
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
