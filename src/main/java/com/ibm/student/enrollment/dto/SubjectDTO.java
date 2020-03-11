package com.ibm.student.enrollment.dto;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This DTO is responsible for holding code and description of a subject. It
 * uses equals and hashCode on subjectCode only for uniqueness purposes
 * 
 * @author AmodKumarSingh
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectDTO implements Comparable<SubjectDTO> {

	@JsonProperty("subject_code")
	private String subjectCode;

	@EqualsAndHashCode.Exclude
	@JsonProperty("subject_desc")
	private String subjectDesc;

	@Override
	public int compareTo(SubjectDTO o) {
		return StringUtils.compare(subjectCode, o.getSubjectCode());
	}

}
