package ru.gb.SpringDataH2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.SpringDataH2.model.Task;
import ru.gb.SpringDataH2.model.TaskStatus;
import ru.gb.SpringDataH2.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // TODO: 15.04.2024
    public List<Task> findTaskByStatus(TaskStatus status) {
        return taskRepository.findTasksByTaskStatus(status);
    }

    // TODO: 15.04.2024
    /*
    public void updateTask(Long id, Task task) {
        taskRepository.updateTask(id, task.getTaskStatus());
    }
*/
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }


}
