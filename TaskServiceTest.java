package contact;

/**
 * Contains the test methods for TaskService.java
 * 
 * testAddTask() - Test adding a task with a unique ID
 * testDeleteTask() - Test to ensure task has been deleted successfully
 * testUpdateTask() - Test to ensure task has been updated successfully
 * testGetTaskForExceptionUse() - Testing that exceptions are thrown for errors
 *  in getting a task
 * testDeleteTaskForExceptionUse() - Testing that exceptions are thrown if not able
 *  to delete a task
 * 
 * @author Sarah Kerr
 * @version 1.0
 */
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
	
	private String name1, name2, name3, description1, description2, description3;
	
	@BeforeEach
	void setup() {
		
		name1 = "name1";
		name2 = "name2";
		name3 = "name3";
		description1 = "task description up to 50 chars";
		description2 = "second task description";
		description3 = "third task description";
	
	}
	
	@Test
	/*
	* testing to successfully add tasks with unique ID. The TaskService creates a unique
	* ID by starting with 1 and incrementing each time a Task object is created. It then makes
	* this Id number the key for the hashmap, so we can use int 1 and int 2 as keys to get the 
	* corresponding task object. From there we can get each element.
	*/
	void testAddTask() {
		TaskService service = new TaskService();
		
		service.addTask(name1, description1);
		Task task1 = service.getTask(1); // The first task added will have an Id of 1 which we use as the hashmap key
		
		assertTrue(task1.getTaskName().equals(name1));
		assertTrue(task1.getTaskDescription().equals(description1));
		
		service.addTask(name2, description2);
		Task task2 = service.getTask(2); // The second task added will have an Id of 2 which we use as the hashmap key
		
		assertTrue(task2.getTaskName().equals(name2));
		assertTrue(task2.getTaskDescription().equals(description2));
	}
	
	@Test 
	/*
	 * Testing to ensure a task has been deleted successfully. The TaskService creates a unique
	 * ID by starting with 1 and incrementing each time a Task object is created. It then makes
	 * this Id number the key for the hashmap, so we can use int 1, 2, 3 as the keys to get our
	 * task objects after adding 3 unique tasks.
	 */
	void testDeleteTask() {
		
		TaskService service = new TaskService();
		
		// Add 3 tasks
		service.addTask(name1, description1);
		service.addTask(name2, description2);
		service.addTask(name3, description3);
		
		// Using assertTrue to detect successful deletion of a task
		assertTrue(service.deleteTask(1)); // Delete task with key (Id) of 1
		assertTrue(service.deleteTask(3)); // Delete task with key (Id) of 3
		
		// Make sure contact with key (Id) of 2 hasn't been deleted
		Task task1 = service.getTask(2);
		assertTrue(task1.getTaskName().equals(name2));
		assertTrue(task1.getTaskDescription().equals(description2));
	}
	
	@Test
	/*
	 * Testing to ensure successful update of existing task. A task is first added and then is updated and
	 * checked to make sure the task object elements have been replaced.
	 */
	void testUpdateTask() {
		
		TaskService service = new TaskService();
		
		service.addTask(name1, description1);
		int taskKey = 1; // The first task added will have a unique Id (which is the key) of 1
		
		service.updateTask(taskKey, name2, description2);
		
		Task task1 = service.getTask(1);
		
		//checks to make sure the task got updated
		assertTrue(task1.getTaskName().equals(name2));
		assertTrue(task1.getTaskDescription().equals(description2));
	}

	@Test
	/* Test attempting to get a task mapped to a key that does not exists in hashmap */
	void testGetTaskForExceptionUse() {
		
		TaskService service = new TaskService();
		// Add 1 contact which will have unique ID of 1
		service.addTask(name1, description1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.getTask(2); //Task with ID 2 should not exist yet	
		});
	}
	
	@Test
	/* Test attempting to delete a contact mapped to a key that does not exist in hashmap */
	void testDeleteTaskForExceptionUse() {
		
		TaskService service = new TaskService();
		service.addTask(name1, description1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteTask(2); //contact with ID 2 should not exist yet, so can't delete	
		});
	}
}
