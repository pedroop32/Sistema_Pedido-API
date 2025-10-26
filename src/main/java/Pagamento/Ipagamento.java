package Pagamento;

public interface Ipagamento {


    public boolean processarPagamento(double quanzas);
    public StatusPagamento getStatus();
    
}
