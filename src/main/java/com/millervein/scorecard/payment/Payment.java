package com.millervein.scorecard.payment;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {
	@Id
	private Integer id;
	private LocalDate date;
	private String department;
	private Double amount;

	protected Payment() {
	}

	public Payment(Integer id, LocalDate date, String department, Double amount) {
		super();
		this.id = id;
		this.date = date;
		this.department = department;
		this.amount = amount;
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

	public Double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", date=" + date + ", department=" + department + ", amount=" + amount + "]";
	}

}
