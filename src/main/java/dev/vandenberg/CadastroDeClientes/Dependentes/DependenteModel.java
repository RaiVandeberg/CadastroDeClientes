package dev.vandenberg.CadastroDeClientes.Dependentes;


import dev.vandenberg.CadastroDeClientes.Clientes.ClientesModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_dependente")
public class DependenteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String dataNascimento;

    private ClientesModel cliente;


}
