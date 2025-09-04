package dev.vandenberg.CadastroDeCliente.Cliente;

import dev.vandenberg.CadastroDeClientes.Dependentes.DependenteModel;
import jakarta.persistence.*;

import java.util.List;
//Entity eke transforma uma classe em uma entidade do bd
@Entity
@Table(name = "tb_cadastro")
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
