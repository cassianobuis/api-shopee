package Shopee.api_shopee.Entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "UUID")


    @Column (nullable = false)
    private String id;

    @Column (nullable = false)
    private String nome;

    @Column (nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Mercadoria> mercadorias;

    public Categoria() {

    }
    public Categoria(String id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
