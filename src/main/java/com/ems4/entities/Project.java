package com.ems4.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "project")
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId")
    private Long projectId;

    @Column(name = "projectCode")
    private String projectCode;

    @Column(name = "projectName")
    private String projectName;

    @Column(name = "projectDesc")
    private String projectDesc;

    @Column(name="isActive", columnDefinition="tinyint(1) default 1")
    private boolean isActive;

    /*@JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private List<Employee> employeeList;*/

    public Project() {
    }

    public Project(Long projectId) {
        this.projectId = projectId;
    }

    public Project(String projectName, String projectDesc, boolean isActive) {
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.isActive = isActive;
    }

    public Project(Long projectId, String projectName, String projectCode, String projectDesc, boolean isActive) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.projectDesc = projectDesc;
        this.isActive = isActive;
    }

    public Project(Long projectId, String projectName, String projectDesc, boolean isActive) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.isActive = isActive;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}