package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consulta implements Exibivel {
    private static int contadorId = 1;
    private int id;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHora;
    private String observacoes;
    
    public Consulta(Paciente paciente, Medico medico, LocalDateTime dataHora, String observacoes) {
        this.id = contadorId++;
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.observacoes = observacoes;
    }
    
    public int getId() {
        return id;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public Medico getMedico() {
        return medico;
    }
    
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    
    public String getObservacoes() {
        return observacoes;
    }
    
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    @Override
    public void exibirDados() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("CONSULTA #" + id + " - Paciente: " + paciente.getNome() + 
                          " | Médico: " + medico.getNome() + " (" + medico.getEspecialidade() + ")" +
                          " | Data/Hora: " + dataHora.format(formatter) + 
                          " | Observações: " + observacoes);
    }
}
