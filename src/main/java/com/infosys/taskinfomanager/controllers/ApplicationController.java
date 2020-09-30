package com.infosys.taskinfomanager.controllers;

import com.infosys.taskinfomanager.exceptions.ResourceNotFound;
import com.infosys.taskinfomanager.models.Applications;
import com.infosys.taskinfomanager.services.IApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ApplicationController {

    @Autowired
    IApplicationsService applicationsService;

    @GetMapping("/apps")
    public ResponseEntity<List<Applications>> findAll() {

        return ResponseEntity.ok().body(applicationsService.getAllApplications());

    }

    @GetMapping("/addApp")
    public String addApplicationForm(Model model) {

        Applications applications = new Applications();

        model.addAttribute( "applications", applications );

        model.addAttribute("listApps", applicationsService.getAllApplications());

        return "addApplications";
    }

    @PostMapping("/addApp")
    public String applicationSubmit( @ModelAttribute("applications") @Valid Applications applications, BindingResult bindingResult, String app_Name, Model model){
            if(bindingResult.hasErrors()){

                model.addAttribute(bindingResult);

                model.addAttribute("listApps", applicationsService.getAllApplications());

                return "addApplications";

            }else{

                applicationsService.createApplications(applications, app_Name);

                return "resultApplication" ;

            }
    }

    @GetMapping("/editApp/{app_Name}")
    public String editForm(@PathVariable("app_Name") String app_Name,  Model model) throws ResourceNotFound {

        if(applicationsService.findApplicationById(app_Name).getApp_Name().isEmpty()){

            return "error";

        }else {

            model.addAttribute("applications", applicationsService.findApplicationById(app_Name));

            return "editApplication";
        }

    }

    @PostMapping("/editApp/{app_Name}")
    public String submitForm(@PathVariable("app_Name") String app_Name, @Valid @ModelAttribute  Applications applications, BindingResult bindingResult,  Model model) throws ResourceNotFound {

        if(bindingResult.hasErrors()){

            model.addAttribute(bindingResult);

            return "editApplication";

        }else{

            applicationsService.updateApplication(applications, app_Name);

            model.addAttribute("applications", applicationsService.getAllApplications());

            return "redirect:/addApp";
        }
    }

   @GetMapping("/deleteApp/{app_Name}")
    public String deleteApplcations(@PathVariable("app_Name") String app_Name) throws ResourceNotFound {

        if(applicationsService.findApplicationById(app_Name).getApp_Name().isEmpty()){

           return "error";

       }else {

           applicationsService.deleteApplications(app_Name);

           return "redirect:/addApp";
       }
   }


}
