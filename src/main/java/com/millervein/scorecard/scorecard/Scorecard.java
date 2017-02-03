package com.millervein.scorecard.scorecard;

import java.util.List;

public class Scorecard {
	public ScorecardDates dates;
	public List<ScorecardPage> pages;

	public Scorecard(ScorecardDates dates, List<ScorecardPage> pages) {
		super();
		this.dates = dates;
		this.pages = pages;
	}

	public ScorecardDates getDates() {
		return dates;
	}

	public List<ScorecardPage> getPages() {
		return pages;
	}

	@Override
	public String toString() {
		return "Scorecard [dates=" + dates + ", pages=" + pages + "]";
	}
	
}
