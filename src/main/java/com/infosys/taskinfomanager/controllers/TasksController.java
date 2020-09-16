package com.infosys.taskinfomanager.controllers;

import com.infosys.taskinfomanager.exceptions.ResourceNotFound;
import com.infosys.taskinfomanager.models.Tasks;
import com.infosys.taskinfomanager.services.ITasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Tasks>> findAll() {

        return ResponseEntity.ok().body(tasksService.getAllTasks());

    }
    @PostMapping("/tasks")
    public ResponseEntity<Tasks> createTask(@RequestBody Tasks task, String incident_Id){
        return ResponseEntity.ok().body(this.tasksService.createTask(task, incident_Id));
    }

    @GetMapping("/addTask")
    public String addTaskForm(Model model) {
        Tasks tasks = new Tasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("listTasks", tasksService.getAllTasks());

        List<String> incidentType = Arrays.asList("L2", "L3", "Maint", "SR", "Enhancement-Minor", "Enhancement-Major", "Project Management", "NA");
        model.addAttribute("listIncidentType", incidentType);

        List<String> impact = Arrays.asList("LOW", "MEDIUM", "HIGH");
        model.addAttribute("listImpact", impact);

        List<String> resCateTier1 = Arrays.asList("Application Sustainment");
        model.addAttribute("listResCateTier1", resCateTier1);

        List<String> resCateTier3 = Arrays.asList("Testing Support", "Data Fix", "Code Change", "Analysis");
        model.addAttribute("listResCateTier3", resCateTier3);

        return "manageTasks";
    }
    @PostMapping("/addTask")
    public String submitTaskForm(@Validated @ModelAttribute("tasks") Tasks tasks, String incident_Id, Model model) {
        model.addAttribute("tasks", tasks);

        tasksService.createTask(tasks, incident_Id);

        return "resultTask";
    }

    /* TODO SEARCH FUNCTION

    @GetMapping("/searchTasks")
    public String searchTaskForm(Model model){
        Tasks tasks =  new Tasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("listTasks", tasksService.getAllTasks());

        return "searchTasks";
    }
    */
    @GetMapping("/editTask/{incident_Id}")
    public String editForm(@PathVariable("incident_Id") String incident_Id,  Model model) throws ResourceNotFound {
        if(tasksService.findTaskById(incident_Id).getIncident_Id().isEmpty()){
            return "error";
        }else {

            model.addAttribute("editTask", tasksService.findTaskById(incident_Id));

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

    @PostMapping("/editTask/{incident_Id}")
    public String submitForm(@PathVariable("incident_Id") String incident_Id, @Validated Tasks tasks, Model model) {

        tasksService.updateTask(tasks, incident_Id);
        model.addAttribute("editApp", tasksService.getAllTasks());


        return "redirect:/addTask";
    }

    @GetMapping("/deleteTask/{incident_Id}")
    public String deleteTask(@Validated @PathVariable("incident_Id") String incident_Id) throws ResourceNotFound {

        tasksService.deleteTask(incident_Id);

        return "redirect:/addTask";
    }

}
