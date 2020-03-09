package com.ibm.student.enrollment.repository;

import java.util.Set;

/**
 * The Interface StudentRepository.
 */
public interface StudentRepository {

	/**
	 * Gets unique students based on subject.
	 *
	 * @param subject the subject <OPTIONAL>
	 * @return the unique students
	 */
	public Set<String> getUniqueStudents(String subject);
}
