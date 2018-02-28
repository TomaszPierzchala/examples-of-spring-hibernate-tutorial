package eu.tp.springdemo.annotation;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Value("${fortune.0}")
	private String fortune0;
	
	@Value("${fortune.1}")
	private String fortune1;
	
	@Value("${fortune.2}")
	private String fortune2;

	@Value("${fortune.3}")
	private String fortune3;

	
	private String [] fortunes = null;
	
	
	
	public RandomFortuneService() {
		super();
		System.out.println("RandomFortuneService()");
	}

	@PostConstruct
	private void fortunes() {
		System.out.println("RandomFortuneService : @PostConstruct");
		fortunes = new String[4];
		fortunes[0] = fortune0;
		fortunes[1] = fortune1;
		fortunes[2] = fortune2;
		fortunes[3] = fortune3;
	}
	
	public String getDailyFortune() {
		
		Random rand =  new Random();
		int index = rand.nextInt(fortunes.length);
		String drawnFortune = fortunes[index];
		return drawnFortune;
	}

}
