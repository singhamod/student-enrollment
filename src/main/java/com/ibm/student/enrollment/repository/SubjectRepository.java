package com.ibm.student.enrollment.repository;

import java.util.Set;

import com.ibm.student.enrollment.dto.SubjectDTO;
import com.ibm.student.enrollment.dto.SubjectDetailsDTO;

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

	/**
	 * Gets the subject details.
	 *
	 * @param subjectCode the subject id
	 * @return the subject details
	 */
	public SubjectDetailsDTO getSubjectDetails(String subjectCode);
}
