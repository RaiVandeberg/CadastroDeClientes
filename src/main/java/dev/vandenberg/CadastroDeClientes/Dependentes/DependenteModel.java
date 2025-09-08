package dev.vandenberg.CadastroDeClientes.Dependentes;


import dev.vandenberg.CadastroDeCliente.Cliente.ClienteModel;
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

    //
    @ManyToOne
    @JoinColumn(name = "cliente_id" )
    private ClienteModel clientes;


    public DependenteModel() {

    }

    public DependenteModel(String dataNascimento, String telefone, String email, String nome, Long id) {

        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.nome = nome;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
