package com.csw.api.entity;

import java.sql.Date;

import javax.persistence.Embeddable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonFormat;

@Embeddable
public class Schedule {

	// @Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long schedId;

	@JsonFormat(pattern = "dd MMM yyyy")
	private Date startDate;

	@JsonFormat(pattern = "dd MMM yyyy")
	private Date endDate;

	@JsonFormat(pattern = "HH:mm")
	private java.util.Date time;

	private String duration;

	private boolean repeat;

	private enum Frequency {
		Weekdays, Monthly, Weekly, Daily
	};

	@Enumerated(EnumType.STRING)
	private Frequency frequency;

	public Long getSchedId() {
		return schedId;
	}

	public void setSchedId(Long schedId) {
		this.schedId = schedId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public java.util.Date getTime() {
		return time;
	}

	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public boolean isRepeat() {
		return repeat;
	}

	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

}
