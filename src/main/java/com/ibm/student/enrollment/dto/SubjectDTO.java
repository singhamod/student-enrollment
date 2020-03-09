package com.ibm.student.enrollment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This DTO is responsible for holding code and description of a subject. It
 * uses equals and hashCode on subjectCode only for uniqueness purposes
 * 
 * @author AmodKumarSingh
 *
 */
@AllArgsConstructor
@Data
public class SubjectDTO {

	@JsonProperty("subject_code")
	private String subjectCode;

	@EqualsAndHashCode.Exclude
	@JsonProperty("subject_desc")
	private String subjectDesc;

}
