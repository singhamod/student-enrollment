package com.ibm.student.enrollment.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Entity class for Enrollment.
 */
@Data
public class Enrollment {

	@JsonProperty("_id")
	private ID id;
	
	@JsonProperty("student_id")
	private String studentId;
	
	@JsonProperty("class_details")
	private List<Class> classDetails;
}
