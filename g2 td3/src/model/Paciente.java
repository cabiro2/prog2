package model;

public class Paciente extends Pessoa {
    private String convenio;
    private String numeroCartao;
    
    public Paciente(String nome, String cpf, String telefone, String email, String convenio, String numeroCartao) {
        super(nome, cpf, telefone, email);
        this.convenio = convenio;
        this.numeroCartao = numeroCartao;
    }
    
    public String getConvenio() {
        return convenio;
    }
    
    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }
    
    public String getNumeroCartao() {
        return numeroCartao;
    }
    
    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
    
    @Override
    public void exibirDados() {
        System.out.println("PACIENTE - Nome: " + nome + " | CPF: " + cpf + 
                          " | Telefone: " + telefone + " | Email: " + email +
                          " | Convênio: " + convenio + " | Cartão: " + numeroCartao);
    }
}

