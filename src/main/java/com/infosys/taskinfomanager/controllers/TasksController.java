package com.infosys.taskinfomanager.controllers;

import com.infosys.taskinfomanager.exceptions.ResourceNotFound;
import com.infosys.taskinfomanager.models.Tasks;
import com.infosys.taskinfomanager.repository.ApplicationRepository;
import com.infosys.taskinfomanager.repository.GroupsRepository;
import com.infosys.taskinfomanager.services.ITasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class TasksController {

    @Autowired
    ITasksService tasksService;
    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    GroupsRepository groupsRepository;

    @GetMapping("/tasks")
    public String getTasks(Model model, String keyword, Integer keywordNum, String keywordFrom, String keywordTo, String app_Name){

        if(keyword == null && keywordNum == null && (keywordFrom == null && keywordTo == null)) {

            model.addAttribute("listTasks", tasksService.getAllTasks());

        }else{
            model.addAttribute("listTasks", tasksService.fetchTasksByKeyword(keyword, keywordNum, keywordFrom, keywordTo));
        }
        return "tasks";
    }

    //Add a task
    @GetMapping("/addTask")
    public String addTaskForm(Model model) {
        Tasks tasks = new Tasks();
        model.addAttribute("tasks", tasks);

        addOrEditListsToDisplay(model);

        return "addTasks";
    }
    @PostMapping("/addTask")
    public String submitTaskForm(@Valid @ModelAttribute("tasks") Tasks tasks, BindingResult bindingResult, String incidentId, Model model) {

        if(bindingResult.hasErrors()){

            model.addAttribute(bindingResult);

            addOrEditListsToDisplay(model);

            return "addTasks";

        }else{

            model.addAttribute("tasks", tasks);

            tasksService.createTask(tasks, incidentId);

            return "resultTask";
        }
    }

    //Edit tasks
    @GetMapping("/editTask/{incidentId}")
    public String editForm(@PathVariable("incidentId") String incidentId,  Model model) throws ResourceNotFound {

        if(tasksService.findTaskById(incidentId).getIncidentId().isEmpty()){

            return "error";

        }else {

            model.addAttribute("tasks", tasksService.findTaskById(incidentId));

            addOrEditListsToDisplay(model);

            return "editTasks";
        }
    }

    @PostMapping("/editTask/{incidentId}")
    public String submitForm(@PathVariable("incidentId") String incidentId, @Valid @ModelAttribute Tasks tasks, BindingResult bindingResult, Model model) throws ResourceNotFound {

        if(bindingResult.hasErrors()){

            model.addAttribute(bindingResult);

            addOrEditListsToDisplay(model);

            //model.addAttribute("editTask", tasksService.findTaskById(incidentId));

            return "editTasks";

        }else{

            tasksService.updateTask(tasks, incidentId);

            return "redirect:/tasks";
        }
    }

    //Delete tasks
    @GetMapping("/deleteTask/{incidentId}")
    public String deleteTask(@Validated @PathVariable("incidentId") String incident_Id) throws ResourceNotFound {

        tasksService.deleteTask(incident_Id);

        return "redirect:/tasks";
    }

    public void addOrEditListsToDisplay(Model model){

        //Displays available application names for clientside to add/edit task
        List<String> appNames = new ArrayList<>(Collections.emptyList());
        for (int i = 0; i< applicationRepository.count(); i++){
            appNames.add(applicationRepository.findAll().get(i).getApp_Name());
            model.addAttribute("listAppNames", appNames);
        }

        //Displays available group ids for clientside to add/edit task
        List<String> groupIds = new ArrayList<>(Collections.emptyList());
        for (int j = 0; j< groupsRepository.count(); j++){
            groupIds.add(groupsRepository.findAll().get(j).getGroup_Id());
            model.addAttribute("listGroupIds", groupIds);
        }

        //Displays a list of all incident types to clientside from which user can choose from
        List<String> incidentType = Arrays.asList("L2", "L3", "Maint", "SR", "Enhancement-Minor", "Enhancement-Major", "Project Management", "NA");
        model.addAttribute("listIncidentType", incidentType);

        //Displays a list of impact to clientside which user can choose from
        List<String> impact = Arrays.asList("LOW", "MEDIUM", "HIGH");
        model.addAttribute("listImpact", impact);

        //Displays a list of tier1 to clientside which user can choose from
        List<String> resCateTier1 = Arrays.asList("Application Sustainment");
        model.addAttribute("listResCateTier1", resCateTier1);

        //Displays a list of tier3 to clientside which can choose from
        List<String> resCateTier3 = Arrays.asList("Testing Support", "Data Fix", "Code Change", "Analysis");
        model.addAttribute("listResCateTier3", resCateTier3);
    }

}
