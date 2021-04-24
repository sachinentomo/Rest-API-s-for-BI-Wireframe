package com.ems4.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "department")
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentId")
    @OneToMany()
    private Long departmentId;

    @Column(name = "departmentCode")
    private String departmentCode;

    @Column(name = "departmentName")
    private String departmentName;

    @Column(name = "departmentDesc")
    private String departmentDesc;

    @Column(name = "departmentLoc")
    private String departmentLoc;

    @Column(name="isActive", columnDefinition="tinyint(1) default 1")
    private boolean isActive;

    public Department() {
    }

    public Department(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Department(String departmentName, String departmentDesc, String departmentLoc, boolean isActive) {
        this.departmentName = departmentName;
        this.departmentDesc = departmentDesc;
        this.departmentLoc = departmentLoc;
        this.isActive = isActive;
    }

    public Department(Long departmentId, String departmentCode, String departmentName, String departmentDesc, String departmentLoc, boolean isActive) {
        this.departmentId = departmentId;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.departmentDesc = departmentDesc;
        this.departmentLoc = departmentLoc;
        this.isActive = isActive;
    }

    public Department(Long departmentId, String departmentName, String departmentDesc, String departmentLoc, boolean isActive) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentDesc = departmentDesc;
        this.departmentLoc = departmentLoc;
        this.isActive = isActive;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }

    public String getDepartmentLoc() {
        return departmentLoc;
    }

    public void setDepartmentLoc(String departmentLoc) {
        this.departmentLoc = departmentLoc;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}