package com.infosys.taskinfomanager.services;

import com.infosys.taskinfomanager.models.Applications;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IApplicationsService {

    Applications createApplications(Applications applications, String manager_Name);

    List<Applications> getAllApplications();

    void deleteApplications(String app_Name);

    Applications updateApplication(Applications applications, String app_Name);

    Applications findApplicationById(String app_Name);

}
