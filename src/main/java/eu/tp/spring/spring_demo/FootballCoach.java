package eu.tp.spring.spring_demo;


public class FootballCoach implements Coach {

	private SupportService support;
	
	private String auxilary;
	
	public FootballCoach(SupportService support) {
		super();
		this.support = support;
	}


	public String getDailyWorkout() {
		return "Play football now !";
	}


	public String giveSupport() {
		return "Yes, " + support.supportMe();
	}


	public String getAuxilary() {
		return auxilary;
	}


	public void setAuxilary(String auxilary) {
		this.auxilary = auxilary;
	}

	private void startMethod() {
		System.out.println("let's start!");
	}

	private void stopMethod() {
		System.out.println("STOP - destroy method!");
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("stop now - finalize");
		super.finalize();
	}
	
	
}
