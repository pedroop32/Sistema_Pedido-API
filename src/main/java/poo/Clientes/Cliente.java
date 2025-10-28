package poo.Clientes;

public abstract class Cliente {
    protected String nome=null;
    protected String email=null;
    protected String id=null;
    protected String telefone=null;

    public Cliente(String nome, String email, String id, String telefone){
        this.nome = nome;
        this.email = email;
        this.id = id;
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    //cpf ou cnpj no caso dos clientes existentes;
    public abstract String getIdentificadorUnico();
}
