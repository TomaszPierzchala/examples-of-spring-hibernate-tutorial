package eu.tp.springdemo.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
//@ComponentScan("eu.tp")
@PropertySources(value = {@PropertySource("main.properties")})
public class ConfigurationClass {
	
	@Bean
	FortuneService happyFortuneService() {
		return new FortuneService() {
			
			public String getDailyFortune() {
				return "o jo joj";
			}
		};
	}
	
	@Bean
	public FortuneService service() {
		System.out.println("First loading RandomFortuneService.class");
		return new RandomFortuneService();
	}
	
	@Bean
	public Coach theCoach() {
		return new BikeCoach(service());
	}
}
