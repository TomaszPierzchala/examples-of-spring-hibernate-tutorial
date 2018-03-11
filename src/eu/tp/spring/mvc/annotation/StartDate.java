package eu.tp.spring.mvc.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import eu.tp.spring.mvc.validator.StartDateConstraintValidator;

@Constraint(validatedBy = { StartDateConstraintValidator.class })
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface StartDate {
	/**
	 * @param startDate limit (day when the business had started). 
	 * Date in format SimpleDateFormat("dd-MM-yyyy");
	 */
	public String startDate() default "2017-12-31";
	public String message() default "Date must be after start date startDate()";
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {};
}
