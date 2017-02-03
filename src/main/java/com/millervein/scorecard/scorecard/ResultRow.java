package com.millervein.scorecard.scorecard;

import java.util.ArrayList;
import java.util.List;

public class ResultRow {
	private String rowLabel;
	private List<ResultColumn> columns;
	public ResultRow(String rowLabel, ResultColumn column) {
		this(rowLabel, new ArrayList<ResultColumn>());
		columns.add(column);
	}
	public ResultRow(String rowLabel, List<ResultColumn> columns) {
		super();
		this.rowLabel = rowLabel;
		this.columns = columns;
	}
	public String getRowLabel() {
		return rowLabel;
	}
	public List<ResultColumn> getColumns() {
		return columns;
	}
	@Override
	public String toString() {
		return "ResultRow [rowLabel=" + rowLabel + ", columns=" + columns + "]";
	}
	
}
