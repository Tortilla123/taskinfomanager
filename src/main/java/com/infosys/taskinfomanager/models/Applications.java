package com.infosys.taskinfomanager.models;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Qualifier("applications")
@Entity
@Table(name="APPLICATIONS")
public class Applications {

    @Id
    @Column(name = "APP_NAME")
    @NotEmpty(message = "Required app name!")
    private String app_Name;

    @NotEmpty(message = "Required manager name!")
    @Column(name = "MANAGER_NAME")
    private String manager_Name;

    @NotEmpty(message = "Required area!")
    @Column(name = "AREA")
    private String area;

    @NotEmpty(message = "Required maintenance id!")
    @Pattern(regexp = "[\\s]*[0-9]*[0-9]+",message="Must contain numbers only!")
    @Size(min=1, max =10)
    @Column(name = "MAINT_ID")
    private String maint_Id;

    @NotEmpty(message = "Required maintenance date/time!")
    @Column(name = "MAINT_TS")
    private String maint_TS;

    public String getApp_Name() {
        return app_Name;
    }

    public void setApp_Name(String app_Name) {
        String str = app_Name.replaceAll(",$", "");
        this.app_Name = str;
    }

    public String getManager_Name() {
        return manager_Name;
    }

    public void setManager_Name(String manager_Name) {
        this.manager_Name = manager_Name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMaint_Id() {
        return maint_Id;
    }

    public void setMaint_Id(String maint_Id) {
        this.maint_Id = maint_Id;
    }

    public String getMaint_TS() {
        return maint_TS;
    }

    public void setMaint_TS(String maint_TS) {
        this.maint_TS = maint_TS;
    }

}
