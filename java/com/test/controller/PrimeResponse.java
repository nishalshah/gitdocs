package com.test.controller;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PrimeResponse {
	
	private List<Integer> primeNumber;
	
	private int totalPrimes;

	public int getTotalPrimes() {
		return totalPrimes;
	}

	public void setTotalPrimes(int totalPrimes) {
		this.totalPrimes = totalPrimes;
	}

	public List<Integer> getPrimeNumber() {
		return primeNumber;
	}

	public void setPrimeNumber(List<Integer> primeNumber) {
		this.primeNumber = primeNumber;
	}
	
	


}
