package Carrinho;

class ItemPedido{
    private Produto produto = null;
    private int quantidade;
    private double precoUnitario; //Pela uml acredito ser responsavel por manter o preço original do produto na hora da compra, em caso de descontos.

    //Não quero instancia-la fora de Pedido
    protected ItemPedido(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco();
    }

    public Produto getProduto(){
        return produto;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    //Usado para descontos
    protected void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getSubtotal(){
        return this.quantidade*this.precoUnitario;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}