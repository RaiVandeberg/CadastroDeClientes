package dev.vandenberg.Dependentes.services;

import dev.vandenberg.Dependentes.DependenteDTO;
import dev.vandenberg.Dependentes.DependenteMapper;
import dev.vandenberg.Dependentes.DependenteModel;
import dev.vandenberg.Dependentes.DependenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DependenteService {

    private DependenteRepository dependenteRepository;
    private DependenteMapper dependenteMapper;

    public DependenteService(DependenteRepository dependenteRepository, DependenteMapper dependenteMapper) {
        this.dependenteRepository = dependenteRepository;
        this.dependenteMapper = dependenteMapper;
    }

    public List<DependenteDTO> listarDependentes(){
        List<DependenteModel> dependentes = dependenteRepository.findAll();
        return dependentes.stream()
                .map(dependenteMapper::map)
                .collect(Collectors.toList());
    }

    public DependenteDTO buscarDependentePorId(Long id){
        Optional<DependenteModel> dependenteId = dependenteRepository.findById(id);
        return dependenteId.map(dependenteMapper::map).orElse(null);
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

    public DependenteDTO atualizarDependente(Long id, DependenteDTO dependente){
        Optional<DependenteModel> DependenteExistente = dependenteRepository.findById(id);
        if(DependenteExistente.isPresent()){
            DependenteModel dependenteAtualizado = dependenteMapper.map(dependente);
            dependenteAtualizado.setId(id);
            DependenteModel dependenteSalvo = dependenteRepository.save(dependenteAtualizado);
            return dependenteMapper.map(dependenteSalvo);
        }
        return null;
    }

}
