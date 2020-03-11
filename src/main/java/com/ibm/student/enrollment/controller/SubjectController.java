package com.ibm.student.enrollment.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.student.enrollment.dto.SubjectDTO;
import com.ibm.student.enrollment.dto.SubjectDetailsDTO;
import com.ibm.student.enrollment.repository.SubjectRepository;

/**
 * Controller for subject data
 */
@CrossOrigin
@RestController
@RequestMapping("subject")
public class SubjectController {

	@Autowired
	private SubjectRepository subjectRepository;

	/**
	 * Gets unique subjects across enrollments
	 *
	 * @return the unique subjects with code and description
	 */
	@GetMapping
	public ResponseEntity<Set<SubjectDTO>> getUniqueSubjects() {
		return ResponseEntity.ok(subjectRepository.getUniqueSubjects());
	}

	/**
	 * Gets the details of the subject with list of enrolled students.
	 *
	 * @param subjectCode the subject id
	 * @return
	 * @return the unique subjects with code and description
	 */
	@GetMapping("/{subjectCode}")
	public ResponseEntity<SubjectDetailsDTO> getSubjectDetails(@PathVariable("subjectCode") String subjectCode) {
		return ResponseEntity.ok(subjectRepository.getSubjectDetails(subjectCode));
	}

}
