package com.ems4.Repository;

import com.ems4.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Optional<Department> findDepartmentByDepartmentId(Long id);
}
