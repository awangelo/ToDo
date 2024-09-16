package service;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private static int idCounter = 0;

    public void createTask(String content) {
        Task newTask = new Task(idCounter++, content);
        tasks.add(newTask);
    }

    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public void saveToFile() {

    }
}