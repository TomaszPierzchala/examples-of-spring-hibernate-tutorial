package eu.tp.spring.mvc.validator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import eu.tp.spring.mvc.annotation.StartDate;

public class StartDateConstraintValidator implements ConstraintValidator<StartDate, Date> {
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date startDate = null;

	
	@Override
	public void initialize(StartDate constraintAnnotation) {
		try {
			startDate = dateFormat.parse(constraintAnnotation.startDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		boolean isNotBefore = ! value.before(startDate);
		return isNotBefore;
	}

}
