package com.millervein.scorecard.scorecard;

import com.millervein.scorecard.appointment.AppointmentType;

public class AppointmentTypeCountMetric extends Metric {
	private AppointmentType appointmentType;
	private String site;

	public AppointmentTypeCountMetric(String name, String personResponsible, AppointmentType appointmentType) {
		this(name, personResponsible, appointmentType, null);
	}

	public AppointmentTypeCountMetric(String name, String personResponsible, AppointmentType appointmentType,
			String site) {
		super(name, personResponsible);
		this.appointmentType = appointmentType;
		this.site = site;
	}

	public AppointmentType getAppointmentType() {
		return appointmentType;
	}

	public String getSite() {
		return site;
	}
	
}
