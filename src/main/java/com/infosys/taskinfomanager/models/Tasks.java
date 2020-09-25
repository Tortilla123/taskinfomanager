package com.infosys.taskinfomanager.models;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Qualifier("tasks")
@Entity
@Table(name = "TASKS")
public class Tasks {
    @Id
    @Column(name = "INCIDENT_ID")
    @NotEmpty(message = "Incident Id required!")
    private String incidentId;

    @ManyToOne
    @JoinColumn(name = "APP_NAME", referencedColumnName = "APP_NAME")
    private Applications appName;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")
    private Groups groupId;

    @Column(name = "INCIDENT_TYPE")
    @NotEmpty(message = "Incident type required!")
    private String incidentType;

    @Column(name = "SUMMARY")
    @NotEmpty(message = "Summary required!")
    @Size(min=3, max= 70)
    private String summary;

    @Column(name = "EMP_ID")
    @NotEmpty(message = "Employee Id required!")
    @Pattern(regexp = "[\\s]*[0-9]*[0-9]+",message="Must contain numbers only!")
    @Size(min=1, max =10)
    private String empId;

    @NotEmpty(message = "Submit date/time required!!")
    @Column(name = "SUBMIT_DATE")
    private String submitDate;

    @Column(name = "CLOSED_DATE")
    @NotEmpty(message = "Target date/time required!")
    private String closedDate;

    @Column(name = "IMPACT")
    @NotEmpty(message = "Required impact!")
    private String impact;

    @Column(name = "RESOLUTION")
    @NotEmpty(message = "Resolution required!")
    @Size(min=3, max= 70)
    private String resolution;

    @Column(name = "RES_CATE_TIER_1")
    @NotEmpty(message = "Resoluton Tier 1 required!")
    private String resCateTier1;

    @Column(name = "STATUS")
    @NotEmpty(message = "Status required!")
    @Size(min=3, max=10)
    private String status;

    @Column(name = "RESPONDED_DATE")
    @NotEmpty(message = "Responded date/time required!")
    private String respondedDate;

    @Column(name = "RES_CATE_TIER_3")
    @NotEmpty(message = "Resoluton Tier 3 required!")
    private String resCateTier3;

    @Column(name = "TARGET_DATE")
    @NotEmpty(message = "Target date required!")
    private String targetDate;

    @Column(name = "MAINT_ID")
    @NotEmpty(message = "Maintenance id required!")
    private String maintId;

    @Column(name = "MAINT_TS")
    @NotEmpty(message = "Maintenance date/time required!")
    private String maintTS;

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        String str_Incident_Id = incidentId.replaceAll(",$", "");
        this.incidentId = str_Incident_Id;
    }

    public Applications getAppName() {
        return appName;
    }

    public void setAppName(Applications appName) {
        this.appName = appName;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
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

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
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

    public String getMaintId() {
        return maintId;
    }

    public void setMaintId(String maintId) {
        this.maintId = maintId;
    }

    public String getMaintTS() {
        return maintTS;
    }

    public void setMaintTS(String maintTS) {
        this.maintTS = maintTS;
    }

}
