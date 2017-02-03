package com.millervein.scorecard.scorecard;

import java.util.ArrayList;
import java.util.List;

public class LabeledDateRangeCollection {
	private String name;
	private List<LocalDateRange> dateRanges;

	public LabeledDateRangeCollection(String name, LocalDateRange dateRange) {
		this(name, new ArrayList<LocalDateRange>());
		this.dateRanges.add(dateRange);
	}
	
	public LabeledDateRangeCollection(String name, List<LocalDateRange> dateRanges) {
		super();
		this.name = name;
		this.dateRanges = dateRanges;
	}

	public String getName() {
		return name;
	}

	public List<LocalDateRange> getDateRanges() {
		return dateRanges;
	}

	@Override
	public String toString() {
		return "LabeledDateRange [name=" + name + ", dateRanges=" + dateRanges + "]";
	}

}
