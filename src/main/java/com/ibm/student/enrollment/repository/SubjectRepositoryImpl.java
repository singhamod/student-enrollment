package com.ibm.student.enrollment.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.student.enrollment.dto.SubjectDTO;
import com.ibm.student.enrollment.dto.SubjectDetailsDTO;

/**
 * The Class SubjectRepositoryImpl.
 */
@Repository
public class SubjectRepositoryImpl implements SubjectRepository {

	/** The data repository. */
	@Autowired
	private EnrollmentDataRepository dataRepository;

	@Autowired
	private StudentRepository studentRepository;

	/**
	 * Gets the unique subjects.
	 *
	 * @return the unique subjects
	 */
	@Override
	public Set<SubjectDTO> getUniqueSubjects() {
		Set<SubjectDTO> subjects = new TreeSet<>();
		dataRepository.getEnrollments().stream().map(enrollments -> enrollments.getClassDetails())
				.forEach(enrollment -> enrollment.forEach(cls -> {
					subjects.add(new SubjectDTO(cls.getSubjectCode(), cls.getSubjectDesc()));
				}));
		return subjects;
	}

	@Override
	public SubjectDetailsDTO getSubjectDetails(String subjectCode) {
		Optional<SubjectDTO> oSubject = dataRepository.getEnrollments().stream()
				.map(enrollments -> enrollments.getClassDetails()).flatMap(List::stream)
				.filter(c -> StringUtils.equals(subjectCode, c.getSubjectCode())).findFirst()
				.map(c -> new SubjectDTO(c.getSubjectCode(), c.getSubjectDesc()));
		if (oSubject.isPresent()) {
			return new SubjectDetailsDTO(oSubject.get().getSubjectCode(), oSubject.get().getSubjectDesc(),
					studentRepository.getUniqueStudents(subjectCode));
		} else {
			return new SubjectDetailsDTO();
		}
	}

}
