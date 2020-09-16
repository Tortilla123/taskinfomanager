package com.infosys.taskinfomanager.models;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "EMP_ID")
    private Integer emp_id;
    @Column(name = "CID")
    private String cid;
    @Column (name = "EMP_NAME")
    private String emp_name;
    @Column (name = "ACCESS")
    private String access;
/*
    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Groups group_Id;


 */
    @Column(name = "GROUP_ID")
    private String group_Id;

    @Column (name = "MAINT_ID")
    private Integer maint_id;
    @Column (name = "MAINT_TS")
    private String maint_ts;

    public Integer getEmpId(){
        return emp_id;
    }
    public void setEmpId(Integer empId){
        this.emp_id = empId;
    }

    public String getCid(){
        return cid;
    }
    public void setCid(String cid){
        this.cid = cid;
    }

    public String getEmpName(){
        return emp_name;
    }
    public void setEmpName(String empName){
        this.emp_name = empName;
    }

    public String getAccess(){
        return access;
    }

    public void setAccess(String access){
        this.access = access;
    }

    public String getGroupId(){
        return group_Id;
    }

    public void setGroupId(String groupId){
        this.group_Id = groupId;
    }

    public Integer getMaintId(){
        return maint_id;
    }
    public void setMaintId(Integer maintId){
        this.maint_id = maintId;
    }

    public String getMaintTS(){
        return maint_ts;
    }
    public void setMaintTS(String maintTS){
        this.maint_ts = maintTS;
    }


}
