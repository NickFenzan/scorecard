package com.millervein.scorecard.scorecard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.millervein.scorecard.appointment.AppointmentRepository;

@Component
public class AppointmentTypeCountMetricLookup {
	@Autowired
	AppointmentRepository apptRepo;

	public AppointmentTypeCountMetric lookupResults(AppointmentTypeCountMetric metric, ScorecardDates dates) {
		metric.setPrevious(previousResults(metric, dates.getPrevious()));
		metric.setResults(currentResults(metric, dates.getCurrent()));
		metric.setSummary(summaryResults(metric, dates.getSummary()));
		return metric;
	}

	private List<ResultRow> previousResults(AppointmentTypeCountMetric metric, List<LabeledDateRangeCollection> dates) {
		return fillResults(metric, dates, date -> date.getMonth().toString());
	}

	private List<ResultRow> currentResults(AppointmentTypeCountMetric metric, List<LabeledDateRangeCollection> dates) {
		return fillResults(metric, dates, date->date.toString());
	}
	
	private List<ResultRow> summaryResults(AppointmentTypeCountMetric metric, List<LabeledDateRangeCollection> dates) {
		return fillResults(metric, dates, date-> date.getMonth().toString());
	}
	
	private List<ResultRow> fillResults(AppointmentTypeCountMetric metric, List<LabeledDateRangeCollection> dates, ColumnNamingStrategy namingStrategy){
		List<ResultRow> resultRows = new ArrayList<ResultRow>();
		String apptType = metric.getAppointmentType().toString();
		String site = metric.getSite();
		for (int i = 0; i < dates.size(); i++) {
			String year = dates.get(i).getName();
			List<LocalDateRange> yearDates = dates.get(i).getDateRanges();
			List<ResultColumn> cols = new ArrayList<ResultColumn>();
			for(int j = 0; j < yearDates.size(); j++){
				LocalDate start = yearDates.get(j).getStart();
				LocalDate end = yearDates.get(j).getEnd();
				Integer apptCount = (null == site)
						? apptRepo.countAppointmentsByDateRangeType(start.toString(), end.toString(), apptType)
						: apptRepo.countAppointmentsByDateRangeTypeAndDepartment(start.toString(), end.toString(),
								apptType, site);
						cols.add(new ResultColumn(namingStrategy.dateToName(start), apptCount.toString()));
			}
			resultRows.add(new ResultRow(year, cols));
		}
		return resultRows;
	}
	
	interface ColumnNamingStrategy {
		String dateToName(LocalDate date);
	}
}
