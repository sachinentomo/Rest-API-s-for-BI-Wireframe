package com.ems4.Repository;

import com.ems4.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findProjectByProjectId(Long projectId);

    /* @Modifying
    @Query(value="update project set isActive = :isActive where projectId = :projectId", nativeQuery=true)
    void updateDepartmentByprojectId(Long projectId, boolean isActive); */
}
