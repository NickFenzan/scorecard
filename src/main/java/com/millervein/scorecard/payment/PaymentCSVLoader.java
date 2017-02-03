package com.millervein.scorecard.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millervein.scorecard.CSVLoader;

@Service
public class PaymentCSVLoader extends CSVLoader<Payment> {

	@Autowired
	public PaymentCSVLoader(PaymentRepository repo, PaymentCSVParser csvParser) {
		super(repo, csvParser);
	}

}
