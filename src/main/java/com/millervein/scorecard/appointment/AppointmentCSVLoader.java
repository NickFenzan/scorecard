package com.millervein.scorecard.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millervein.scorecard.CSVLoader;

@Service
public class AppointmentCSVLoader extends CSVLoader<Appointment> {

	@Autowired
	public AppointmentCSVLoader(AppointmentRepository appointmentRepo, AppointmentCSVParser csvParser) {
		super(appointmentRepo, csvParser);
	}

}
