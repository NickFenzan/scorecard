package com.millervein.scorecard.scorecard;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ExcelWriter {
	private CellStyle headerStyle;
	private CellStyle headerSummaryStyle;
	private CellStyle summaryStyle;

	public void writeToExcel(String filename, Scorecard scorecard) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(filename);
		Workbook wb = new XSSFWorkbook();
		createStyles(wb);
		this.createHeaderStyle(wb);
		try {
			scorecard.getPages().stream().forEach(page -> writePage(wb, page, scorecard));
			wb.write(fileOut);
		} finally {
			wb.close();
		}

	}

	private void createStyles(Workbook wb) {
		createHeaderStyle(wb);
		createHeaderSummaryStyle(wb);
	}

	private void createHeaderStyle(Workbook wb) {
		this.headerStyle = wb.createCellStyle();
		Font font = wb.createFont();
		font.setBold(true);
		font.setFontHeightInPoints((short) 10);
		font.setFontName("Arial");
		this.headerStyle.setAlignment(HorizontalAlignment.CENTER);
		this.headerStyle.setFont(font);
		this.headerStyle.setWrapText(true);
		this.headerStyle.setBorderLeft(BorderStyle.THIN);
		this.headerStyle.setBorderRight(BorderStyle.THIN);
		this.headerStyle.setBorderTop(BorderStyle.THIN);
		this.headerStyle.setBorderBottom(BorderStyle.MEDIUM);

	}

	private void createHeaderSummaryStyle(Workbook wb) {
		this.headerSummaryStyle = this.headerStyle;
		this.headerSummaryStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		this.headerSummaryStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	}

	private void writePage(Workbook wb, ScorecardPage page, Scorecard scorecard) {
		Sheet sheet = wb.createSheet(page.getName());
		sheet.setDefaultColumnWidth(12);
		writeHeaders(sheet.createRow(0), scorecard);

	}

	private void writeHeaders(Row row, Scorecard scorecard) {
		row.setHeightInPoints(25);
		Cell personResp = row.createCell(0);
		personResp.setCellValue("Person Responsible");
		personResp.setCellStyle(headerStyle);
		Cell metric = row.createCell(1);
		metric.setCellValue("Metric");
		metric.setCellStyle(headerStyle);
		Cell year = row.createCell(2);
		year.setCellValue("Year");
		year.setCellStyle(headerStyle);
		Cell previous = row.createCell(3);
		previous.setCellValue(scorecard.getDates().getPrevious().get(0).getDateRanges().get(0).getStart().getMonth().toString());
	}
}
