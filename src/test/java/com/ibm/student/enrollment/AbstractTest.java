package com.ibm.student.enrollment;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.student.enrollment.entity.Enrollment;

public class AbstractTest {

	private static final String FILE_NAME = "output.json";

	protected static ObjectMapper objectMapper;

	private static InputStream inputStream;

	private static TypeReference<List<Enrollment>> typeReference = new TypeReference<List<Enrollment>>() {
	};

	protected static List<Enrollment> enrollments;

	@BeforeAll
	public static void init() throws JsonParseException, JsonMappingException, IOException {
		objectMapper = new ObjectMapper();
		inputStream = AbstractTest.class.getClassLoader().getResourceAsStream(FILE_NAME);
		enrollments = objectMapper.readValue(inputStream, typeReference);
	}
	
	@AfterAll
	public static void cleanUp() throws IOException {
		if (inputStream != null) {
			inputStream.close();
		}
	}

}
