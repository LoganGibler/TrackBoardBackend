package com.example.trackboard.TrackBoard.repository;
import com.example.trackboard.TrackBoard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

        @Query("SELECT u FROM User u")
        List<User> getAllUsers();

        @Query("SELECT u FROM User u WHERE u.id = :id")
        User findUserById(@Param("id") Long id);

}