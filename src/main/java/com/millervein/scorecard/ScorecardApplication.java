package com.millervein.scorecard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.millervein.scorecard.scorecard.ExcelWriter;
import com.millervein.scorecard.scorecard.ScorecardBuilder;

@SpringBootApplication
public class ScorecardApplication implements CommandLineRunner {
	@Autowired
	ExcelWriter w;
	
	@Autowired
	ScorecardBuilder sb;

	public static void main(String[] args) {
		SpringApplication.run(ScorecardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		print(sb.build());
		w.writeToExcel("test.xlsx", sb.build());
		print("Done");
	}

	public void print(Object any){
		System.out.println(any);
	}
	
}
