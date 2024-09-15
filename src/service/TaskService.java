package service;

import model.Task;

public class TaskService {
    private static int idCounter = 0;

    public void createTask(String content) {
        Task newTask = new Task(idCounter++, content);

        //
    }

    public void removeTask(int id) {

    }

    public void saveToFile() {

    }
}