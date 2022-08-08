package contact;

import java.util.Map;
import java.time.LocalDate;
import java.util.HashMap;

/**
 * The appointment service can create an appointment with a unique ID as well as 
 * get and delete an appointment.
 * 
 * @author Sarah Kerr
 * @version 1.0
 * Created with Eclipse IDE 4.18.0
 */
public class AppointmentService {
	int Id = 0;
	
	private final Map<Integer, Appointment> appointmentList = new HashMap<>();
	
	/**
	 * Gives the appointment a unique ID and adds it to the hashmap
	 * 
	 * @param appointmentDate The date in YYYY-MM-DD format
	 * @param appointmentDescription The description of the appointment
	 * @return appointment object
	 */
	public Appointment addAppointment(LocalDate appointmentDate, String appointmentDescription) {
		Id++;
			
		Appointment appointment = new Appointment(appointmentDate, appointmentDescription);
			
		appointmentList.put(Id, appointment); //Map unique Id to each contact
					
		return appointment;		
	}
	
	/**
	 * Searches for an existing appointment and returns it if found
	 * @param ID The unique ID mapped to the appointment
	 * @return appointment object with the specified ID
	 * @throws IllegalArgumentException if no appointment exists with that ID
	 */
	public Appointment getAppointment(Integer ID) {		
		if (appointmentList.get(ID) == null)
		{
			throw new IllegalArgumentException("no such appointment");
		}
		else {
			return appointmentList.get(ID);
		}
	}		
	
	/**
	 * Deletes an appointment with the given ID and returns true if successful
	 * 
	 * @param ID The unique ID mapped to the appointment
	 * @return True if appointment successfully deleted
	 * @throws IllegalArgumentException if no appointment exists with the ID
	 */
	public boolean deleteAppointment(Integer ID) {
		if (appointmentList.get(ID) == null)
		{
			throw new IllegalArgumentException("Can't delete, no such appointment");			
		}
		else {
			appointmentList.remove(ID);
			return true;
		}
	}
}
