package service;

import model.Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private static int idCounter = 1;

    public void createTask(String content) {
        Task newTask = new Task(idCounter++, content);
        tasks.add(newTask);
    }

    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public void listTasks() {
        tasks.forEach(task -> System.out.printf("%d - %s\n", task.getId(), task.getContent()));
    }

    public void saveToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            tasks.forEach(task -> {
                try {
                    writer.write(task.getContent());
                    writer.newLine();
                } catch (IOException e) {
                    System.out.println("Erro ao salvar tarefa: " + e);
                }
            });

            System.out.println("\n\n\n\n\nTarefas salvas com sucesso em " + fileName);
        } catch (IOException e) {
            System.out.println("\n\n\n\n\nErro ao abrir o arquivo para escrita: " + e);
        }
    }

    public void loadFromFile(String fileName) {
        idCounter = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            tasks.clear();
            String line;

            while ((line = reader.readLine()) != null) {
                tasks.add(new Task(idCounter++, line));
            }
            System.out.println("\n\n\n\n\nTarefas carregadas com sucesso de " + fileName);
        } catch (IOException e) {
            System.out.println("\n\n\n\n\nErro ao carregar tarefas: " + e);
        }
    }

}