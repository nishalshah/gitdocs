package com.test.app;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.task.PrimeTaskExecutor;

public class PrimeApp {

	public static void main(String[] args) {
	//Spring Container
	ApplicationContext springContainer = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		
	PrimeTaskExecutor primeTaskExecutor = springContainer.getBean(PrimeTaskExecutor.class);
	
	Scanner keyboard = new Scanner(System.in);
	System.out.println("Enter  N Value : ");
	int n = keyboard.nextInt();
	System.out.println("Enter  Thread Size : ");
	int threadSize = keyboard.nextInt();

	List<Integer> primeList = primeTaskExecutor.printPrimeNumbers(n,threadSize); 
	System.out.println( "Prime Numbers generated are: " + primeList);
	
	System.out.println( "No.Of Primes generated: " + primeList.size());
	
	System.exit(0);
		
	}

}
