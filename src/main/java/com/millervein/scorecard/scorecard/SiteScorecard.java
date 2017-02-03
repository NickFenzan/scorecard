package com.millervein.scorecard.scorecard;

import java.util.List;
import java.util.Optional;

public class SiteScorecard implements ScorecardPage {
	private String siteName;
	private List<Metric> metrics;

	public SiteScorecard(String siteName, List<Metric> metrics) {
		super();
		this.siteName = siteName;
		this.metrics = metrics;
	}

	@Override
	public String getName() {
		return this.siteName;
	}

	public List<Metric> getMetrics() {
		return metrics;
	}

	public Optional<Metric> getMetric(String name) {
		return this.metrics.stream().filter(metric -> metric.getName().equals(name)).findFirst();
	}

	@Override
	public String toString() {
		return "SiteScorecard [siteName=" + siteName + ", metrics=" + metrics + "]";
	}

}
