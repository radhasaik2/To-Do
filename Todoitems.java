package in.todoservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/Todoitems")
public class Todoitems extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String todohtml="<!DOCTYPE html>\r\n"
			+ "<html>\r\n"
			+ "<head>\r\n"
			+ "<style>\r\n"
			+ "table, th, td {\r\n"
			+ "  border-collapse: collapse;\r\n"
			+ "  padding: 6px;\r\n"
			+ "}\r\n"
			+ "</style>\r\n"
			+ "</head>\r\n"
			+ "<body>\r\n"
			+ "<form>\r\n"
			+ "<table>\r\n"
			+ "  <tr>\r\n"
			+ "    <td><label>Date:</label></td>\r\n"
			+ "    <td><input type=\"date\" id=\"date\" ></td>\r\n"
			+ "  </tr>\r\n"
			+ "  <tr>\r\n"
			+ "    <td><label>ToDo: </label></td>\r\n"
			+ "    <td><input type=\"text\" id=\"todo\"></td>\r\n"
			+ "  </tr>\r\n"
			+ "  <tr>\r\n"
			+ "    <td><label>Target Date & Time:</label></td>\r\n"
			+ "    <td><input type=\"datetime-local\" id=\"target\"></td>\r\n"
			+ "  </tr>\r\n"
			+ "  <tr>\r\n"
			+ "    <td><label>Status:</label></td>\r\n"
			+ "    <td><input type=\"datetime-local\" id=\"status\" name=\"status\"  readonly></td>\r\n"
			+ "  </tr>\r\n"
			+ "  <tr>\r\n"
			+ "    <td></td>\r\n"
			+ "    <td><input type=\"submit\" id=\"button\" placeholder=\"Submit\"  method=\"post\"></td>\r\n"
			+ "  </tr>\r\n"
			+ "</table>\r\n"
			+ "<table id=\"todoTable\">\r\n"
			+ "  <tr>\r\n"
			+ "    <th>ID</th>\r\n"
			+ "    <th>Current Date</th>\r\n"
			+ "    <th>ToDo Desc</th>\r\n"
			+ "    <th>Target Date</th>\r\n"
			+ "    <th>Status</th>\r\n"
			+ "    <th>Edit</th>\r\n"
			+ "  </tr>\r\n"
			+ "  <tbody>\r\n"
			+ "  </tbody>\r\n"
			+ "</table>\r\n"
			+ "</form>\r\n"
			+ "<script>\r\n"
			+ "  var todoList=[{todoId:101,currentDate : \"2025-07-31\",todoDesc : \"prepare to-do-list\",targetDate : \"2025-07-31 11:35\",todoStatus : \"PENDING\"},\r\n"
			+ "                {todoId:102,currentDate : \"2025-07-31\",todoDesc : \"Write a document\",targetDate : \"2025-07-31 12:40\",todoStatus : \"COMPLETE\",},\r\n"
			+ "                {todoId:103,currentDate : \"2025-08-01\",todoDesc : \"Practice\",targetDate : \"2025-08-01 01:40\",todoStatus : \"INPROGRESS\",}];\r\n"
			+ "  function getMaxTodoId(max, value, index, array) {\r\n"
			+ "    return max.todoId > value.todoId ? max : value;\r\n"
			+ "  }\r\n"
			+ "  console.log(\"max Obj :\"+todoList.reduce(getMaxTodoId));\r\n"
			+ "  var maxObj =todoList.reduce(getMaxTodoId);\r\n"
			+ "  console.log(\"max Id :\"+maxObj.todoId);\r\n"
			+ "  var todoId = maxObj.todoId;\r\n"
			+ "  function renderListTable(value, index, array){\r\n"
			+ "    console.log(value.todoId+\"\\n\"+value.currentDate+\"\\n\"+value.todoDesc + \"\\n\"+value.targetDate+\"\\n\"+value.todoStatus);\r\n"
			+ "    var newTodoTr = document.createElement(\"tr\");\r\n"
			+ "    var newTodoIdTd = document.createElement(\"td\");\r\n"
			+ "    newTodoIdTd.innerText = value.todoId;\r\n"
			+ "    var newTodoCurrentDateTd = document.createElement(\"td\");\r\n"
			+ "    newTodoCurrentDateTd.innerText = value.currentDate;\r\n"
			+ "    var newTodoDescTd = document.createElement(\"td\");\r\n"
			+ "    newTodoDescTd.innerText = value.todoDesc;\r\n"
			+ "    var newTodoTargetDateTd = document.createElement(\"td\");\r\n"
			+ "    newTodoTargetDateTd.innerText = value.targetDate;\r\n"
			+ "    var newTodoStatusTd = document.createElement(\"td\");\r\n"
			+ "    newTodoStatusTd.innerText = value.todoStatus;\r\n"
			+ "    var newTodoStatusInProgressBtnTd = document.createElement(\"td\");\r\n"
			+ "    var newInProgressBtn = document.createElement(\"button\");\r\n"
			+ "    newInProgressBtn.innerText = \"INPROGRESS\";\r\n"
			+ "    var newTodoStatusCompleteBtnTd = document.createElement(\"td\");\r\n"
			+ "    var newCompleteBtn = document.createElement(\"button\");\r\n"
			+ "    newCompleteBtn.innerText = \"COMPLETE\";\r\n"
			+ "    var newTodoEditBtnTd = document.createElement(\"td\");\r\n"
			+ "    var newEditBtn = document.createElement(\"button\");\r\n"
			+ "    newEditBtn.innerText = \"EDIT\";\r\n"
			+ "    newInProgressBtn.onclick = function() {\r\n"
			+ "      value.todoStatus = \"INPROGRESS\";\r\n"
			+ "      newTodoStatusTd.innerText = \"INPROGRESS\";\r\n"
			+ "      this.disabled = true;\r\n"
			+ "      newCompleteBtn.disabled = false;\r\n"
			+ "    };\r\n"
			+ "    newCompleteBtn.onclick = function() {\r\n"
			+ "      value.todoStatus = \"COMPLETE\";\r\n"
			+ "      newTodoStatusTd.innerText = \"COMPLETE\";\r\n"
			+ "      this.disabled = true;\r\n"
			+ "      newInProgressBtn.disabled = true;\r\n"
			+ "    };\r\n"
			+ "    newEditBtn.onclick = function() {\r\n"
			+ "        editTodoItem(value, newTodoIdTd, newTodoCurrentDateTd, newTodoDescTd, newTodoTargetDateTd);\r\n"
			+ "    };\r\n"
			+ "    switch(value.todoStatus) {\r\n"
			+ "               case \"PENDING\":\r\n"
			+ "                    newInProgressBtn.disabled = false;\r\n"
			+ "                    newCompleteBtn.disabled = true;\r\n"
			+ "                    break;\r\n"
			+ "                case \"INPROGRESS\":\r\n"
			+ "                    newInProgressBtn.disabled = true;\r\n"
			+ "                    newCompleteBtn.disabled = false;\r\n"
			+ "                    break;\r\n"
			+ "                case \"COMPLETE\":\r\n"
			+ "                    newInProgressBtn.disabled = true;\r\n"
			+ "                    newCompleteBtn.disabled = true;\r\n"
			+ "                    break;\r\n"
			+ "    }\r\n"
			+ "            newTodoTr.appendChild(newTodoIdTd);\r\n"
			+ "            newTodoTr.appendChild(newTodoCurrentDateTd);\r\n"
			+ "            newTodoTr.appendChild(newTodoDescTd);\r\n"
			+ "            newTodoTr.appendChild(newTodoTargetDateTd);\r\n"
			+ "            newTodoTr.appendChild(newTodoStatusTd);\r\n"
			+ "            newTodoTr.appendChild(newTodoStatusInProgressBtnTd);\r\n"
			+ "            newTodoTr.appendChild(newTodoStatusCompleteBtnTd);\r\n"
			+ "            newTodoTr.appendChild(newTodoEditBtnTd);\r\n"
			+ "            newTodoStatusInProgressBtnTd.appendChild(newInProgressBtn);\r\n"
			+ "            newTodoStatusCompleteBtnTd.appendChild(newCompleteBtn);\r\n"
			+ "            newTodoEditBtnTd.appendChild(newEditBtn);   \r\n"
			+ "            var todoTable = document.getElementById(\"todoTable\"); \r\n"
			+ "            todoTable.appendChild(newTodoTr);\r\n"
			+ "          }\r\n"
			+ "    function renderTodoItems(todoList){\r\n"
			+ "        var tbody = document.getElementById(\"todoTable\");\r\n"
			+ "        tbody.innerHTML = \"\";      // Clears already existing rows\r\n"
			+ "        todoList.forEach(renderListTable);\r\n"
			+ "    }\r\n"
			+ "  function addNewTodo(todoDesc,currentDate,targetDate,todoStatus) {\r\n"
			+ "        currentDate = document.getElementById(\"date\").value;\r\n"
			+ "        todoDesc = document.getElementById(\"todo\").value;\r\n"
			+ "        targetDate = document.getElementById(\"target\").value;\r\n"
			+ "        todoId++;\r\n"
			+ "    var todo={};\r\n"
			+ "    todo.todoId =todoId;\r\n"
			+ "    todo.currentDate =currentDate;\r\n"
			+ "    todo.todoDesc =todoDesc;\r\n"
			+ "    todo.targetDate = targetDate.replace('T', ' ');\r\n"
			+ "    todo.todoStatus = \"PENDING\";\r\n"
			+ "    todoList.push(todo);\r\n"
			+ "    renderListTable(todo); \r\n"
			+ "    console.log(todoList);\r\n"
			+ "}\r\n"
			+ "  function editTodoItem(todo, idTd, dateTd, descTd, targetTd) {\r\n"
			+ "            var newTodoIdInput = document.createElement(\"input\");\r\n"
			+ "            newTodoIdInput.type = \"text\";\r\n"
			+ "            newTodoIdInput.value = todo.todoId;\r\n"
			+ "            var newCurrentDateInput = document.createElement(\"input\");\r\n"
			+ "            newCurrentDateInput.type = \"date\";\r\n"
			+ "            newCurrentDateInput.value = todo.currentDate;\r\n"
			+ "            var newTodoDescInput = document.createElement(\"input\");\r\n"
			+ "            newTodoDescInput.type = \"text\";\r\n"
			+ "            newTodoDescInput.value = todo.todoDesc;\r\n"
			+ "            var newTargetDateInput = document.createElement(\"input\");\r\n"
			+ "            newTargetDateInput.type = \"datetime-local\";\r\n"
			+ "            newTargetDateInput.value = todo.targetDate.replace(' ', 'T'); \r\n"
			+ "            var saveBtn = document.createElement(\"button\");\r\n"
			+ "            saveBtn.innerText = \"Save\";\r\n"
			+ "            saveBtn.onclick = function() {\r\n"
			+ "            todo.todoId = newTodoIdInput.value;\r\n"
			+ "            todo.currentDate = newCurrentDateInput.value;\r\n"
			+ "            todo.todoDesc = newTodoDescInput.value;\r\n"
			+ "            todo.targetDate = newTargetDateInput.value.replace('T', ' ');\r\n"
			+ "                idTd.innerText = todo.todoId;\r\n"
			+ "                dateTd.innerText = todo.currentDate;\r\n"
			+ "                descTd.innerText = todo.todoDesc;\r\n"
			+ "                targetTd.innerText = todo.targetDate;\r\n"
			+ "                renderTodoItems(todoList);\r\n"
			+ "            };\r\n"
			+ "            idTd.innerHTML = \"\";\r\n"
			+ "            idTd.appendChild(newTodoIdInput);\r\n"
			+ "            dateTd.innerHTML = \"\";\r\n"
			+ "            dateTd.appendChild(newCurrentDateInput);\r\n"
			+ "            descTd.innerHTML = \"\";\r\n"
			+ "            descTd.appendChild(newTodoDescInput);\r\n"
			+ "            targetTd.innerHTML = \"\";\r\n"
			+ "            targetTd.appendChild(newTargetDateInput);\r\n"
			+ "            targetTd.appendChild(saveBtn);\r\n"
			+ "        }\r\n"
			+ "        renderTodoItems(todoList);\r\n"
			+ "</script>\r\n"
			+ "</body>\r\n"
			+ "</html>\r\n"
			+ "";

    public Todoitems() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
	        String todoDesc = request.getParameter("todoDesc");
	        String currentDateStr = request.getParameter("currentDate"); 
	        String targetDateStr = request.getParameter("targetDate");   
	        String todoStatus = request.getParameter("todoStatus");
		
		java.text.SimpleDateFormat sdfDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.text.SimpleDateFormat sdfDateTime = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        
		Date currentDate = sdfDate.parse(currentDateStr);
        Date targetDate = sdfDateTime.parse(targetDateStr);
        
        Todoitemsmain todo = new Todoitemsmain();
        todo.setCurrentDate(currentDate);
        todo.setTodoDesc(todoDesc);
        todo.setTargetDate(targetDate);
        todo.setTodoStatus(todoStatus);
        
        Tododbcon dao = new Tododbcon();
        
		 } catch (Exception e) {
		        e.printStackTrace();
		        response.getWriter().println("Error: " + e.getMessage());
		    }

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
