package eu.tp.springdemo.annotation;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	public String getDailyFortune() {
		return "Today is your lucky day!";
	}

}
