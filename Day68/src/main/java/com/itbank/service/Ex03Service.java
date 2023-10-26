package com.itbank.service;

import org.springframework.stereotype.Service;

@Service
public class Ex03Service {

	public char getGrade(int score) {
		char rank = 'F';
		
		if (score >= 90) rank = 'A';
		else if (score >= 80) rank = 'B';
		else if (score >= 70) rank = 'C';
		else if (score >= 60) rank = 'D';
		
		return rank;
	}

}
