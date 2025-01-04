package com.example.trackboard.TrackBoard.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.trackboard.TrackBoard.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}