package com.millervein.scorecard.scorecard;

import java.util.List;

public class Metric {
	protected String name;
	protected String personResponsible;
	protected List<ResultRow> previous;
	protected List<ResultRow>results;
	protected List<ResultRow> summary;

	public Metric(String name, String personResponsible) {
		super();
		this.name = name;
		this.personResponsible = personResponsible;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonResponsible() {
		return personResponsible;
	}

	public void setPersonResponsible(String personResponsible) {
		this.personResponsible = personResponsible;
	}

	public List<ResultRow> getPrevious() {
		return previous;
	}

	public void setPrevious(List<ResultRow> previous) {
		this.previous = previous;
	}

	public List<ResultRow> getResults() {
		return results;
	}

	public void setResults(List<ResultRow> results) {
		this.results = results;
	}

	public List<ResultRow> getSummary() {
		return summary;
	}

	public void setSummary(List<ResultRow> summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "Metric [name=" + name + ", personResponsible=" + personResponsible + ", previous=" + previous
				+ ", results=" + results + ", summary=" + summary + "]";
	}


}
