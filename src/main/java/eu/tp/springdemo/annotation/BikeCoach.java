package eu.tp.springdemo.annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BikeCoach implements Coach {

//	@Autowired
//	@Qualifier("happyFortuneService")
	@Resource(name = "happyFortuneService")
	private FortuneService service;
	
	public String getDailyWorkout() {
		return "Run for 15min slow, then 45min fast, and finally 45min slow";
	}


	public String getFortune() {
		return service.getDailyFortune();
	}

// 	@Autowired
	//	@Qualifier("RESTFortuneService")
		@Resource(name = "iRESTFortuneService")
		public void blabla(FortuneService service) {
			System.out.println(">> blabla(service)");
			this.service = service;
		}


	//	@Autowired
//	@Qualifier("randomFortuneService")
	@Resource(name = "randomFortuneService")
	public void setService(FortuneService service) {
		System.out.println(">> setService()");
		this.service = service;
	}


	@Autowired
	
	public BikeCoach(@Qualifier("databaseFortuneService") FortuneService service) {
		super();
		System.out.println("BikeCoaach(service)");
		this.service = service;
	}

}
