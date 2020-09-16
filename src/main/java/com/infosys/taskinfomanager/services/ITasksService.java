package com.infosys.taskinfomanager.services;

import com.infosys.taskinfomanager.models.Tasks;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITasksService {

    Tasks createTask(Tasks task, String incident_Id);

    List<Tasks> getAllTasks();

    Tasks findTaskById(String incident_Id);

    Tasks updateTask(Tasks tasks, String incident_Id);

    List<Tasks> findTasks(String incident_Id, int emp_Id, String group_Id, String app_Name );

    void deleteTask(String incident_Id);

}
