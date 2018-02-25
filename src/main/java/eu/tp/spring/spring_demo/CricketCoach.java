package eu.tp.spring.spring_demo;

public class CricketCoach implements Coach {

	private SupportService support;
	
	private String name;
	private Integer age;
	
	public void setSupport(SupportService support) {
		this.support = support;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("CricketCoach.setName()");
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		System.out.println("CricketCoach.setAge()");
		this.age = age;
	}

	public String getDailyWorkout() {
		return "1h of cricet every Monday and Friday";
	}

	public String giveSupport() {
		return support.supportMe() + " for Cricet";
	}

}
