package com.ibm.student.enrollment.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Entity class for Class
 */
@Data
public class Class {

	@JsonProperty("subject_code")
	private String subjectCode;

	@JsonProperty("subject_desc")
	private String subjectDesc;

	@JsonProperty("week_start_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date weekStartDate;

	@JsonProperty("week_end_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date weekEndDate;

	@JsonProperty("exact_class_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date exactClassDate;

	@JsonProperty("day_of_week")
	private String dayOfWeek;

	@JsonProperty("room_number")
	private Double roomNumber;

	@JsonProperty("room")
	private Double room;

	@JsonProperty("gps_coordinates")
	private String gpsCoordinates;

	@JsonProperty("start_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date startTime;

	@JsonProperty("end_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date endTime;

	@JsonProperty("campus_code")
	private String campusCode;

	private Boolean hasStandardRoomDescription;

	private Integer duration;

	@JsonProperty("duration_code")
	private String duration_code;

	private Boolean isHoliday;
}
