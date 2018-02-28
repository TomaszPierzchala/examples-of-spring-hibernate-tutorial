package eu.tp.springdemo.annotation;

import org.springframework.stereotype.Component;

@Component
public class iRESTFortuneService implements FortuneService {

	public String getDailyFortune() {
		return "REST service";
	}

}
