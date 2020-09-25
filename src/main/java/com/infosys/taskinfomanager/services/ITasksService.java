package com.infosys.taskinfomanager.services;

import com.infosys.taskinfomanager.models.Tasks;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITasksService {

    Tasks createTask(Tasks task, String incidentId);

    List<Tasks> getAllTasks();

    Tasks findTaskById(String incidentId);

    Tasks updateTask(Tasks tasks, String incidentId);

    void deleteTask(String incidentId);

    List<Tasks> fetchTasksByKeyword(String keyword, Integer keywordNum, String keywordFrom, String keywordTo);
}
