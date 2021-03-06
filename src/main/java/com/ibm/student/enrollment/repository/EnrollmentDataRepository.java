package com.ibm.student.enrollment.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.student.enrollment.entity.Enrollment;

import lombok.Data;

@Data
@Repository
public class EnrollmentDataRepository {

	private List<Enrollment> enrollments;

	@PostConstruct
	public void init() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("output.json")) {
			enrollments = Collections.unmodifiableList(mapper.readValue(is, new TypeReference<List<Enrollment>>() {
			}));
			if (CollectionUtils.isEmpty(enrollments)) {
				enrollments = new ArrayList<>();
			}
		}
	}
}
