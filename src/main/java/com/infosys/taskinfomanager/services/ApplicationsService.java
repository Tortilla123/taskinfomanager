package com.infosys.taskinfomanager.services;

import com.infosys.taskinfomanager.exceptions.ResourceNotFound;
import com.infosys.taskinfomanager.models.Applications;
import com.infosys.taskinfomanager.repository.ApplicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ApplicationsService implements IApplicationsService{

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Applications createApplications(Applications application, String app_Name) {

        String str = app_Name.replaceAll(",$", "");

        if (this.applicationRepository.existsById(str)){
            throw new ResourceNotFound("Resource exists.");
        }else {

            return applicationRepository.save(application);
        }

    }

    @Override
    public List<Applications> getAllApplications() {

        return (List<Applications>) applicationRepository.findAll();
    }


    @Override
    public Applications updateApplication(Applications applications, String app_Name) {
        Optional<Applications> applicationsDB = this.applicationRepository.findById(app_Name);

            Applications applications1 = applicationsDB.get();

            applications1.setArea(applications.getArea());
            applications1.setManager_Name(applications.getManager_Name());
            applications1.setMaint_id(applications.getMaint_id());
            applications1.setMaint_TS(applications.getMaint_TS());
            return applicationRepository.save(applications1);

    }

    @Override
    public Applications findApplicationById(String app_Name) {
        Optional<Applications> applicationsDB = this.applicationRepository.findById(app_Name);

        if(applicationsDB.isPresent()){
            return applicationRepository.findById(app_Name).get();
        }else{
            throw new ResourceNotFound("Application not found.");
        }

    }

    @Override
    public void deleteApplications( String app_Name ) {
        Optional<Applications> applicationsDB = this.applicationRepository.findById(app_Name);

        if(applicationsDB.isPresent()){
            applicationRepository.deleteById(app_Name);
        }else{
            throw new ResourceNotFound("Application not found with the name: "+ app_Name);
        }

    }

}
