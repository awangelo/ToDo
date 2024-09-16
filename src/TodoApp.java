import service.TaskService;
import util.InputUtil;

import java.util.InputMismatchException;

public class TodoApp {
    private static final TaskService ts = new TaskService();

    public static void main(String[] args) {
        final String RESET = "\033[0m";
        final String RED = "\033[38;5;160m";
        final String GREEN = "\033[38;5;35m";
        final String BLUE = "\033[38;5;69m";
        final String YELLOW = "\033[38;5;202m";

        while (true) {
            System.out.println("\n╔════════════════════════╗");
            System.out.println("║" + GREEN + " 1" + RESET + " - Adicionar Tarefa   ║");
            System.out.println("║" + RED + " 2" + RESET + " - Remover Tarefa     ║");
            System.out.println("║" + BLUE + " 3" + RESET + " - Listar Tarefas     ║");
            System.out.println("║" + YELLOW + " 4" + RESET + " - Opções de arquivos ║");
            System.out.println("║ 0 - Sair               ║");
            System.out.println("╚════════════════════════╝");

            try {
                int opt = InputUtil.readInt("Escolha uma opção: ");
                if (opt > 4 || opt < 0) {
                    throw new InputMismatchException();
                }

                switch (opt) {
                    case 0:
                        System.out.println("Saindo...");
                        System.exit(0);
                        break;
                    case 1:
                        String addTask = InputUtil.readString("Digite a tarefa a ser adicionada: ");
                        ts.createTask(addTask);
                        System.out.println("Tarefa adicionada com sucesso!");
                        break;
                    case 2:
                        int removeTask = InputUtil.readInt("Digite o ID da tarefa a ser removida: ");
                        ts.removeTask(removeTask);
                        System.out.println("Tarefa removidada com sucesso!");
                    default:
                        System.out.println("\n\n\n\n\nOpção inválida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n\n\n\n\nInsira um número válido");
                InputUtil.flush();
            }
        }
    }
}