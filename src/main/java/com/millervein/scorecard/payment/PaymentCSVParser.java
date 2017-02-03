package com.millervein.scorecard.payment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.millervein.scorecard.CSVParser;

@Service
public class PaymentCSVParser extends CSVParser<Payment> {

	@Override
	protected Payment recordToObject(CSVRecord record) {
		Integer id = Integer.valueOf(record.get("transactivtyid"));
		LocalDate date = LocalDate.parse(record.get("postdate"), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		String department = record.get("svc dprtmnt");
		Double payment = Double.valueOf(record.get("pmt"));
		return new Payment(id, date, department, payment);
	}

}
