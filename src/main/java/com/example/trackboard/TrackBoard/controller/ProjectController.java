package com.example.trackboard.TrackBoard.controller;

import com.example.trackboard.TrackBoard.entity.Project;
import com.example.trackboard.TrackBoard.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @PostMapping("/create")
    public Project createProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable long id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable long id) {
        projectRepository.deleteById(id);
    }

    @PutMapping("/update")
    public Project updateProject(@RequestBody Project projectDetails) {
        Project project = projectRepository.findById(projectDetails.getId()).orElseThrow(() -> new RuntimeException("Project not found"));
        project.setName(projectDetails.getName());
        project.setDescription(projectDetails.getDescription());
        project.setStatus(projectDetails.getStatus());
        project.setStartDate(projectDetails.getStartDate());
        project.setEndDate(projectDetails.getEndDate());
        return projectRepository.save(project);
    }
}