package dev.vandenberg.Dependentes;


import org.springframework.stereotype.Component;

@Component
public class DependenteMapper {


    public DependenteModel map(DependenteDTO dependenteDTO) {

    DependenteModel dependenteModel = new DependenteModel();
    dependenteModel.setId(dependenteDTO.getId());
    dependenteModel.setNome(dependenteDTO.getNome());
    dependenteModel.setEmail(dependenteDTO.getEmail());
    dependenteModel.setTelefone(dependenteDTO.getTelefone());
    dependenteModel.setDataNascimento(dependenteDTO.getDataNascimento());
    dependenteModel.setPagaments(dependenteDTO.getPagaments());
    dependenteModel.setClientes(dependenteDTO.getClientes());

    return dependenteModel;
    }

    public DependenteDTO map(DependenteModel dependenteModel) {

        DependenteDTO dependenteDTO = new DependenteDTO();
        dependenteDTO.setId(dependenteModel.getId());
        dependenteDTO.setNome(dependenteModel.getNome());
        dependenteDTO.setEmail(dependenteModel.getEmail());
        dependenteDTO.setTelefone(dependenteModel.getTelefone());
        dependenteDTO.setDataNascimento(dependenteModel.getDataNascimento());
        dependenteDTO.setPagaments(dependenteModel.getPagaments());
        dependenteDTO.setClientes(dependenteModel.getClientes());

        return dependenteDTO;
    }
}
