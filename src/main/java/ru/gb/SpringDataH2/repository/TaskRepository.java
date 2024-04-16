package ru.gb.SpringDataH2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.gb.SpringDataH2.model.Task;
import ru.gb.SpringDataH2.model.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findTasksByTaskStatus(TaskStatus status);
/*
    @Modifying
    @Query(value = "update Task t set  t.taskStatus = :taskStatus where t.id = :id")
    void updateTask(@Param("id") Long id, @Param("taskStatus") TaskStatus taskStatus);
    */
}
