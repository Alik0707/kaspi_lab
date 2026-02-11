package com.example.taskm.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.taskm.entity.Task;
import com.example.taskm.enums.Priority;
import com.example.taskm.enums.Status;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final HashMap<Long, Task> map = new HashMap<>();

    public TaskService() {
        Task task1 = new Task(
                1L,
                100L,
                200L,
                Status.IN_PROGRESS,
                LocalDateTime.now(),
                LocalDateTime.now().plusDays(1),
                Priority.HIGH
        );

        Task task2 = new Task(
                2L,
                101L,
                201L,
                Status.KOTAK_TEBU,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(5),
                Priority.MEDIUM
        );

        Task task3 = new Task(
                3L,
                101L,
                201L,
                Status.MASKI_CHAI_ISHY,
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(5),
                Priority.HIGH
        );

        map.put(1L, task1);
        map.put(2L, task2);
        map.put(3L, task3);

    }

    public Task getTaskById(long id) {
        return map.get(id);
    }

    public List<Task> getAll() {
        return map.values().stream().toList();
    }

    public String IskaKotak(){
        return "Iska  KOtak JAVA okyyyyyyy";
    }



}
