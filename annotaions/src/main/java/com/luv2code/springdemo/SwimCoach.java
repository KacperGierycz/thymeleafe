package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SwimCoach implements Coach {
	
	
	@Qualifier("happyFortuneService")
	@Autowired
	private FortuneService fortuneService;
	
	public SwimCoach() {
		System.out.println(">>SwimCoach defould constructor");
	}

    @Value("${foo.email}")
    private String email;
        
    @Value("${foo.team}")
    private String team;
    
    public String getEmail() {
    	return email;
    }
    public String getTeam() {
    	return team;
    }
	@Override
	public String getDailyWorkout() {
		return "Swim: 5 frogs, 5 crawls, 5 backs, 5 dophins";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}