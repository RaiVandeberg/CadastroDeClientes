package dev.vandenberg.Clients;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.vandenberg.Dependentes.DependenteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
//Entity eke transforma uma classe em uma entidade do bd
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nome;
   private String email;
   private int idade;


   // um cliente pode ter varios dependentes
   @OneToMany(mappedBy =  "clientes", cascade = CascadeType.ALL, orphanRemoval = true)
   @JsonIgnore
   private List<DependenteModel> dependentes;


}
