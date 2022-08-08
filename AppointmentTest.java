package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * Contains the test methods for Contact.java
 * 
 * testAppointment() - Test to make sure each variable can be added to Appointment
 * testApptDateExceptionsUse() - Testing for exception thrown if date is null or
 *  in the past
 * testApptDescriptionExceptionsUse() - Testing for exception thrown if description
 *  is null or too long
 *  
 * @author Sarah Kerr
 * @version 1.0
 */
class AppointmentTest {
	
private String description, tooLongDescription;
private LocalDate date, dateInPast; 
	
	@BeforeEach
	void setup() {
		date = LocalDate.of(2024, 1, 10);
		description = "appointment description up to 50 chars";
		dateInPast = LocalDate.of(2021, 1, 1);
		tooLongDescription = "appointment description is more than 50 characters long which violates the requirements of the appointment description";		
	}

	//testing to make sure each variable can be added to Appointment
	@Test
	void testAppointment() {
		Appointment appointment = new Appointment(date, description);
		
		assertTrue(appointment.getAppointmentDate().equals(date));
		assertTrue(appointment.getAppointmentDescription().equals(description));
	}
	
	//testing for exceptions thrown when date is in the past or null
	@Test
	void testApptDateExceptionsUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(dateInPast, description);
			new Appointment(null, description);
		});
	}
	
	//testing for exceptions thrown when too many characters entered and when null value entered for description
	@Test
	void testApptDescriptionExceptionsUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(date, tooLongDescription);
			new Appointment(date, "");
		});
	}
}
