package eu.tp.spring.mvc;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import eu.tp.spring.mvc.annotation.StartDate;

//@PropertySource("main.properties")
@Component
public class Consumer {

	private String firstName;
	
	@NotNull(message="more then white spaces is required")
	@Size(min=1, message="is required")
	private String lastName;
	
	@Min(message="value must be int [0, 10]", value=0)
	@Max(message="value must be int [0, 10]", value=10)
	private Integer freePasses;
	
	@Pattern(regexp="[a-zA-Z0-9]{5}|[a-zA-Z]{0,2}[0-9]{2}-?[0-9]{3}")
	@NotNull
	private String postalCode;
	
	
	@StartDate( startDate="2018-02-01", message="As we have started on 2018-02-01 date can not be earlier.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date consumerSince;
	
	Consumer(){
		System.out.println("Consumer() is called");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Date getConsumerSince() {
		return consumerSince;
	}

	public void setConsumerSince(Date consumerSince) {
		this.consumerSince = consumerSince;
	}
}
