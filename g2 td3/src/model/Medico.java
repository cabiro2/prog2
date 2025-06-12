package model;

public class Medico extends Pessoa {
    private String crm;
    private String especialidade;
    
    public Medico(String nome, String cpf, String telefone, String email, String crm, String especialidade) {
        super(nome, cpf, telefone, email);
        this.crm = crm;
        this.especialidade = especialidade;
    }
    
    public String getCrm() {
        return crm;
    }
    
    public void setCrm(String crm) {
        this.crm = crm;
    }
    
    public String getEspecialidade() {
        return especialidade;
    }
    
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    @Override
    public void exibirDados() {
        System.out.println("MÉDICO - Nome: " + nome + " | CPF: " + cpf + 
                          " | Telefone: " + telefone + " | Email: " + email +
                          " | CRM: " + crm + " | Especialidade: " + especialidade);
    }
}
