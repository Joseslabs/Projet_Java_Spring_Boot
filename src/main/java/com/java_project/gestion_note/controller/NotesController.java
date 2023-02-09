package com.java_project.gestion_note.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotesController {
	@GetMapping("/notesEtu")
	public String showNotes() {
		return "cards";
	}
}
