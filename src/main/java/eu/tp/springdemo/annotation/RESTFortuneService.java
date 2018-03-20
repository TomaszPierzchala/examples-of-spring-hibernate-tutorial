package eu.tp.springdemo.annotation;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

	public String getDailyFortune() {
		return "REST service";
	}

}
