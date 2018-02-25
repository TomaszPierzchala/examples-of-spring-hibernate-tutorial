package eu.tp.spring.spring_demo;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomSupportService implements SupportService {

	private final String [] INPUT_TEXT = {"Goog luck!", "Wont be bad!", "You should survive, I hope!"};
	private Random rnd = ThreadLocalRandom.current();
	
	public String supportMe() {
		return INPUT_TEXT[rnd.nextInt(INPUT_TEXT.length)];
	}

}
