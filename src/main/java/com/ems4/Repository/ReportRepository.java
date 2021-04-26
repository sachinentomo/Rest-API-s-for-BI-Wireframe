package com.ems4.Repository;

import com.ems4.dto.EmpByDept;
import com.ems4.dto.EmpByJoin;
import com.ems4.dto.EmpByPrj;
import com.ems4.dto.Summary;
import com.ems4.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository extends JpaRepository<Employee,Long> {

    @Query(value = "SELECT (SELECT COUNT(employee_id) FROM   employee) AS employeeCount, (SELECT COUNT(department_id) FROM   department) AS departmentCount, (SELECT count(project_id) FROM project) AS projectCount FROM dual", nativeQuery=true)
    public List<Summary> getTotalCount();

    @Query(value = "select count(employee_id) as empCount, d.department_name as deptName from department d INNER JOIN employee e ON d.department_id=e.department_id group by d.department_name", nativeQuery=true)
    public List<EmpByDept> getEmpByDept();

    @Query(value = "select count(employee_id) as empCount, p.project_name as prjName from project p INNER JOIN employee e ON p.project_id=e.project_id group by p.project_name", nativeQuery=true)
    public List<EmpByPrj> getEmpByPrj();

    @Query(value = "select count(employee_id) as empCount, employee_join as empJoin from employee group by employee_join", nativeQuery=true)
    public List<EmpByJoin> getEmpByJoin();


    //@Query(value = "select count(employee_id) as empCount, DATE_FORMAT(employee_join, '%d/%m/%Y') as empJoin from employee group by employee_join", nativeQuery=true)
    //public List<EmpByJoin> getEmpByJoin();
}
