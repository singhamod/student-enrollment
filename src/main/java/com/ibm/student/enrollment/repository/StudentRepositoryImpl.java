package com.ibm.student.enrollment.repository;

import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.student.enrollment.entity.Enrollment;

/**
 * The Class StudentRepositoryImpl.
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private EnrollmentDataRepository dataRepository;

	/**
	 * Gets the unique students.
	 *
	 * @param subject the subject
	 * @return the unique students
	 */
	@Override
	public Set<String> getUniqueStudents(String subject) {
		return dataRepository.getEnrollments().stream().filter(e -> isSubjectIdPresent(subject, e))
				.map(e -> e.getStudentId()).collect(Collectors.toSet());
	}

	/**
	 * Handles the subjectId. If no subjectId is present, then all records are
	 * returned
	 *
	 * @param subject the subject
	 * @param e       the e
	 * @return true, if is subject id present
	 */
	private boolean isSubjectIdPresent(String subject, Enrollment e) {
		// If subject id is empty then return all unique students
		if (StringUtils.isBlank(subject)) {
			return true;
		} else {
			return e.getClassDetails().stream().filter(c -> StringUtils.equals(subject, c.getSubjectCode())).findAny()
					.isPresent();
		}
	}

}
