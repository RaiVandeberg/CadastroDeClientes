package dev.vandenberg.Clients;

import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteModel map(ClienteDTO dto) {
        ClienteModel model = new ClienteModel();
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setEmail(dto.getEmail());
        model.setIdade(dto.getIdade());
        model.setDependentes(dto.getDependentes());
        return model;
    }

    public ClienteDTO map(ClienteModel model) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setEmail(model.getEmail());
        dto.setIdade(model.getIdade());
        dto.setDependentes(model.getDependentes());
        return dto;
    }
}
