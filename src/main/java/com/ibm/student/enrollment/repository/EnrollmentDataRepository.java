package com.ibm.student.enrollment.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.student.enrollment.entity.Enrollment;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Repository
public class EnrollmentDataRepository {

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	@Value("classpath:output.json")
	private Resource dataFile;

	private List<Enrollment> enrollments;

	@PostConstruct
	public void init() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		enrollments = Collections
				.unmodifiableList(mapper.readValue(dataFile.getFile(), new TypeReference<List<Enrollment>>() {
				}));
		if(CollectionUtils.isEmpty(enrollments)) {
			enrollments = new ArrayList<>();
		}
	}
}
