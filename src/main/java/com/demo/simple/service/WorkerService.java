package com.demo.simple.service;

import java.security.SecureRandom;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WorkerService {
	
	private static final SecureRandom random = new SecureRandom ();
	
    @Async
    public void doJob (int num) {

    	int duration = 5000 + (random.nextInt (10) * 1000);
    	try {
    		log.info ("Worker #{} duration : {} started", num, duration);
    		Thread.sleep (duration);
    		log.info ("Worker #{} duration : {} finished", num, duration);
    	} catch (InterruptedException e) { Thread.currentThread().interrupt (); e.printStackTrace (); }
    }
}