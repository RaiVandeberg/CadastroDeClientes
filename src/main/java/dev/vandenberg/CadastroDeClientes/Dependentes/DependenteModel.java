package dev.vandenberg.CadastroDeClientes.Dependentes;


import dev.vandenberg.CadastroDeCliente.Cliente.ClienteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_dependente")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DependenteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String email;

    private String telefone;
    private String dataNascimento;

    //
    @ManyToOne
    @JoinColumn(name = "cliente_id" )
    private ClienteModel clientes;

}
