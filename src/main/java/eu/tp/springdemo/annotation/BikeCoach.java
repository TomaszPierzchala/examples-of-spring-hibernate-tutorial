package eu.tp.springdemo.annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BikeCoach implements Coach {

	@Resource(name = "happyFortuneService")
	private FortuneService service;
	
	public String getDailyWorkout() {
		return "Run for 15min slow, then 45min fast, and finally 45min slow";
	}


	public String getFortune() {
		return service.getDailyFortune();
	}


//	@Autowired
	public BikeCoach(@Qualifier("happyFortuneService") FortuneService service) {
		super();
		System.out.println("BikeCoaach(service)");
		this.service = service;
	}

}
