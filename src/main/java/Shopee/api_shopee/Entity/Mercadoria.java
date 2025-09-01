package Shopee.api_shopee.Entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "mercadoria")
public class Mercadoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "UUID")
    @Column(nullable = false,updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private String categoria;



    @ManyToOne
    @JoinColumn(name = "categoria_id",nullable = false)
    private Categoria categoriaId;

    @ManyToOne
    @JoinColumn(name = "fornecedores_id",nullable = false)
    private Fornecedores fornecedoresId;




    public Mercadoria (){
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Mercadoria(String nome, double preco, int quantidade, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;

    }
}
