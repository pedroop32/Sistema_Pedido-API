package poo.Clientes;

public class ClientePJ extends Cliente{
    private String cnpj=null;
    private String razaoSocial =null;
    private String inscricaoEstadual =null;

    public ClientePJ(String nome, String email, String id, String telefone, 
                    String cnpj, String razaoSocial, String inscricaoEstadual){
        super(nome, email, id, telefone);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    

    public String getCNPJ() {
        return cnpj;
    }



    public String getRazaoSocial() {
        return razaoSocial;
    }



    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }



    @Override
    public String getIdentificadorUnico() {
        
        return cnpj;
    }
}