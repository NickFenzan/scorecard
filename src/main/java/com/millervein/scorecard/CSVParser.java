package com.millervein.scorecard;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public abstract class CSVParser<T> {
	public List<T> parse(Reader in) throws IOException {
		return CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in)
				.getRecords()
				.stream()
				.map(record -> recordToObject(record))
				.collect(Collectors.toList());
	}

	abstract protected T recordToObject(CSVRecord record);
}
