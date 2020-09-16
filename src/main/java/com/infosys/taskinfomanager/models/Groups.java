package com.infosys.taskinfomanager.models;

import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;

@Qualifier("groups")
@Entity
@Table(name = "GROUPS")
public class Groups  {
    @Id
    @Column(name = "GROUP_ID")
    private String group_Id;

    @Column(name = "GROUP_NAME")
    private String group_Name;

    @Column(name = "MAINT_ID")
    private Integer maint_Id;

    @Column(name = "MAINT_TS")
    private String maint_TS;

    public String getGroup_Id() {
        return group_Id;
    }

    public void setGroup_Id(String group_Id) {
        this.group_Id = group_Id;
    }

    public String getGroup_Name() {
        return group_Name;
    }

    public void setGroup_Name(String group_Name) {
        this.group_Name = group_Name;
    }

    public Integer getMaint_Id() {
        return maint_Id;
    }

    public void setMaint_Id(Integer maint_Id) {
        this.maint_Id = maint_Id;
    }

    public String getMaint_TS() {
        return maint_TS;
    }

    public void setMaint_TS(String maint_TS) {
        this.maint_TS = maint_TS;
    }
}
