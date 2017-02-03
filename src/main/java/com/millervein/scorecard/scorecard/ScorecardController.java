package com.millervein.scorecard.scorecard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/scorecard")
public class ScorecardController {
	@Autowired
	ScorecardBuilder scBuilder;

	@RequestMapping("")
	public Scorecard get(){
		return scBuilder.build();
	}
	
}
