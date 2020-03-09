package com.ibm.student.enrollment.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.student.enrollment.AbstractTest;

/**
 * This class uses custom entity classes to extract subject_code and
 * subject_desc from class entity. The output of this class helps to cleans data
 * and do some analytics on the given input
 * 
 * @author AmodKumarSingh
 *
 */
@Disabled
public class JsonViewHelper {

	private static final String FILE_NAME = "output.json";

	@Test
	public void reprintJsonData() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		InputStream inputStream = AbstractTest.class.getClassLoader().getResourceAsStream(FILE_NAME);
		List<Enrollment> enrollments = objectMapper.readValue(inputStream, new TypeReference<List<Enrollment>>() {
		});
		objectMapper.writeValue(System.out, enrollments);
	}

}
