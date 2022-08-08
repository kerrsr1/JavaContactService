package contact;

/**
 * Creates a task containing task name and description
 * 
 * @author Sarah Kerr
 * @version 1.0
 * Created with Eclipse IDE 4.18.0
 * 
 */
public class Task {
	
	private String taskName;
	private String taskDescription;

	/**
	 * Task constructor containing task name and description
	 * 
	 * @param taskName The name of the task
	 * @param taskDescription The description of the task
	 */
	public Task (String taskName, String taskDescription) {
		
	setTaskName(taskName);
	setTaskDescription(taskDescription);
	}
	
	/**
	 * Sets task name if it is not null or greater than 20 characters in length
	 * 
	 * @param taskName The name of the task
	 * @throws IllegalArgumentException if task name is null or greater than 20
	 *  characters in length
	 */
	public void setTaskName(String taskName) {
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("invalid task name");
		}
		this.taskName = taskName;
	}
	
	/**
	 * Sets the task description if it is not null or greater than 50 characters
	 * in length
	 *  
	 * @param taskDescription The description of the task
	 * @throws IllegalArgumentException if the description is null or greater than
	 *  50 characters in length
	 */
	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("invalid task description");
		}
		this.taskDescription = taskDescription;
	}
	
	/**
	 * Returns the task name
	 * 
	 * @return This task's name
	 */
	public String getTaskName() {
		return taskName;
	}
	
	/**
	 * Returns the task description
	 * 
	 * @return This task's description
	 */
	public String getTaskDescription() {
		return taskDescription;
	}
}
