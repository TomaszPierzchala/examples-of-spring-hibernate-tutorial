package eu.tp.springdemo.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Auxiliary class, just to have proper language determination by GitHub
 */
public class Run {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		
		Coach coach = context.getBean("bikeCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getFortune());
		context.close();
	}

}
