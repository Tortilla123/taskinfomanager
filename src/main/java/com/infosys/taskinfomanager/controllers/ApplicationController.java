package com.infosys.taskinfomanager.controllers;

import com.infosys.taskinfomanager.exceptions.ResourceNotFound;
import com.infosys.taskinfomanager.models.Applications;
import com.infosys.taskinfomanager.services.IApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ApplicationController {

    @Autowired
    IApplicationsService applicationsService;

    @GetMapping("/apps")
    public ResponseEntity<List<Applications>> findAll() {

        return ResponseEntity.ok().body(applicationsService.getAllApplications());

    }
    /*
    @PostMapping("/apps")
    public ResponseEntity<Applications> createApplication(@RequestBody Applications application){
        return ResponseEntity.ok().body(applicationsService.createApplications(application));
    }
    */


    @GetMapping("/addApp")
    public String addApplicationForm(Model model) {
        Applications applications = new Applications();
        model.addAttribute( "applications", applications );
        model.addAttribute("listApps", applicationsService.getAllApplications());

        return "manageApplication";
    }

    @PostMapping("/addApp")
    public String applicationSubmit(@Validated @ModelAttribute("applications") Applications applications, String app_Name){

            applicationsService.createApplications(applications, app_Name);

            return "resultApplication" ;
    }

    @GetMapping("/editApp/{app_Name}")
    public String editForm(@PathVariable("app_Name") String app_Name,  Model model) throws ResourceNotFound {
        System.out.println("Inside edit app");


        if(applicationsService.findApplicationById(app_Name).getApp_Name().isEmpty()){

            return "error";

        }else {

            model.addAttribute("applications", applicationsService.findApplicationById(app_Name));

            return "editApplication";
        }


    }

    @PostMapping("/editApp/{app_Name}")
    public String submitForm(@Validated @PathVariable("app_Name") String app_Name, Applications applications,  Model model) throws ResourceNotFound {

        applicationsService.updateApplication(applications, app_Name);
        model.addAttribute("applications", applicationsService.getAllApplications());

        return "redirect:/addApp";
    }

   @GetMapping("/deleteApp/{app_Name}")
    public String deleteApplcations(@Validated @PathVariable("app_Name") String app_Name) throws ResourceNotFound {

        applicationsService.deleteApplications(app_Name);

        return "redirect:/addApp";
   }


}
