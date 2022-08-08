package contact;

/**
 * Contains the test methods for Task.java
 * 
 * testTask() - Testing to make sure each variable can be added to task
 * testTaskNameExceptionsUse() - Testing that exceptions are thrown for invalid 
 *  task name
 * testTaskDescriptionExceptionsUse() - Testing that exceptions are thrown for 
 *  invalid task description
 *  
 * @author Sarah Kerr
 * @version 1.0
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

class TaskTest {
	
	String name, description, tooLongName, tooLongDescription;
	
	@BeforeEach
	void setup() {
		
		name = "taskNameLessThan20";
		description = "taskdescription up to 50 chars";
		tooLongName = "taskNameTooLong123456";
		tooLongDescription = "task description is more than 50 characters long which violates the requirements of the task description";
		
	}

	@Test
	//testing to make sure each variable can be added to Task
	void testTask() {
		Task task = new Task(name, description);
		assertTrue(task.getTaskName().equals(name));
		assertTrue(task.getTaskDescription().equals(description));			
	}
	
	@Test
	//testing for exceptions thrown when too many characters entered for name
	void testTaskNameExceptionsUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(tooLongName, description);
		});
	}
	
	@Test
	//testing for exceptions thrown when too many characters entered for description
	void testTaskDescriptionExceptionsUse() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(name, tooLongDescription);
		});
	}
}
