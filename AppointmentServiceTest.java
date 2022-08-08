package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * Contains the test methods for AppointmentService.java
 * 
 * testAddAppointment() - Test adding an appointment with a unique ID
 * testDeleteAppointment() - Test to successfully delete appointment
 * testGetAppointmentForExceptionUse() - Testing that exceptions are thrown for no
 *  appointment matching input
 *  testDeleteAppointmentForExceptionUse() -
 *  
 */
class AppointmentServiceTest {
	
	private String description1, description2, description3;
	private LocalDate date1, date2, date3;
	
	@BeforeEach
	void setup() {
		
		date1 = LocalDate.of(2023, 1, 1);
		date2 = LocalDate.of(2023, 1, 5);
		date3 = LocalDate.of(2023, 5, 15);
		description1 = "appointment description up to 50 chars";
		description2 = "second appointment description";
		description3 = "third appointment description";
		
	}

	/*
	* testing to successfully add appointments with unique ID. The AppointmentService creates a unique
	* ID by starting with 1 and incrementing each time an Appointment object is created. It then makes
	* this Id number the key for the hashmap, so we can use int 1 and int 2 as keys to get the 
	* corresponding appointment object. From there we can get each element.
	*/
	@Test
	void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		
		service.addAppointment(date1, description1);
		// The first appointment added will have an Id of 1 which we use as the hashmap key
		Appointment appointment1 = service.getAppointment(1);
		
		assertTrue(appointment1.getAppointmentDate().equals(date1));
		assertTrue(appointment1.getAppointmentDescription().equals(description1));
		
		service.addAppointment(date2, description2);
		// The first appointment added will have an Id of 1 which we use as the hashmap key
		Appointment appointment2 = service.getAppointment(2);
		
		assertTrue(appointment2.getAppointmentDate().equals(date2));
		assertTrue(appointment2.getAppointmentDescription().equals(description2));
	}
	
	/*
	 * Testing to ensure an appointment has been deleted successfully. The AppointmentService creates a unique
	 * ID by starting with 1 and incrementing each time an Appointment object is created. It then makes
	 * this Id number the key for the hashmap, so we can use int 1, 2, 3 as the keys to get our
	 * appointment objects after adding 3 unique appointments.
	 */
	@Test
	void testDeleteAppointment() {
		AppointmentService service = new AppointmentService();
		
		// Add 3 appointments
		service.addAppointment(date1, description1);
		service.addAppointment(date2, description2);
		service.addAppointment(date3, description3);
		
		// Using assertTrue to detect successful deletion of contact
		assertTrue(service.deleteAppointment(1)); // Delete appointment with key (Id) of 1
		assertTrue(service.deleteAppointment(3)); // Delete appointment with key (Id) of 1
		
		// Make sure contact with key (Id) of 2 hasn't been deleted
		Appointment appointment1 = service.getAppointment(2);
		assertTrue(appointment1.getAppointmentDate().equals(date2));
		assertTrue(appointment1.getAppointmentDescription().equals(description2));

	}
	
	/* Test attempting to get an appointment mapped to a key that does not exists in hashmap */
	@Test
	void testGetAppointmentForExceptionUse() {	
		AppointmentService service = new AppointmentService();
		
		// Add 1 appointment which will have unique ID of 1
		service.addAppointment(date1, description1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getAppointment(2); //appointment with ID 2 should not exist yet	
		});
	}
	
	/* Test attempting to delete an appointment mapped to a key that does not exist in hashmap */
	@Test
	void testDeleteAppointmentForExceptionUse() {		
		AppointmentService service = new AppointmentService();
		service.addAppointment(date1, description1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteAppointment(2); //contact with ID 2 should not exist yet, so can't delete	
		});
	}	
}