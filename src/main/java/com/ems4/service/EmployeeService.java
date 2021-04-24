package com.ems4.service;

import com.ems4.entities.Employee;
import com.ems4.exception.RecordNotFoundException;
import com.ems4.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee findEmployeeById(Long id) throws RecordNotFoundException {
        return employeeRepo.findEmployeeByEmployeeId(id).orElseThrow(() -> new RecordNotFoundException("Employee by id " + id + " was not found"));
    }

    public Employee addEmployee(Employee employee) {
        Employee employee1 = employeeRepo.save(employee);
        /*Optional<Employee> employee2 = employeeRepo.findById(employee1.getEmployeeId());
        Employee updateEmpCode = employee2.get();*/
        String prjCode = "EMP" + employee1.getEmployeeId();
        employee1.setEmployeeCode(prjCode);
        employeeRepo.save(employee1);
        return employee1;
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    /*public void updateDepartmentByprojectId(Long id,Boolean isActive) throws RecordNotFoundException {
        prjRepo.updateDepartmentByprojectId(id,isActive);
    }*/

}
