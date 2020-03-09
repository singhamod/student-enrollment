package com.ibm.student.enrollment.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ibm.student.enrollment.AbstractTest;
import com.ibm.student.enrollment.dto.SubjectDTO;

@SpringBootTest
public class TestSubjectRespository extends AbstractTest {

	@InjectMocks
	private SubjectRepository subjectRepository = new SubjectRepositoryImpl();

	@Mock
	private EnrollmentDataRepository dataRepository = new EnrollmentDataRepository();

	@BeforeEach
	void setMockOutput() {
		when(dataRepository.getEnrollments()).thenReturn(enrollments);
	}

	@Test
	public void givenSubjectRepositoryGetUniqueSubjectsThenCheckUniqueSubjects() {
		Set<SubjectDTO> uniqueSubjects = subjectRepository.getUniqueSubjects();
		Set<SubjectDTO> uniqueSubjectsFromTest = enrollments.stream().map(e -> e.getClassDetails())
				.flatMap(List::stream).map(c -> new SubjectDTO(c.getSubjectCode(), c.getSubjectDesc()))
				.collect(Collectors.toSet());
		assertEquals(uniqueSubjects, uniqueSubjectsFromTest);
	}

}