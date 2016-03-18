package com.test.task;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.test.util.PrimeUtil;

@Component
@Scope("prototype")
public class PrimeTask implements Runnable {

	private int number;
	
	private List<Integer> primeList;
	
	@Override
	public void run() {
		if(PrimeUtil.isPrime(number)){
			primeList.add(number);
		}
	}
	
	public void setNumber(int number){
		this.number = number;
	}
	
	public void setPrimeList(List<Integer> primeList){
		this.primeList = primeList;
	}
}
