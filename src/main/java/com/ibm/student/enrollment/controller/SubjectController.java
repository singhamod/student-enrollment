package com.ibm.student.enrollment.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.student.enrollment.dto.SubjectDTO;
import com.ibm.student.enrollment.repository.SubjectRepository;

/**
 * Controller for subject data
 */
@RestController
public class SubjectController {

	@Autowired
	private SubjectRepository subjectRepository;

	/**
	 * Gets unique subjects across enrollments
	 *
	 * @return the unique subjects with code and description
	 */
	@GetMapping("/subject")
	public ResponseEntity<Set<SubjectDTO>> getUniqueSubjects() {
		return ResponseEntity.ok(subjectRepository.getUniqueSubjects());
	}

}
