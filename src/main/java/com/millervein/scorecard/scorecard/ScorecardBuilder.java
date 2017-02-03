package com.millervein.scorecard.scorecard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.millervein.scorecard.appointment.AppointmentType;
@Component
public class ScorecardBuilder {
	@Autowired
	AppointmentTypeCountMetricLookup apptLookup;
	
	public Scorecard build(){
		return this.build(LocalDate.now());
	}
	
	public Scorecard build(LocalDate date){
		Scorecard scorecard = new Scorecard(new ScorecardDates(date), buildPages());
		scorecard.getPages().stream().filter(page -> page instanceof SiteScorecard).map(page -> (SiteScorecard) page).forEach(page->{
			page.getMetrics().stream().filter(metric -> metric instanceof AppointmentTypeCountMetric).map(metric -> (AppointmentTypeCountMetric) metric).forEach(metric->{
				apptLookup.lookupResults(metric, scorecard.getDates());
			});
		});
		return scorecard;
	}
	
	private List<ScorecardPage> buildPages(){
		List<ScorecardPage> pages = new ArrayList<ScorecardPage>();
		pages.add(new SiteScorecard("Overall", defaultSiteMetrics("Linda Miller", null)));
		pages.add(new SiteScorecard("Novi", defaultSiteMetrics("Cindy Lieto", "Novi")));
		pages.add(new SiteScorecard("Troy", defaultSiteMetrics("Dianne Nichols", "Troy")));
		pages.add(new SiteScorecard("Dearborn", defaultSiteMetrics("Carol Leeth", "Dearborn")));
		pages.add(new SiteScorecard("Monroe", defaultSiteMetrics("Carol Leeth", "Monroe")));
		return pages;
	}
	
	private List<Metric> defaultSiteMetrics(String responsible, String site){
		ArrayList<Metric> metrics = new ArrayList<Metric>();
		metrics.add(new AppointmentTypeCountMetric("Free Consults", responsible, AppointmentType.FREE, site));
		metrics.add(new AppointmentTypeCountMetric("New Patients", responsible, AppointmentType.NEW, site));
		metrics.add(new AppointmentTypeCountMetric("Longterm Followups", responsible, AppointmentType.FOLLOWUP, site));
		metrics.add(new AppointmentTypeCountMetric("Procedures", responsible, AppointmentType.PROCEDURE, site));
		metrics.add(new AppointmentTypeCountMetric("VeinErase", responsible, AppointmentType.VEINERASE, site));
		return metrics;
	}

}
