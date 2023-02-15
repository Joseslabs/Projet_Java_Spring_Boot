package com.java_project.gestion_note.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java_project.gestion_note.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
        
        Optional<Users> findUserByUsername(String username);

        // Users findUserByResetPasswordToken(String token);
	
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}
     
