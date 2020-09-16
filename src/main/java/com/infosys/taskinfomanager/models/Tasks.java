package com.infosys.taskinfomanager.models;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;

@Qualifier("tasks")
@Entity
@Table(name = "TASKS")
public class Tasks {
    @Id
    @Column(name = "INCIDENT_ID")
    private String incident_Id;

    @Column(name = "APP_NAME")
    private String app_Name;

    @Column(name = "GROUP_ID")
    private String group_Id;

    @Column(name = "INCIDENT_TYPE")
    private String incident_Type;

    @Column(name = "SUMMARY")
    private String summary;

    @Column(name = "EMP_ID")
    private int emp_Id;

    @Column(name = "SUBMIT_DATE")
    private String submit_Date;

    @Column(name = "CLOSED_DATE")
    private String closed_Date;

    @Column(name = "IMPACT")
    private String impact;

    @Column(name = "RESOLUTION")
    private String resolution;

    @Column(name = "RES_CATE_TIER_1")
    private String res_Cate_Tier1;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "RESPONDED_DATE")
    private String responded_Date;

    @Column(name = "RES_CATE_TIER_3")
    private String res_Cate_Tier3;

    @Column(name = "TARGET_DATE")
    private String target_Date;


    @Column(name = "MAINT_ID")
    private int maint_Id;

    @Column(name = "MAINT_TS")
    private String maint_TS;

    public String getIncident_Id() {
        return incident_Id;
    }

    public void setIncident_Id(String incident_Id) {
        String str_Incident_Id = incident_Id.replaceAll(",$", "");
        this.incident_Id = str_Incident_Id;
    }

    public String getApp_Name() {
        return app_Name;
    }

    public void setApp_Name(String app_Name) { this.app_Name = app_Name; }

    public String getGroup_Id() {
        return group_Id;
    }

    public void setGroup_Id(String group_Id) {
        this.group_Id = group_Id;
    }

    public int getMaint_Id() {
        return maint_Id;
    }

    public void setMaint_Id(int maint_Id) {
        this.maint_Id = maint_Id;
    }

    public String getMaint_TS() {
        return maint_TS;
    }

    public void setMaint_TS(String maint_TS) {
        this.maint_TS = maint_TS;
    }


    public String getIncident_Type() {
        return incident_Type;
    }

    public void setIncident_Type(String incident_Type) {
        this.incident_Type = incident_Type;
    }

    public String getSummary() {
        return summary;
    }

    public int getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(int emp_Id) {
        this.emp_Id = emp_Id;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubmit_Date() {
        return submit_Date;
    }

    public void setSubmit_Date(String submit_Date) {
        this.submit_Date = submit_Date;
    }

    public String getClosed_Date() {
        return closed_Date;
    }

    public void setClosed_Date(String closed_Date) {
        this.closed_Date = closed_Date;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getRes_Cate_Tier1() {
        return res_Cate_Tier1;
    }

    public void setRes_Cate_Tier1(String res_Cate_Tier1) {
        this.res_Cate_Tier1 = res_Cate_Tier1;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponded_Date() {
        return responded_Date;
    }

    public void setResponded_Date(String responded_Date) {
        this.responded_Date = responded_Date;
    }

    public String getRes_Cate_Tier3() {
        return res_Cate_Tier3;
    }

    public void setRes_Cate_Tier3(String res_Cate_Tier3) {
        this.res_Cate_Tier3 = res_Cate_Tier3;
    }

    public String getTarget_Date() {
        return target_Date;
    }

    public void setTarget_Date(String target_Date) {
        this.target_Date = target_Date;
    }
}
