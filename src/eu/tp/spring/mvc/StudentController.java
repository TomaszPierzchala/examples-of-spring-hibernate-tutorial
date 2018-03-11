package eu.tp.spring.mvc;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("myMap")
@RequestMapping("/student")
public class StudentController {
	
	private static class MyMap<K, V> extends LinkedHashMap<K, V> {
		MyMap(){
			super();
			System.out.println("MyMap() is called");
		}
		
		MyMap(Map<K,V> map){
			super(map);
			System.out.println("MyMap(Map<K,V> map) is called");
		}
	}
	
//	@ModelAttribute
//	public Student createStudent() {
//		return new Student();
//	}
	
	@ModelAttribute("theCountryOptions")
	public MyMap<String, String> sortedMap() {
		return new MyMap<String, String>(sortByValues(countryOptions));
	}
	
    @Value("#{countryOptions}") 
    private Map<String, String> countryOptions;
    
    @RequestMapping("/showForm")
	public String showForm(@ModelAttribute("student") Student student) {
    		return "student-form";
    }
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student, 
			@ModelAttribute("theCountryOptions") MyMap<String, String> map ) {
		
		System.out.println("I read student : " + student);
		return "student-result";
	}

	public Map<String, String> getCountryOptions() {
		return countryOptions;
	}
	
	//Method for sorting the TreeMap based on values
	  private static <K, V extends Comparable<V>> Map<K, V> 
	    sortByValues(final Map<K, V> map) {
	    Comparator<K> valueComparator = 
	             new Comparator<K>() {
	      public int compare(K k1, K k2) {
	        int compare = 
	              map.get(k1).compareTo(map.get(k2));
//	        if (compare == 0) 
//	          return 1;
//	        else 
	          return compare;
	      }
	    };
	 
	    Map<K, V> sortedByValues = 
	      new TreeMap<K, V>(valueComparator);
	    sortedByValues.putAll(map);
	    return sortedByValues;
	  }
}
