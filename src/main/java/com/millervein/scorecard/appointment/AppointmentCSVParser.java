package com.millervein.scorecard.appointment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import com.millervein.scorecard.CSVParser;

@Component
public class AppointmentCSVParser extends CSVParser<Appointment> {

	@Override
	protected Appointment recordToObject(CSVRecord record) {
		Integer id = Integer.valueOf(record.get("prnt apptid"));
		LocalDate startDate = LocalDate.parse(record.get("apptdate"), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		String department = record.get("svc dprtmnt");
		AppointmentType type = AppointmentType.fromString(record.get("appttype"));
		return new Appointment(id, startDate, type, department);
	}
}
