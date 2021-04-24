package com.ems4.service;

import com.ems4.Repository.DepartmentRepository;
import com.ems4.entities.Department;
import com.ems4.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department findDepartmentById(Long id) throws RecordNotFoundException {
        return departmentRepository.findDepartmentByDepartmentId(id)
                .orElseThrow(() -> new RecordNotFoundException("Department by id " + id + " was not found"));
    }

    public Department addDepartment(Department department) {
        department = departmentRepository.save(department);
        Optional<Department> department1 = departmentRepository.findById(department.getDepartmentId());
        Department newEntity1 = department1.get();
        String deptCode = "DEPT" + department.getDepartmentId();
        newEntity1.setDepartmentCode(deptCode);
        departmentRepository.save(newEntity1);
        return newEntity1;
    }

    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
