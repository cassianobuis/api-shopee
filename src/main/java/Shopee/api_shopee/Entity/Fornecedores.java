package Shopee.api_shopee.Entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "fornedores")
public class Fornecedores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")


    @Column(nullable = false,updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String nome;


    @Column(nullable = false)
    private String contato;


    @Column(nullable = false)
    private String endereco;


    @OneToMany(mappedBy = "fornecedores")
    private List<Mercadoria> mercadorias;

    public Fornecedores() {

    }
    public Fornecedores(UUID id, String nome, String contato, String endereco) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
        this.endereco = endereco;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
