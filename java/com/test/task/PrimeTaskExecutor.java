package com.test.task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class PrimeTaskExecutor {
	
	@Autowired
    private ObjectFactory<PrimeTask> prototypeFactory;
	
	//@Autowired
	//private ThreadPoolTaskExecutor taskExecutor; 
	
	public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(int threadSize){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		if(threadSize > 0){
			executor.setCorePoolSize(threadSize);
			executor.setMaxPoolSize(threadSize);
		}else{
			//Default Size
			executor.setCorePoolSize(10);
			executor.setMaxPoolSize(10);
		}
		executor.initialize();
		return executor;
	}
	
	public List<Integer> printPrimeNumbers(int n,int threadSize){
		List<Integer> primeList = Collections.synchronizedList(new ArrayList<Integer>());
		Collection<Future<?>> futures = new ArrayList<Future<?>>();
		ThreadPoolTaskExecutor taskExecutor = getThreadPoolTaskExecutor(threadSize);
		for(int i=1;i<=n;i++){
			PrimeTask task = prototypeFactory.getObject();
			task.setNumber(i);
			task.setPrimeList(primeList);
			futures.add(getThreadPoolTaskExecutor(threadSize).submit(task));
		}
		for (Future<?> future:futures) {
			try{
				future.get();
			}catch(Exception ex){
				
			}
		    
		}
		taskExecutor.shutdown();
		return primeList;
	}

}
