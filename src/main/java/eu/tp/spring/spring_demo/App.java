package eu.tp.spring.spring_demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
    		System.out.println("After context");
    		
    		FootballCoach theCoach = context.getBean("ala", FootballCoach.class);
    		FootballCoach theCoach2 = context.getBean("theCoach", FootballCoach.class);
    		theCoach.setAuxilary("mój bean, hej :-)");
    		theCoach2.setAuxilary("a może co innego ?...");
    		System.out.println("theCoach : " + theCoach.getAuxilary());
    		System.out.println("theCoach2 : " + theCoach2.getAuxilary());
    		
    		System.out.println(theCoach.getDailyWorkout());
    		System.out.println(theCoach.giveSupport());
    		System.out.println();
    		
    		CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);
    		System.out.println(coach.getClass());
    		System.out.println(coach.getDailyWorkout());
    		System.out.println(coach.giveSupport());
    		System.out.println(coach.getName());
    		System.out.println(coach.getAge());
    		
//    		theCoach = null;
//    		theCoach2 = null;
//    		System.out.println("before gc()");
//    		System.gc();
//    		System.out.println("after gc()");
    		
    		System.out.println(theCoach.getDailyWorkout());
    		theCoach = null; theCoach2 = null;
    		
    		System.out.println("before context.close()");
    		context.close();
    		System.out.println("after context.close()");
    		
    		System.gc();
    		System.out.println("after gc()");
    		Thread.sleep(2000);
    }
}
