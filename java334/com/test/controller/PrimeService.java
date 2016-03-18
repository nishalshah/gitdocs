package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.task.PrimeTaskExecutor;

@Controller
public class PrimeService {
	
	@Autowired
	PrimeTaskExecutor primeTaskExecutor;
	
	@RequestMapping(method=RequestMethod.GET,value="/prime/{n}")
	public @ResponseBody PrimeResponse getPrimeList(@PathVariable Integer n,@RequestParam Integer threadSize){
		List<Integer> primeList = primeTaskExecutor.printPrimeNumbers(n,threadSize!=null ? threadSize : 0);
		PrimeResponse response = new PrimeResponse();
		response.setPrimeNumber(primeList);
		response.setTotalPrimes(primeList.size());
		return response;
	}
}
