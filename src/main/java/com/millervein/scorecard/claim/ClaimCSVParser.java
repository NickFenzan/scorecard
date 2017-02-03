package com.millervein.scorecard.claim;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import com.millervein.scorecard.CSVParser;

@Component
public class ClaimCSVParser extends CSVParser<Claim>{

	@Override
	protected Claim recordToObject(CSVRecord record) {
		Integer id = Integer.valueOf(record.get("claimid"));
		LocalDate date = LocalDate.parse(record.get("clmcreatedday"), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		String department = record.get("svc dprtmnt");
		Double charges = Double.valueOf(record.get("all chgs"));
		return new Claim(id, date, department, charges);
	}
}
