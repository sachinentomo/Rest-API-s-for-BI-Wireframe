package com.ems4.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long employeeId;

    private String employeeCode;

    private String employeeName;

    private String employeeEmail;

    private String employeePass;

    @ManyToOne
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "projectId", referencedColumnName = "projectId")
    private Project project;

    @Column(name = "employeeJoin")
    @Temporal(TemporalType.TIMESTAMP)
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date employeeJoin;

    @Column(name = "isActive", columnDefinition="tinyint(1) default 1")
    private boolean isActive;

    public Employee() {
    }

    public Employee(String employeeName, String employeeEmail, String employeePass, Department department, Project project, Date employeeJoin, boolean isActive) {
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeePass = employeePass;
        this.department = department;
        this.project = project;
        this.employeeJoin = employeeJoin;
        this.isActive = isActive;
    }


    public Employee(Long employeeId, String employeeName, String employeeEmail, String employeePass, Department department, Project project, Date employeeJoin, boolean isActive) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeePass = employeePass;
        this.department = department;
        this.project = project;
        this.employeeJoin = employeeJoin;
        this.isActive = isActive;
    }

    public Employee(Long employeeId, String employeeCode, String employeeName, String employeeEmail, String employeePass, Department department, Project project, Date employeeJoin) {
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeePass = employeePass;
        this.department = department;
        this.project = project;
        this.employeeJoin = employeeJoin;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePass() {
        return employeePass;
    }

    public void setEmployeePass(String employeePass) {
        this.employeePass = employeePass;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getEmployeeJoin() {
        return employeeJoin;
    }

    public void setEmployeeJoin(Date employeeJoin) {
        this.employeeJoin = employeeJoin;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}