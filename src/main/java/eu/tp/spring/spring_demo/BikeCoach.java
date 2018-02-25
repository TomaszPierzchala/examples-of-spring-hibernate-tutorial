package eu.tp.spring.spring_demo;


public class BikeCoach implements Coach {
	
	private SupportService support;
	

	public BikeCoach(SupportService support) {
		super();
		this.support = support;
	}

	public String getDailyWorkout() {
		return "Ride faster, go go !";
	}

	public String giveSupport() {
		return support.supportMe();
	}

}
