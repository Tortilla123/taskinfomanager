package com.infosys.taskinfomanager.services;

import com.infosys.taskinfomanager.models.Tasks;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public interface ITasksService {

    Tasks createTask(Tasks task, String incidentId);

    List<Tasks> getAllTasks();

    Tasks findTaskById(String incidentId);

    Tasks updateTask(Tasks tasks, String incident_Id);

    void deleteTask(String incident_Id);

    List<Tasks> fetchTasksByKeyword(String keyword, Integer keywordNum, String keywordFrom, String keywordTo);
}
