package poo.Carrinho;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import poo.Clientes.Cliente;
import poo.Pagamento.Ipagamento;

public class Pedido {
    private LocalDate data;
    private Cliente cliente = null;
    private List<ItemPedido> itens = null;
    private Ipagamento metodoPagamento;
    private StatusPedido statusPedido;

    public Pedido(LocalDate data, Cliente cliente, Ipagamento metodoPagamento, StatusPedido statusPedido){
        this.data = data;
        this.cliente = cliente;
        this.metodoPagamento = metodoPagamento;
        this.statusPedido = statusPedido;
        itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (produto != null && quantidade >= 0) {

            boolean existe = false;

            for (int cont = 0; cont < itens.size(); cont++) {
                if (itens.get(cont).getProduto().equals(produto)) {
                    int antes=0;
                    existe = true;
                    antes += itens.get(cont).getQuantidade();
                    // acessa o produto dentro do item e altera algo nele
                    itens.get(cont).setQuantidade(antes + quantidade);
                    break;
                }
            }

            if (!existe) { // evitar repetição
                ItemPedido pedido = new ItemPedido(produto, quantidade);
                itens.add(pedido);
            }

        
        }
    }

    double calcularTotal(){
        double total=0;
        for(int cont=0; cont<itens.size(); cont++){
            total += itens.get(cont).getQuantidade() * itens.get(cont).getPrecoUnitario();
        }
        return total;
    }
    void removerItem(ItemPedido item){
        itens.remove(item);
    }
    //porcentagem de 0 a 1;
    //aplica o desconto para cada instancia da lista itemPedio
    void aplicarDesconto(double cent){
        for(int cont=0; cont<itens.size(); cont++){
            itens.get(cont).setPrecoUnitario(itens.get(cont).getPrecoUnitario()*(1-cent));
        }
    }

    public boolean confirmarPedido(){
        
    if (this.statusPedido != StatusPedido.PENDENTE) return false;
    
    if (this.metodoPagamento == null)  return false;

    
    boolean pagamentoProcessado = metodoPagamento.processarPagamento(this.calcularTotal());
    
    if (pagamentoProcessado) this.statusPedido = StatusPedido.PROCESSANDO;
    
    return pagamentoProcessado;
}
    
    public List<ItemPedido> getItens(){
        return this.itens;
    }

    public LocalDate getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Ipagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    

}

