package com.millervein.scorecard.scorecard;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using=LocalDateSerializer.class)
public class LocalDate {
	private java.time.LocalDate date;

	public LocalDate(String date) {
		this.date = java.time.LocalDate.parse(date);
	}

	public LocalDate(java.time.LocalDate date) {
		this.date = date;
	}

	public static LocalDate now() {
		return new LocalDate(java.time.LocalDate.now());
	}

	public LocalDate minusDays(long daysToSubtract) {
		return new LocalDate(this.date.minusDays(daysToSubtract));
	}

	public LocalDate minusWeeks(long weeksToSubtract) {
		return new LocalDate(this.date.minusWeeks(weeksToSubtract));
	}

	public LocalDate minusMonths(long monthsToSubtract) {
		return new LocalDate(this.date.minusMonths(monthsToSubtract));
	}

	public LocalDate minusYears(long yearsToSubtract) {
		return new LocalDate(this.date.minusYears(yearsToSubtract));
	}

	public LocalDate plusDays(long daysToAdd) {
		return new LocalDate(this.date.plusDays(daysToAdd));
	}

	public LocalDate plusWeeks(long weeksToAdd) {
		return new LocalDate(this.date.plusWeeks(weeksToAdd));
	}

	public LocalDate plusMonths(long monthsToAdd) {
		return new LocalDate(this.date.plusMonths(monthsToAdd));
	}

	public LocalDate plusYears(long yearsToAdd) {
		return new LocalDate(this.date.plusYears(yearsToAdd));
	}

	public LocalDate withDayOfWeek(long dayOfWeek) {
		return new LocalDate(this.date.with(WeekFields.ISO.dayOfWeek(), dayOfWeek));
	}

	public LocalDate withDayOfMonth(int dayOfMonth) {
		return new LocalDate(this.date.withDayOfMonth(dayOfMonth));
	}
	
	public LocalDate withDayOfYear(int dayOfYear) {
		return new LocalDate(this.date.withDayOfYear(dayOfYear));
	}

	public LocalDate withWeekOfMonth(long weekOfMonth) {
		return new LocalDate(this.date.with(WeekFields.ISO.weekOfMonth(), weekOfMonth));
	}
	
	public LocalDate withMonth(int month) {
		return new LocalDate(this.date.withMonth(month));
	}
	
	public LocalDate withYear(int year) {
		return new LocalDate(this.date.withYear(year));
	}

	public DayOfWeek getDayOfWeek() {
		return this.date.getDayOfWeek();
	}

	public int getDayOfMonth() {
		return this.date.getDayOfMonth();
	}

	public int getDayOfYear() {
		return this.date.getDayOfYear();
	}

	public int getWeekOfMonth() {
		return this.date.get(WeekFields.ISO.weekOfMonth());
	}

	public int getWeekOfYear() {
		return this.date.get(WeekFields.ISO.weekOfWeekBasedYear());
	}

	public Month getMonth() {
		return this.date.getMonth();
	}

	public int getYear() {
		return this.date.getYear();
	}

	public String format(String pattern) {
		return this.date.format(DateTimeFormatter.ofPattern(pattern));
	}
	
	public boolean isBefore(LocalDate date) {
		return this.date.isBefore(date.date);
	}

	public boolean isAfter(LocalDate date) {
		return this.date.isAfter(date.date);
	}

	public boolean isEqual(LocalDate date) {
		return this.date.isEqual(date.date);
	}

	public int compareTo(LocalDate date) {
		return this.date.compareTo(date.date);
	}

	@Override
	public String toString() {
		return this.date.toString();
	}

}

class LocalDateSerializer extends JsonSerializer<LocalDate>{

	@Override
	public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeString(value.toString());
	}
	
}
