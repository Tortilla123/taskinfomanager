package com.infosys.taskinfomanager.models;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;

@Qualifier("tasks")
@Entity
@Table(name = "TASKS")
public class Tasks {
    @Id
    @Column(name = "INCIDENT_ID")
    private String incidentId;

    @Column(name = "APP_NAME")
    private String appName;

    @Column(name = "GROUP_ID")
    private String groupId;

    @Column(name = "INCIDENT_TYPE")
    private String incidentType;

    @Column(name = "SUMMARY")
    private String summary;

    @Column(name = "EMP_ID")
    private int empId;

    @Column(name = "SUBMIT_DATE")
    private String submitDate;

    @Column(name = "CLOSED_DATE")
    private String closedDate;

    @Column(name = "IMPACT")
    private String impact;

    @Column(name = "RESOLUTION")
    private String resolution;

    @Column(name = "RES_CATE_TIER_1")
    private String resCateTier1;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "RESPONDED_DATE")
    private String respondedDate;

    @Column(name = "RES_CATE_TIER_3")
    private String resCateTier3;

    @Column(name = "TARGET_DATE")
    private String targetDate;

    @Column(name = "MAINT_ID")
    private int maintId;

    @Column(name = "MAINT_TS")
    private String maintTS;

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        String str_Incident_Id = incidentId.replaceAll(",$", "");
        this.incidentId = str_Incident_Id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
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

    public String getResCateTier1() {
        return resCateTier1;
    }

    public void setResCateTier1(String resCateTier1) {
        this.resCateTier1 = resCateTier1;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRespondedDate() {
        return respondedDate;
    }

    public void setRespondedDate(String respondedDate) {
        this.respondedDate = respondedDate;
    }

    public String getResCateTier3() {
        return resCateTier3;
    }

    public void setResCateTier3(String resCateTier3) {
        this.resCateTier3 = resCateTier3;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    public int getMaintId() {
        return maintId;
    }

    public void setMaintId(int maintId) {
        this.maintId = maintId;
    }

    public String getMaintTS() {
        return maintTS;
    }

    public void setMaintTS(String maintTS) {
        this.maintTS = maintTS;
    }

}
