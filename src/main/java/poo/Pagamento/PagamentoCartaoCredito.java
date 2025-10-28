package poo.Pagamento;

import java.time.LocalDate;

public class PagamentoCartaoCredito implements Ipagamento{
    private String numeroCartao = null;
    private String nomeTitular = null;
    private StatusPagamento statusPagamento =null;
    private LocalDate dataValidade = null;
    private double valor = 0.0;

    //Na uml não existe valor em cartão de credito, mas eu coloquei mesmo assim
    public PagamentoCartaoCredito(String numeroCartao, LocalDate dataValidade, StatusPagamento statusPagamento, String nomeTitular, double valor){
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.statusPagamento = statusPagamento;
        this.dataValidade = dataValidade;
        this.valor = valor;
        processarPagamento(this.valor);
    }

    @Override
    public boolean processarPagamento(double quanzas){
        if(quanzas<5000){
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
    
    public String getNumeroCartao() {
        return numeroCartao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public double getValor() {
        return valor;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }
    
    
}
