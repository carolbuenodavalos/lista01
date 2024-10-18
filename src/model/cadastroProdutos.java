package model;

public class cadastroProdutos {
    private int idProduto;
    private String nomeProduto;
    private String descricao;
    private float preco;
    private int quantidade;
    
//Construtor    
    public cadastroProdutos()  {
    }
    
    public cadastroProdutos(String nomeProduto, String descricao, float preco, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public cadastroProdutos(int idProduto, String nomeProduto, String descricao, float preco, int quantidade) {
        this.idProduto = idProduto;     
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}