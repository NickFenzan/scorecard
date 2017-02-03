package com.millervein.scorecard.scorecard;

import java.util.ArrayList;
import java.util.List;

public class ScorecardDates {
	private final int COMPARISON_YEARS = 2;
	private List<LabeledDateRangeCollection> previous; 
	private List<LabeledDateRangeCollection> current;
	private List<LabeledDateRangeCollection> summary;

	public ScorecardDates(LocalDate date) {
		LocalDate normalizedDate = normalizeDate(date);
		this.previous = createPreviousDates(normalizedDate);
		this.current = createCurrentDates(normalizedDate);
		this.summary = createSummaryDates(normalizedDate);
	}

	/**
	 * Adjust given date to Monday of last week
	 * 
	 * @param date
	 * @return
	 */
	private LocalDate normalizeDate(LocalDate date) {
		return date.withDayOfWeek(1).minusWeeks(1);
	}

	private List<LabeledDateRangeCollection> createPreviousDates(LocalDate sourceDate) {
		List<LabeledDateRangeCollection> previousDates = new ArrayList<LabeledDateRangeCollection>();
		LocalDate lastMonth = sourceDate.minusMonths(1);
		LocalDate start = lastMonth.withDayOfMonth(1);
		LocalDate end = lastMonth.withDayOfMonth(lastMonth.getMonth().maxLength());
		LocalDateRange previousMonth = new LocalDateRange(start, end);
		previousDates.add(new LabeledDateRangeCollection(Integer.toString(previousMonth.getStart().getYear()), previousMonth));
		for (int i = 1; i < COMPARISON_YEARS; i++) {
			LocalDateRange previousYear = previousMonth.minusYears(i);
			previousDates.add(new LabeledDateRangeCollection(Integer.toString(previousYear.getStart().getYear()), previousYear));
		}
		return previousDates;
	}

	private List<LabeledDateRangeCollection> createCurrentDates(LocalDate sourceDate) {
		List<LabeledDateRangeCollection> dates = new ArrayList<LabeledDateRangeCollection>();
		for (int i = 0; i < COMPARISON_YEARS; i++) {
			LocalDate date = sourceDate.minusYears(i);
			LocalDateRange dateRange = new LocalDateRange(date.minusWeeks(3), date);
			dates.add(new LabeledDateRangeCollection(Integer.toString(date.getYear()), dateRange.getWeeks()));
		}
		return dates;
	}

	private List<LabeledDateRangeCollection> createSummaryDates(LocalDate sourceDate) {
		List<LabeledDateRangeCollection> summaryDates = new ArrayList<LabeledDateRangeCollection>();
		LocalDateRange thisYearSummaryDates = new LocalDateRange(sourceDate.withDayOfMonth(1),
				sourceDate.withDayOfWeek(7));
		summaryDates.add(new LabeledDateRangeCollection(Integer.toString(thisYearSummaryDates.getStart().getYear()),thisYearSummaryDates));
		for (int i = 1; i < COMPARISON_YEARS; i++) {
			LocalDateRange dateRange = thisYearSummaryDates.minusYears(i);
			summaryDates.add(new LabeledDateRangeCollection(Integer.toString(dateRange.getStart().getYear()), dateRange));
		}
		return summaryDates;
	}

	public List<LabeledDateRangeCollection> getPrevious() {
		return previous;
	}

	public List<LabeledDateRangeCollection> getCurrent() {
		return current;
	}

	public List<LabeledDateRangeCollection> getSummary() {
		return summary;
	}

	@Override
	public String toString() {
		return "ScorecardDates [previous=" + previous + ", current=" + current + ", summary=" + summary + "]";
	}

}
