package in.todoservletproject;

public class Tododto {
	private int todoId;
    private String currentDate;
    private String todoDesc;
    private String targetDate;
    private String todoStatus;
    
	public int getTodoId() {
		return todoId;
	}
	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public String getTodoDesc() {
		return todoDesc;
	}
	public void setTodoDesc(String todoDesc) {
		this.todoDesc = todoDesc;
	}
	public String getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	public String getTodoStatus() {
		return todoStatus;
	}
	public void setTodoStatus(String todoStatus) {
		this.todoStatus = todoStatus;
	} 
    
}
