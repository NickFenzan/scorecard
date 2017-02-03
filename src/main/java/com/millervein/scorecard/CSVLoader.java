package com.millervein.scorecard;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class CSVLoader<T> {
	protected JpaRepository<T, Integer> repo;
	protected CSVParser<T> csvParser;

	public CSVLoader(JpaRepository<T, Integer> repo, CSVParser<T> csvParser) {
		super();
		this.repo = repo;
		this.csvParser = csvParser;
	}
	
	public void load(FileReader csv) throws IOException {
		List<T> objs = csvParser.parse(csv);
		repo.deleteAll();
		repo.save(objs);
		repo.flush();
	}
}
