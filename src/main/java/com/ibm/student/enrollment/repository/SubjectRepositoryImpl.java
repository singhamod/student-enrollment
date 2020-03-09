package com.ibm.student.enrollment.repository;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.student.enrollment.dto.SubjectDTO;

/**
 * The Class SubjectRepositoryImpl.
 */
@Repository
public class SubjectRepositoryImpl implements SubjectRepository {

	/** The data repository. */
	@Autowired
	private EnrollmentDataRepository dataRepository;

	/**
	 * Gets the unique subjects.
	 *
	 * @return the unique subjects
	 */
	@Override
	public Set<SubjectDTO> getUniqueSubjects() {
		Set<SubjectDTO> subjects = new LinkedHashSet<>();
		dataRepository.getEnrollments().stream().map(enrollments -> enrollments.getClassDetails())
				.forEach(enrollment -> enrollment.forEach(cls -> {
					subjects.add(new SubjectDTO(cls.getSubjectCode(), cls.getSubjectDesc()));
				}));
		return subjects;
	}

}
