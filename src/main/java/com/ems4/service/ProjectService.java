package com.ems4.service;

import com.ems4.entities.Project;
import com.ems4.exception.RecordNotFoundException;
import com.ems4.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository prjRepo;

    @Autowired
    public ProjectService(ProjectRepository prjRepo) {
        this.prjRepo = prjRepo;
    }

    public List<Project> findAllProjects() {
        return prjRepo.findAll();
    }

    public Project findProjectById(Long id) throws RecordNotFoundException {
        return prjRepo.findProjectByProjectId(id)
                .orElseThrow(() -> new RecordNotFoundException("Project by id " + id + " was not found"));
    }

    public Project addProject(Project project) {
        Project project1 = prjRepo.save(project);
        Optional<Project> project2 = prjRepo.findById(project1.getProjectId());
        Project updatePrjCode = project2.get();
        String prjCode = "PRJ" + project1.getProjectId();
        updatePrjCode.setProjectCode(prjCode);
        prjRepo.save(updatePrjCode);
        return updatePrjCode;
    }

    public Project updateProject(Project project) {
        return prjRepo.save(project);
    }

    /*public void updateDepartmentByprojectId(Long id,Boolean isActive) throws RecordNotFoundException {
        prjRepo.updateDepartmentByprojectId(id,isActive);
    }*/

}

/*else
        {
            Optional<Department> department = repository.findById(entity.getDepartmentId());

            if(department.isPresent())
            {
            	Department newEntity = department.get();
                newEntity.setDepartmentName(entity.getDepartmentName());
                newEntity.setDepartmentDesc(entity.getDepartmentDesc());
                newEntity.setDepartmentLoc(entity.getDepartmentLoc());
                newEntity = repository.save(newEntity);
                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
        }*/