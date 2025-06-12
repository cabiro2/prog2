package controller;

import model.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsultaController {
    private ArrayList<Paciente> pacientes;
    private ArrayList<Medico> medicos;
    private ArrayList<Consulta> consultas;
    private Scanner scanner;
    
    public ConsultaController() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.consultas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    public void cadastrarPaciente() throws CampoObrigatorioException {
        System.out.println("\n--- CADASTRAR PACIENTE ---");
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        if (nome.trim().isEmpty()) {
            throw new CampoObrigatorioException("O nome do paciente é obrigatório!");
        }
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        if (cpf.trim().isEmpty()) {
            throw new CampoObrigatorioException("O CPF do paciente é obrigatório!");
        }
        
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        if (telefone.trim().isEmpty()) {
            throw new CampoObrigatorioException("O telefone do paciente é obrigatório!");
        }
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        if (email.trim().isEmpty()) {
            throw new CampoObrigatorioException("O email do paciente é obrigatório!");
        }
        
        System.out.print("Convênio: ");
        String convenio = scanner.nextLine();
        if (convenio.trim().isEmpty()) {
            throw new CampoObrigatorioException("O convênio é obrigatório!");
        }
        
        System.out.print("Número do Cartão: ");
        String numeroCartao = scanner.nextLine();
        if (numeroCartao.trim().isEmpty()) {
            throw new CampoObrigatorioException("O número do cartão é obrigatório!");
        }
        
        pacientes.add(new Paciente(nome, cpf, telefone, email, convenio, numeroCartao));
        System.out.println("Paciente cadastrado com sucesso!");
    }
    
    public void cadastrarMedico() throws CampoObrigatorioException {
        System.out.println("\n--- CADASTRAR MÉDICO ---");
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        if (nome.trim().isEmpty()) {
            throw new CampoObrigatorioException("O nome do médico é obrigatório!");
        }
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        if (cpf.trim().isEmpty()) {
            throw new CampoObrigatorioException("O CPF do médico é obrigatório!");
        }
        
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        if (telefone.trim().isEmpty()) {
            throw new CampoObrigatorioException("O telefone do médico é obrigatório!");
        }
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        if (email.trim().isEmpty()) {
            throw new CampoObrigatorioException("O email do médico é obrigatório!");
        }
        
        System.out.print("CRM: ");
        String crm = scanner.nextLine();
        if (crm.trim().isEmpty()) {
            throw new CampoObrigatorioException("O CRM é obrigatório!");
        }
        
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        if (especialidade.trim().isEmpty()) {
            throw new CampoObrigatorioException("A especialidade é obrigatória!");
        }
        
        medicos.add(new Medico(nome, cpf, telefone, email, crm, especialidade));
        System.out.println("Médico cadastrado com sucesso!");
    }
    
    public void agendarConsulta() throws CampoObrigatorioException {
        if (pacientes.isEmpty()) {
            System.out.println("Erro: Não há pacientes cadastrados!");
            return;
        }
        
        if (medicos.isEmpty()) {
            System.out.println("Erro: Não há médicos cadastrados!");
            return;
        }
        
        System.out.println("\n--- AGENDAR CONSULTA ---");
        
        System.out.println("Pacientes disponíveis:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + " - " + pacientes.get(i).getNome());
        }
        System.out.print("Escolha o paciente (número): ");
        int indicePaciente = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (indicePaciente < 0 || indicePaciente >= pacientes.size()) {
            System.out.println("Paciente inválido!");
            return;
        }
        
        System.out.println("Médicos disponíveis:");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println((i + 1) + " - " + medicos.get(i).getNome() + 
                             " (" + medicos.get(i).getEspecialidade() + ")");
        }
        System.out.print("Escolha o médico (número): ");
        int indiceMedico = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (indiceMedico < 0 || indiceMedico >= medicos.size()) {
            System.out.println("Médico inválido!");
            return;
        }
        
        System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
        String dataHoraStr = scanner.nextLine();
        if (dataHoraStr.trim().isEmpty()) {
            throw new CampoObrigatorioException("A data e hora são obrigatórias!");
        }
        
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, formatter);
            
            System.out.print("Observações: ");
            String observacoes = scanner.nextLine();
            
            Consulta consulta = new Consulta(pacientes.get(indicePaciente), 
                                           medicos.get(indiceMedico), 
                                           dataHora, 
                                           observacoes);
            consultas.add(consulta);
            System.out.println("Consulta agendada com sucesso!");
        } catch (DateTimeParseException e) {
            System.out.println("Erro: Formato de data/hora inválido! Use dd/MM/yyyy HH:mm");
        }
    }
    
    public void listarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        
        System.out.println("\n=== CONSULTAS AGENDADAS ===");
        for (Consulta consulta : consultas) {
            consulta.exibirDados();
        }
    }
    
    public void buscarConsultaPorPaciente() throws ConsultaNaoEncontradaException {
        System.out.print("Digite o nome do paciente: ");
        String nomePaciente = scanner.nextLine();
        
        boolean encontrado = false;
        System.out.println("\n=== CONSULTAS DO PACIENTE ===");
        
        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().getNome().toLowerCase().contains(nomePaciente.toLowerCase())) {
                consulta.exibirDados();
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            throw new ConsultaNaoEncontradaException("Nenhuma consulta encontrada para o paciente: " + nomePaciente);
        }
    }
    
    public void cancelarConsulta() throws ConsultaNaoEncontradaException {
        if (consultas.isEmpty()) {
            System.out.println("Não há consultas para cancelar.");
            return;
        }
        
        System.out.println("\n--- CANCELAR CONSULTA ---");
        System.out.println("Consultas agendadas:");
        for (int i = 0; i < consultas.size(); i++) {
            System.out.print((i + 1) + " - ");
            consultas.get(i).exibirDados();
        }
        
        System.out.print("Digite o número da consulta a cancelar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (indice < 0 || indice >= consultas.size()) {
            throw new ConsultaNaoEncontradaException("Consulta não encontrada!");
        }
        
        consultas.remove(indice);
        System.out.println("Consulta cancelada com sucesso!");
    }
    
    public void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }
        
        System.out.println("\n=== PACIENTES CADASTRADOS ===");
        for (Pessoa paciente : pacientes) {
            paciente.exibirDados();
        }
    }
    
    public void listarMedicos() {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
            return;
        }
        
        System.out.println("\n=== MÉDICOS CADASTRADOS ===");
        for (Pessoa medico : medicos) {
            medico.exibirDados();
        }
    }
    
    public int getTotalConsultas() {
        return consultas.size();
    }
    
    public int getTotalPacientes() {
        return pacientes.size();
    }
    
    public int getTotalMedicos() {
        return medicos.size();
    }
}
