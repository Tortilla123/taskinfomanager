package com.infosys.taskinfomanager.models;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Qualifier("applications")
@Entity
@Table(name="APPLICATIONS")
public class Applications {

    @Id
    @Column(name = "APP_NAME")
    private String app_Name;

    @Column(name = "MANAGER_NAME")
    private String manager_Name;

    @Column(name = "AREA")
    private String area;

    @Column(name = "MAINT_ID")
    private int maint_id;

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

    public int getMaint_id() {
        return maint_id;
    }

    public void setMaint_id(int maint_id) {
        this.maint_id = maint_id;
    }

    public String getMaint_TS() {
        return maint_TS;
    }

    public void setMaint_TS(String maint_TS) {
        this.maint_TS = maint_TS;
    }

    @Override
    public String toString() {
        return "Applications{" +
                "app_Name='" + app_Name + '\'' +
                ", manager_Name='" + manager_Name + '\'' +
                ", area='" + area + '\'' +
                ", maint_id=" + maint_id +
                ", maint_TS='" + maint_TS + '\'' +
                '}';
    }

}
