package eu.tp.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.expression.spel.ast.MethodReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.core.Conventions.getVariableName;

@Controller
@RequestMapping("/home")
public class HomeController {
		
	@RequestMapping("/showForm")
	public String showForm() {
		return "showForm";
	}

	@RequestMapping("/processForm")
	public String showPage(Model model, HttpServletRequest request) {
		
		String studentName = request.getParameter("studentName");
		studentName = studentName.toUpperCase();
		
		String message = "Hej, ... " + studentName + " ! Are you OK ?";
		
		model.addAttribute ("message", message);
		
		String [] tab  = {"Ala", "Ola", "Ela"};
		model.addAttribute("tab", tab);
		
		return "processed.page";
	}

}
