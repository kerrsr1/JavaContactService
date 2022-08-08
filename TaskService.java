package contact;

/**
 * The Task Service can create a task with a unique ID and add it to a hashmap as
 * well as get, delete, and update a task
 * 
 * @author Sarah Kerr
 * @version 1.0
 * Created with Eclipse IDE 4.18.0
 */
import java.util.HashMap;
import java.util.Map;

public class TaskService {
	int Id = 0;
	
	private final Map<Integer, Task> taskList = new HashMap<>();
	
	/**
	 * Gives the task a unique ID and adds it the hashmap
	 * 
	 * @param taskName The name of the task
	 * @param taskDescription The description of the task
	 * @return Task object
	 */
	public Task addTask(String taskName, String taskDescription) {
		Id++;
			
		Task task = new Task(taskName, taskDescription);

		taskList.put(Id, task); //Map unique Id to each contact
					
		return task;		
	}
	
	/**
	 * Searches for an existing task and returns it if found
	 * 
	 * @param ID The unique ID mapped to each task
	 * @return The task object with the specified ID
	 * @throws IllegalArgumentException if no task exists with that ID
	 */
	public Task getTask(Integer ID)
	{	
		if (taskList.get(ID) == null)
		{
			throw new IllegalArgumentException("no such task");
		}
		else {
			return taskList.get(ID);
		}
	}	

	/**
	 * Deletes a contact with a given ID and returns True if successful
	 * 
	 * @param ID The unique ID mapped to each task
	 * @return True if task successfully deleted
	 * @throws IllegalArgumentException if no task exists with that ID
	 */
	public boolean deleteTask(Integer ID) {
		if (taskList.get(ID) == null)
		{
			throw new IllegalArgumentException("Can't delete, no such task");			
		}
		else {
			taskList.remove(ID);
			return true;
		}
	}
	
	/**
	 * Updates an existing task's name and description
	 * 
	 * @param ID The unique ID mapped to each task
	 * @param taskName The updated name of the task
	 * @param taskDescription The updated description of the task
	 * @return task The updated task object
	 */
	public Task updateTask(Integer ID, String taskName, String taskDescription) {			
		Task task = taskList.get(ID);
			task.setTaskName(taskName);
			task.setTaskDescription(taskDescription);
					
		return task;
	}
}
