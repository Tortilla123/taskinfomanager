package com.infosys.taskinfomanager.controllers;

import com.infosys.taskinfomanager.exceptions.ResourceNotFound;
import com.infosys.taskinfomanager.models.Tasks;
import com.infosys.taskinfomanager.services.ITasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class TasksController {

    @Autowired
    ITasksService tasksService;

    @GetMapping("/tasks")
    public String getTasks(Model model, String keyword, Integer keywordNum){
        if(keyword == null) {
            model.addAttribute("listTasks", tasksService.getAllTasks());
        }else{
            model.addAttribute("listTasks", tasksService.fetchTasksByKeyword(keyword, keywordNum));
        }
        return "tasks";
    }

    //Add a task
    @GetMapping("/addTask")
    public String addTaskForm(Model model) {
        Tasks tasks = new Tasks();
        model.addAttribute("tasks", tasks);

        List<String> incidentType = Arrays.asList("L2", "L3", "Maint", "SR", "Enhancement-Minor", "Enhancement-Major", "Project Management", "NA");
        model.addAttribute("listIncidentType", incidentType);

        List<String> impact = Arrays.asList("LOW", "MEDIUM", "HIGH");
        model.addAttribute("listImpact", impact);

        List<String> resCateTier1 = Arrays.asList("Application Sustainment");
        model.addAttribute("listResCateTier1", resCateTier1);

        List<String> resCateTier3 = Arrays.asList("Testing Support", "Data Fix", "Code Change", "Analysis");
        model.addAttribute("listResCateTier3", resCateTier3);

        return "addTasks";
    }
    @PostMapping("/addTask")
    public String submitTaskForm(@Validated @ModelAttribute("tasks") Tasks tasks, String incidentId, Model model) {
        model.addAttribute("tasks", tasks);

        tasksService.createTask(tasks, incidentId);

        return "resultTask";
    }

    //Edit tasks
    @GetMapping("/editTask/{incidentId}")
    public String editForm(@PathVariable("incidentId") String incidentId,  Model model) throws ResourceNotFound {
        if(tasksService.findTaskById(incidentId).getIncidentId().isEmpty()){
            return "error";
        }else {

            model.addAttribute("editTask", tasksService.findTaskById(incidentId));

            List<String> incidentType = Arrays.asList("L2", "L3", "Maint", "SR", "Enhancement-Minor", "Enhancement-Major", "Project Management", "NA");
            model.addAttribute("listIncidentType2", incidentType);

            List<String> impact = Arrays.asList("LOW", "MEDIUM", "HIGH");
            model.addAttribute("listImpact2", impact);

            List<String> resCateTier1 = Arrays.asList("Application Sustainment");
            model.addAttribute("listResCateTier1_2", resCateTier1);

            List<String> resCateTier3 = Arrays.asList("Testing Support", "Data Fix", "Code Change", "Analysis");
            model.addAttribute("listResCateTier3_2", resCateTier3);


            return "editTasks";
        }
    }

    @PostMapping("/editTask/{incidentId}")
    public String submitForm(@PathVariable("incidentId") String incidentId, @Validated Tasks tasks) {

        tasksService.updateTask(tasks, incidentId);

        return "redirect:/tasks";
    }

    //Delete tasks
    @GetMapping("/deleteTask/{incidentId}")
    public String deleteTask(@Validated @PathVariable("incidentId") String incident_Id) throws ResourceNotFound {

        tasksService.deleteTask(incident_Id);

        return "redirect:/tasks";
    }

}
