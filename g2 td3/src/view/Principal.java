package view;

import controller.ConsultaController;
import model.CampoObrigatorioException;
import model.ConsultaNaoEncontradaException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaController controller = new ConsultaController();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        System.out.println("=== SISTEMA DE GERENCIAMENTO DE CONSULTAS MÉDICAS ===");
        System.out.println("Bem-vindo ao sistema!");
        
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            try {
                switch (opcao) {
                    case 1:
                        controller.cadastrarPaciente();
                        break;
                        
                    case 2:
                        controller.cadastrarMedico();
                        break;
                        
                    case 3:
                        controller.agendarConsulta();
                        break;
                        
                    case 4:
                        controller.listarConsultas();
                        break;
                        
                    case 5:
                        controller.buscarConsultaPorPaciente();
                        break;
                        
                    case 6:
                        controller.cancelarConsulta();
                        break;
                        
                    case 7:
                        controller.listarPacientes();
                        break;
                        
                    case 8:
                        controller.listarMedicos();
                        break;
                        
                    case 9:
                        exibirEstatisticas(controller);
                        break;
                        
                    case 0:
                        System.out.println("Obrigado por usar o Sistema de Consultas Médicas!");
                        System.out.println("Saindo...");
                        break;
                        
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (CampoObrigatorioException e) {
                System.out.println("ERRO: " + e.getMessage());
            } catch (ConsultaNaoEncontradaException e) {
                System.out.println("ERRO: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("ERRO INESPERADO: " + e.getMessage());
            }
            
            if (opcao != 0) {
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
            }
            
        } while (opcao != 0);
        
        scanner.close();
    }
    
    private static void exibirMenu() {
        System.out.println("\n" + "=".repeat(55));
        System.out.println("              MENU PRINCIPAL");
        System.out.println("=".repeat(55));
        System.out.println("1 - Cadastrar paciente");
        System.out.println("2 - Cadastrar médico");
        System.out.println("3 - Agendar consulta");
        System.out.println("4 - Listar consultas agendadas");
        System.out.println("5 - Buscar consulta por paciente");
        System.out.println("6 - Cancelar consulta");
        System.out.println("7 - Listar pacientes");
        System.out.println("8 - Listar médicos");
        System.out.println("9 - Estatísticas do sistema");
        System.out.println("0 - Sair");
        System.out.println("=".repeat(55));
        System.out.print("Escolha uma opção: ");
    }
    
    private static void exibirEstatisticas(ConsultaController controller) {
        System.out.println("\n=== ESTATÍSTICAS DO SISTEMA ===");
        System.out.println("Total de pacientes cadastrados: " + controller.getTotalPacientes());
        System.out.println("Total de médicos cadastrados: " + controller.getTotalMedicos());
        System.out.println("Total de consultas agendadas: " + controller.getTotalConsultas());
    }
}
