package dev.vandenberg.Dependentes;

import dev.vandenberg.Clients.ClienteModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DependenteDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String dataNascimento;
    private ClienteModel clientes;
    private Integer  pagaments;

}
