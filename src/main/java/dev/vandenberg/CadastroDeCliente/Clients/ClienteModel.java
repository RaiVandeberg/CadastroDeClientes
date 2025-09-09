package dev.vandenberg.CadastroDeCliente.Clients;

import dev.vandenberg.CadastroDeDependetes.Dependentes.DependenteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
//Entity eke transforma uma classe em uma entidade do bd
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nome;
   private String email;
   private int idade;


   // um cliente pode ter varios dependentes
   @OneToMany(mappedBy =  "clientes")
   private List<DependenteModel> dependentes;


}
