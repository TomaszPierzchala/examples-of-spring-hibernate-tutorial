package eu.tp.springdemo.annotation;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	public String getDailyFortune() {
		return "Database  service";
	}

}
