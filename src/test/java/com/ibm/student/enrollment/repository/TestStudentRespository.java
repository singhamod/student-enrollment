package com.ibm.student.enrollment.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ibm.student.enrollment.AbstractTest;
import com.ibm.student.enrollment.entity.Enrollment;

@SpringBootTest
public class TestStudentRespository extends AbstractTest {

	@InjectMocks
	private StudentRepository subjectRepository = new StudentRepositoryImpl();

	@Mock
	private EnrollmentDataRepository dataRepository = new EnrollmentDataRepository();

	@BeforeEach
	void setMockOutput() {
		when(dataRepository.getEnrollments()).thenReturn(enrollments);
	}

	@Test
	public void givenStudentRepositoryGetUniqueStudentIdWhenSubjectIdThenCheckUniqueStudentId() {
		String subjectId = "IBU5HRM";
		Set<String> uniqueStudents = subjectRepository.getUniqueStudents(subjectId);
		Set<String> uniqueStudentsFromTest = getUniqueStudents(subjectId);
		assertEquals(uniqueStudents, uniqueStudentsFromTest);
	}

	private Set<String> getUniqueStudents(String subject) {
		Set<String> uniqueStudents = new LinkedHashSet<>();

		for (Enrollment enrollment : enrollments) {
			for (com.ibm.student.enrollment.entity.Class cls : enrollment.getClassDetails()) {
				if (StringUtils.equals(subject, cls.getSubjectCode())) {
					uniqueStudents.add(enrollment.getStudentId());
					break;
				}
			}
		}
		return uniqueStudents;
	}

}
