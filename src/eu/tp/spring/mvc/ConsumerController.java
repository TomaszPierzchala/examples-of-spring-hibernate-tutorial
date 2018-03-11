package eu.tp.spring.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/consumer")
public class ConsumerController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//"dd-MM-yyyy");
//	    dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(
//	            dateFormat, false));
	}
	
	@RequestMapping("/showForm")
	public String showConsumer(@ModelAttribute("consumer") Consumer consumer) {
		return "consumer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("consumer") Consumer consumer, BindingResult bindingResult) {
		System.out.println(bindingResult);
		System.out.println("lastName  |" +consumer.getLastName() + "|");
		if(bindingResult.hasErrors()) {
			return "consumer-form";
		}
		
		return "consumer-confirmation";
	}
}
