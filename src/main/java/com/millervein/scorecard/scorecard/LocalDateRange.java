package com.millervein.scorecard.scorecard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using=LocalDateRangeSerializer.class)
public class LocalDateRange {
	private LocalDate start;
	private LocalDate end;

	public LocalDateRange(LocalDate start, LocalDate end) {
		super();
		if(start.isAfter(end)){
			throw new IllegalArgumentException("Start can't be after end");
		}
		this.start = start;
		this.end = end;
	}

	public LocalDate getStart() {
		return start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public List<LocalDate> getDays() {
		List<LocalDate> dates = new ArrayList<LocalDate>();
		for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
			dates.add(date);
		}
		return dates;
	}
	
	public List<LocalDateRange> getWeeks() {
		List<LocalDateRange> dateRanges = new ArrayList<LocalDateRange>();
		for (LocalDate date = start; !date.isAfter(end); date = date.plusWeeks(1)) {
			dateRanges.add(new LocalDateRange(date, date.plusDays(6)));
		}
		return dateRanges;
	}
	

	public LocalDateRange minusYears(long years) {
		return new LocalDateRange(start.minusYears(years), end.minusYears(years));
	}

	@Override
	public String toString() {
		return start + " - " + end;
	}
}

class LocalDateRangeSerializer extends JsonSerializer<LocalDateRange>{

	@Override
	public void serialize(LocalDateRange value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeString(value.toString());
	}
	
}
