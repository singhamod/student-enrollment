package com.ibm.student.enrollment.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Class {

	@JsonProperty("subject_code")
	private String subjectCode;

	@EqualsAndHashCode.Exclude
	@JsonProperty("subject_desc")
	private String subjectDesc;

}
