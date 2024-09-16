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
        final String PURPLE = "\033[38;5;141m";

        System.out.println("Bem vindo, o arquivo deve estar na pasta raiz do projeto ou no mesmo diretório do executável!");
        while (true) {
            System.out.println("\n══════════════TODO══════════════");
            System.out.println(GREEN + "  1" + RESET + "  ➕ Adicionar Tarefa");
            System.out.println(RED + "  2" + RESET + "  ❌ Remover Tarefa");
            System.out.println(YELLOW + "  3" + RESET + "  📋 Listar Tarefas");
            System.out.println(BLUE + "  4" + RESET + "  💾 Salvar para arquivo");
            System.out.println(PURPLE + "  5" + RESET + "  📂 Carregar de arquivo");
            System.out.println(RESET + "  0  🚪 Sair");
            System.out.println("════════════════════════════════");

            try {
                int opt = InputUtil.readInt("Escolha uma opção: ");
                if (opt > 5 || opt < 0) {
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
                        System.out.println("\n\n\n\n\nTarefa adicionada com sucesso!");
                        break;
                    case 2:
                        int removeTask = InputUtil.readInt("Digite o ID da tarefa a ser removida: ");
                        ts.removeTask(removeTask);
                        System.out.println("\n\n\n\n\nTarefa removida com sucesso!");
                        break;
                    case 3:
                        System.out.println("\n\n\n\n\n");
                        ts.listTasks();
                        break;
                    case 4:
                        String fileToSave = InputUtil.readString("Digite o nome do arquivo (Ex: todo.txt): ");
                        System.out.println("\n\n\n\n\n");
                        ts.saveToFile(fileToSave);
                        break;
                    case 5:
                        String file = InputUtil.readString("Digite o nome do arquivo (Ex: todo.txt): ");
                        System.out.println("\n\n\n\n\n");
                        ts.loadFromFile(file);
                        break;
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