package com.ibm.student.enrollment.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Entity class for ID. Normally it will be auto-generated by the database
 */
@Data
public class ID {

	@JsonProperty("$oid")
	private String oid;
}
