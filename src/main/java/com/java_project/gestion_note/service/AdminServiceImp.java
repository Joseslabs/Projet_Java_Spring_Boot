package com.java_project.gestion_note.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_project.gestion_note.model.Admin;
import com.java_project.gestion_note.repository.AdminRepository;

@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin read(long id) {
		// TODO Auto-generated method stub
		return adminRepository.findById(id).get();
	}
}
