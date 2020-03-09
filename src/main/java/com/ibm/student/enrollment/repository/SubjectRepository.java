package com.ibm.student.enrollment.repository;

import java.util.Set;

import com.ibm.student.enrollment.dto.SubjectDTO;

/**
 * The Interface SubjectRepository.
 */
public interface SubjectRepository {

	/**
	 * Gets the unique subjects.
	 *
	 * @return the unique subjects
	 */
	public Set<SubjectDTO> getUniqueSubjects();
}
