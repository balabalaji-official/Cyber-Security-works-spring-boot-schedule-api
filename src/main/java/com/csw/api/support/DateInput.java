package com.csw.api.support;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DateInput {

	@JsonFormat(pattern = "dd MMM yyyy")
	private Date dateOfDetails;

	public Date getDateOfDetails() {
		return dateOfDetails;
	}

	public void setDateOfDetails(Date dateOfDetails) {
		this.dateOfDetails = dateOfDetails;
	}

}
