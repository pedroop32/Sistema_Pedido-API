package Carrinho;

public class Produto{
    protected String nome;
    protected double preco; 
    protected int estoque = 0; 
    protected String id; 
    protected String descricao; //Deixei como opcional

    public Produto(String nome, double preco, String id, int estoque){
        this.nome = nome;
        this.preco = preco;
        adicionarEstoque(estoque);
        this.id = id;
    }

    public Produto(String nome, double preco, String id, int estoque, String descricao){
        this.nome = nome;
        this.preco = preco;
        adicionarEstoque(estoque);
        this.id = id;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    double getPreco(){
        return this.preco;
    }
    
    
    public void setId(String id) {
        this.id = id;
    }
    
    String getId(){
        return this.id;
    }

    public String getDescricao() {
        return descricao;
    }
    
    //opcinal
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    //Estoque é somado ao anterior
    public void adicionarEstoque(int quantidade){
        if((quantidade + this.estoque)>=0){
            this.estoque += quantidade;
        } else System.out.println("Impossivel adicionar estoque negativo");
    }

    public int getEstoque() {
        return estoque;
    }

    
    

    
}