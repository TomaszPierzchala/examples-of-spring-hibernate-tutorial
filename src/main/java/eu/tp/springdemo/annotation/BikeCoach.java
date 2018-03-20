package eu.tp.springdemo.annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BikeCoach implements Coach {

	// @Autowired
	// @Qualifier("happyFortuneService")
	// second injection order
	@Resource(name = "happyFortuneService")
	private FortuneService service;

	public String getDailyWorkout() {
		return "Run for 15min slow, then 45min fast, and finally 45min slow";
	}

	public String getFortune() {
		return service.getDailyFortune();
	}

	// @Autowired
	// @Qualifier("RESTFortuneService")
	// third injection order
	@Resource(name = "RESTFortuneService")
	public void blabla(FortuneService service) {
		System.out.println(">> blabla(service) : injected " + service.getClass());
		this.service = service;
	}

	// @Autowired
	// @Qualifier("randomFortuneService")
	@Resource(name = "randomFortuneService")
	// forth injection order
	public void setService(FortuneService service) {
		System.out.println(">> setService() : injeted " + service.getClass());
		this.service = service;
	}

	@Autowired
	// first injection order
	public BikeCoach(@Qualifier("databaseFortuneService") FortuneService service) {
		super();
		System.out.println("BikeCoaach(service) : injected " + service.getClass());
		this.service = service;
	}

}
