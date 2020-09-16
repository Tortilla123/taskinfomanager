package com.infosys.taskinfomanager.services;

import com.infosys.taskinfomanager.exceptions.ResourceNotFound;
import com.infosys.taskinfomanager.models.Tasks;
import com.infosys.taskinfomanager.repository.TasksRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TasksService implements ITasksService {

    @Autowired
    private TasksRepository tasksRepository;

    @Override
    public Tasks createTask(Tasks task, String incident_Id) {
        String str_Incident_Id = incident_Id.replaceAll(",$", "");
        if (tasksRepository.existsById(str_Incident_Id)){
            throw new ResourceNotFound("Resource exits.");
        }else {
            return tasksRepository.save(task);
        }

    }

    @Override
    public List<Tasks> getAllTasks() {
        return (List<Tasks>) tasksRepository.findAll();
    }

    @Override
    public Tasks findTaskById(String incident_Id) {
        Optional<Tasks> tasksDB = tasksRepository.findById(incident_Id);

        if(tasksDB.isPresent()){
            return tasksDB.get();
        }else{
            throw new ResourceNotFound("Task not found");
        }
    }

    @Override
    public Tasks updateTask(Tasks tasks, String incident_Id) {
        Optional<Tasks> tasksDB = tasksRepository.findById(incident_Id);

        if(tasksDB.isPresent()){
        Tasks updateTask = tasksDB.get();

        updateTask.setApp_Name(tasks.getApp_Name());
        updateTask.setGroup_Id(tasks.getGroup_Id());
        updateTask.setIncident_Type(tasks.getIncident_Type());
        updateTask.setSummary(tasks.getSummary());
        updateTask.setEmp_Id(tasks.getEmp_Id());
        updateTask.setSubmit_Date(tasks.getSubmit_Date());
        updateTask.setClosed_Date(tasks.getClosed_Date());
        updateTask.setImpact(tasks.getImpact());
        updateTask.setResolution(tasks.getResolution());
        updateTask.setRes_Cate_Tier1(tasks.getRes_Cate_Tier1());
        updateTask.setStatus(tasks.getStatus());
        updateTask.setResponded_Date(tasks.getResponded_Date());
        updateTask.setRes_Cate_Tier3(tasks.getRes_Cate_Tier3());
        updateTask.setTarget_Date(tasks.getTarget_Date());
        updateTask.setMaint_Id(tasks.getMaint_Id());
        updateTask.setMaint_TS(tasks.getMaint_TS());

        return tasksRepository.save(updateTask);

        } else{
            throw new ResourceNotFound("Resource not found with Incident ID: "+ incident_Id);
        }
    }

    @Override
    public List<Tasks> findTasks(String incident_Id, int emp_Id, String group_Id, String app_Name) {
        return null;
    }

    @Override
    public void deleteTask(String incident_Id) {
        Optional<Tasks> tasksDB = tasksRepository.findById(incident_Id);
        if(tasksDB.isPresent()){
            tasksRepository.deleteById(incident_Id);
        }else{
            throw new ResourceNotFound("Task not found with Incident ID: "+ incident_Id);
        }
    }
}
