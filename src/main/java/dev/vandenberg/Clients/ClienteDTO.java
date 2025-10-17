package dev.vandenberg.Clients;

import dev.vandenberg.Dependentes.DependenteModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private List<DependenteModel> dependentes; // plural e lista
}
