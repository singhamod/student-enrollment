package com.ibm.student.enrollment.controller;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.student.enrollment.repository.StudentRepository;

/**
 * Controller for student data
 */
@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	/**
	 * Gets unique students based on subject. If no subject specified, entire list
	 * of students is returned
	 *
	 * @param subjectId the subject id <OPTIONAL>
	 * @return the unique students
	 */
	@GetMapping("/student")
	public ResponseEntity<Set<String>> getUniqueStudents(
			@RequestParam(name = "subject", required = false) String subjectId) {
		return ResponseEntity.ok(studentRepository.getUniqueStudents(StringUtils.trim(subjectId)));
	}

}
