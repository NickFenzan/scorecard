package com.millervein.scorecard.appointment;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Appointment {
	@Id
	private Integer id;
	@NotNull
	private LocalDate date;
	@NotNull
	@Enumerated(EnumType.STRING)
	private AppointmentType type;
	@NotNull
	private String department;
	
	protected Appointment(){}

	public Appointment(Integer id, LocalDate date, AppointmentType type, String department) {
		super();
		this.id = id;
		this.date = date;
		this.type = type;
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public AppointmentType getType() {
		return type;
	}

	public String getDepartment() {
		return department;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", date=" + date + ", type=" + type + ", department=" + department + "]";
	}

}
