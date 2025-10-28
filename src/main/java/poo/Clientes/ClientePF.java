package poo.Clientes;

import java.time.LocalDate;

public class ClientePF extends Cliente{
    private String cpf=null;
    private LocalDate dataNascimento =null;

    public ClientePF(String nome, String email, String id, String telefone, String cpf, LocalDate dataNascimento){
        super(nome, email, id, telefone);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getCPF(){
        return cpf;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    @Override
    public String getIdentificadorUnico() {
        
        return cpf;
    }
}
