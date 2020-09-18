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
    public Tasks createTask(Tasks task, String incidentId) {
        String str_Incident_Id = incidentId.replaceAll(",$", "");
        System.out.println(incidentId);
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

        updateTask.setAppName(tasks.getAppName());
        updateTask.setGroupId(tasks.getGroupId());
        updateTask.setIncidentType(tasks.getIncidentType());
        updateTask.setSummary(tasks.getSummary());
        updateTask.setEmpId(tasks.getEmpId());
        updateTask.setSubmitDate(tasks.getSubmitDate());
        updateTask.setClosedDate(tasks.getClosedDate());
        updateTask.setImpact(tasks.getImpact());
        updateTask.setResolution(tasks.getResolution());
        updateTask.setResCateTier1(tasks.getResCateTier1());
        updateTask.setStatus(tasks.getStatus());
        updateTask.setRespondedDate(tasks.getRespondedDate());
        updateTask.setResCateTier3(tasks.getResCateTier3());
        updateTask.setTargetDate(tasks.getTargetDate());
        updateTask.setMaintId(tasks.getMaintId());
        updateTask.setMaintTS(tasks.getMaintTS());

        return tasksRepository.save(updateTask);

        } else{
            throw new ResourceNotFound("Resource not found with Incident ID: "+ incident_Id);
        }
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

    @Override
    public List<Tasks> fetchTasksByKeyword(String keyword, Integer keywordNum) {
        return tasksRepository.findTasksByKeyword(keyword, keywordNum);
    }
}
