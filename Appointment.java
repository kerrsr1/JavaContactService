package contact;

import java.time.LocalDate;

/**
 * Creates an Appointment object containing the appointment date and description
 * 
 * @author Sarah Kerr
 * @version 1.0
 * Created with Eclipse IDE 4.18.0
 */
public class Appointment {
	
	private LocalDate appointmentDate;
	private String appointmentDescription;
	
	// Appointment constructor
	public Appointment (LocalDate appointmentDate, String appointmentDescription) {	
		setAppointmentDate(appointmentDate);
		setAppointmentDescription(appointmentDescription);	
	}
	
	/**
	 * Sets the input appointment date as long as it is not in the past
	 * 
	 * @param appointmentDate The date of the appointment
	 * @throws IllegalArgumentException if the date is null or in the past
	 */
	public void setAppointmentDate(LocalDate appointmentDate) {
		//Get todays's date and make sure it is before the input date
		LocalDate currentDate = LocalDate.now();
						
		if (appointmentDate == null || appointmentDate.isBefore(currentDate)) {
			throw new IllegalArgumentException("Date cannot be null or in the past");
		}
		this.appointmentDate = appointmentDate;
	}
	
	/**
	 * Sets the appointment description as a string as long as it is not null or greater than
	 * 50 characters
	 * 
	 * @param appointmentDescription The description of the appointment
	 * @throws IllegalArgumentException if the description is null or greater than 50
	 *  characters
	 */
	public void setAppointmentDescription(String appointmentDescription) {
		if (appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("invalid appointment description");
		}	
		this.appointmentDescription = appointmentDescription;
	}
	
	/**
	 * Returns the appointment date
	 * 
	 * @return This appointment's date
	 */
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	
	/**
	 * Returns the appointment description
	 * @return This appointment's description
	 */
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
}
