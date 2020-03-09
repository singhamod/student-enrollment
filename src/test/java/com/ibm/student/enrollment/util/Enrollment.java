package com.ibm.student.enrollment.util;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Enrollment {

	@JsonProperty("student_id")
	private String studentId;
	
	@JsonProperty("class_details")
	private Set<Class> classDetails;
}
