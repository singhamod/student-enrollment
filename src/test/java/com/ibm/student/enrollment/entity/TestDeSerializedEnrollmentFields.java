package com.ibm.student.enrollment.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.ibm.student.enrollment.AbstractTest;

public class TestDeSerializedEnrollmentFields extends AbstractTest {


	@Test
	public void givenEnrollmentArrayThenIdShouldBePresent() {
		Optional.ofNullable(enrollments).ifPresent(enrollments -> {
			boolean isElementWithNoId = enrollments.stream().filter(e -> e.getId() == null).findAny().isPresent();
			assertFalse(isElementWithNoId, "All elements must have a valid id");
		});
	}

	@Test
	public void givenEnrollmentArrayThenStudentIdShouldBePresent() {
		Optional.ofNullable(enrollments).ifPresent(enrollments -> {
			boolean isElementWithNoStudentId = enrollments.stream().filter(e -> e.getStudentId() == null).findAny()
					.isPresent();
			assertFalse(isElementWithNoStudentId, "All elements must have a valid student id");
		});
	}

	
}
