package Shopee.api_shopee.dto;

public class FornecedoresCreateDTO {

    private String nome;
    private String contato;
    private String endereco;

    public FornecedoresCreateDTO(){

    }
    public FornecedoresCreateDTO(String nome, String contato, String endereco) {
        this.nome = nome;
        this.contato = contato;
        this.endereco = endereco;

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
