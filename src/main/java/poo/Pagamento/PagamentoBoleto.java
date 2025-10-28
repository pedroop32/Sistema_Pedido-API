package poo.Pagamento;
import java.time.LocalDate;

public class PagamentoBoleto implements Ipagamento{
    private String codigoBarras = null;
    private StatusPagamento statusPagamento =null;
    private LocalDate dataVencimento = null;
    private double valor=0.0;

    public PagamentoBoleto(String codigoBarras, LocalDate dataVencimento, double valor){
        this.codigoBarras = codigoBarras;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        processarPagamento(this.valor);
    }
    
    @Override
    public boolean processarPagamento(double quanzas){
        if(quanzas>=0){
            this.statusPagamento = StatusPagamento.APROVADO;
            return true;
        } else {
            this.statusPagamento = StatusPagamento.RECUSADO;
            return false;
        }

    }

    @Override
    public StatusPagamento getStatus(){
        return this.statusPagamento;

    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    

}
