package com.java_project.gestion_note.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java_project.gestion_note.model.Users;
import com.java_project.gestion_note.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

   @Autowired
   private UserRepository userRepository;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User of username = "+username+" not found"));

      return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
            new ArrayList<>());
   }
}

