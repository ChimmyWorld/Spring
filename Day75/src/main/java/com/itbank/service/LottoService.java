package com.itbank.service;

import java.util.Random;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service
public class LottoService {
	public TreeSet<Integer> getLotto(){
		Random ran = new Random();
		TreeSet<Integer> ts = new TreeSet<>();
		
		while(ts.size() != 6) {
			int num = ran.nextInt(45) + 1;
			ts.add(num);
		}
		
		return ts;
	}
	
}
