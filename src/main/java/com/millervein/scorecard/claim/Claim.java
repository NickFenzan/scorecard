package com.millervein.scorecard.claim;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Claim {
	@Id
	private Integer id;
	private LocalDate date;
	private String department;
	private Double billed;

	protected Claim() {
	}

	public Claim(Integer id, LocalDate date, String department, Double billed) {
		super();
		this.id = id;
		this.date = date;
		this.department = department;
		this.billed = billed;
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getDepartment() {
		return department;
	}

	public Double getBilled() {
		return billed;
	}

	@Override
	public String toString() {
		return "Claim [id=" + id + ", date=" + date + ", department=" + department + ", billed=" + billed + "]";
	}

}
