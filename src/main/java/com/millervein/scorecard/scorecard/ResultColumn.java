package com.millervein.scorecard.scorecard;

public class ResultColumn {
	String label;
	String result;

	public ResultColumn(String label, String result) {
		super();
		this.label = label;
		this.result = result;
	}

	public String getLabel() {
		return label;
	}

	public String getResult() {
		return result;
	}

	@Override
	public String toString() {
		return "ResultColumn [label=" + label + ", result=" + result + "]";
	}

}
