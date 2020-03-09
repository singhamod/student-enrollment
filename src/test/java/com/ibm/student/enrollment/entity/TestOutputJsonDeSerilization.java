package com.ibm.student.enrollment.entity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestOutputJsonDeSerilization {

	private static final String FILE_NAME = "output.json";

	private static ObjectMapper objectMapper;

	private static InputStream inputStream;

	private static TypeReference<List<Enrollment>> typeReference = new TypeReference<List<Enrollment>>() {
	};

	@BeforeAll
	public static void init() {
		objectMapper = new ObjectMapper();
		inputStream = TestOutputJsonDeSerilization.class.getClassLoader().getResourceAsStream(FILE_NAME);
		assertNotNull(inputStream, "File stream cannot be empty");
	}

	@Test
	public void givenOutputJsonThenSerializationToEnrollmentArrayShouldBeSuccessful()
			throws JsonParseException, JsonMappingException, IOException {
		List<Enrollment> enrollments = objectMapper.readValue(inputStream, typeReference);
		assertNotNull(enrollments, "Enrollments cannot be null");
	}

	@AfterAll
	public static void cleanUp() throws IOException {
		if (inputStream != null) {
			inputStream.close();
		}
	}
}
