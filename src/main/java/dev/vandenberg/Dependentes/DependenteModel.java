package dev.vandenberg.Dependentes;



import dev.vandenberg.Clients.ClienteModel;
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
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "data_nascimento")
    private String dataNascimento;


    @ManyToOne
    @JoinColumn(name = "cliente_id" )
    private ClienteModel clientes;

}
