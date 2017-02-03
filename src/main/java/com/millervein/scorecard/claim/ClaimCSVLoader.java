package com.millervein.scorecard.claim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millervein.scorecard.CSVLoader;

@Service
public class ClaimCSVLoader extends CSVLoader<Claim> {

	@Autowired
	public ClaimCSVLoader(ClaimRepository repo, ClaimCSVParser csvParser) {
		super(repo, csvParser);
	}
}
