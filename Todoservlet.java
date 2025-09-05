package in.todoservletproject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Todoservlet")
public class Todoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String todostr="\r\n"
	        + "<!DOCTYPE html>\r\n"
	        + "<html>\r\n"
	        + "<head>\r\n"
	        + "<title>To-Do List</title>\r\n"
	        + "<style>\r\n"
	        + "table, th, td {\r\n"
	        + "  border-collapse: collapse;\r\n"
	        + "  padding: 6px;\r\n"
	        + "}\r\n"
	        + "</style>\r\n"
	        + "</head>\r\n"
	        + "<body>\r\n"
	        + "<form method=\"post\" action=\"Todoservlet\">\r\n"  
	        + "<table>\r\n"
	        + "  <tr>\r\n"
	        + "    <td><label>Date:</label></td>\r\n"
	        + "    <td><input type=\"date\" id=\"date\" name=\"CurrentDate\" required></td>\r\n"
	        + "  </tr>\r\n"
	        + "  <tr>\r\n"
	        + "    <td><label>ToDo: </label></td>\r\n"
	        + "    <td><input type=\"text\" id=\"todo\" name=\"TodoDesc\" required></td>\r\n"
	        + "  </tr>\r\n"
	        + "  <tr>\r\n"
	        + "    <td><label>Target Date & Time:</label></td>\r\n"
	        + "    <td><input type=\"datetime-local\" id=\"target\" name=\"TargetDate\" required></td>\r\n"
	        + "  </tr>\r\n"
	        + "  <tr>\r\n"
	        + "    <td><label>Status:</label></td>\r\n"
	        + "    <td><input type=\"text\" id=\"status\" name=\"TodoStatus\" value=\"PENDING\" readonly></td>\r\n"
	        + "  </tr>\r\n"
	        + "  <tr>\r\n"
	        + "    <td></td>\r\n"
	        + "    <td><button type=\"submit\">SUBMIT</button></td>\r\n"  
	        + "  </tr>\r\n"
	        + "</table>\r\n"
	        + "</form>\r\n"  
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
	        + "</body>\r\n"
	        + "</html>\r\n"
	        + "";
	String str="<script>\r\n"
	        + "  var todoList=[{\r\n"
	        + "                    todoId:101,\r\n"
	        + "                    currentDate : \"2025-07-31\",\r\n"
	        + "                    todoDesc : \"prepare to-do-list\",\r\n"
	        + "                    targetDate : \"2025-07-31 11:35\",\r\n"
	        + "                    todoStatus : \"PENDING\"\r\n"
	        + "                },\r\n"
	        + "                {\r\n"
	        + "                    todoId:102,\r\n"
	        + "                    currentDate : \"2025-07-31\",\r\n"
	        + "                    todoDesc : \"Write a document\",\r\n"
	        + "                    targetDate : \"2025-07-31 12:40\",\r\n"
	        + "                    todoStatus : \"COMPLETE\",\r\n"
	        + "                },\r\n"
	        + "                {\r\n"
	        + "                    todoId:103,\r\n"
	        + "                    currentDate : \"2025-08-01\",\r\n"
	        + "                    todoDesc : \"Practice\",\r\n"
	        + "                    targetDate : \"2025-08-01 01:40\",\r\n"
	        + "                    todoStatus : \"INPROGRESS\",\r\n"
	        + "                }];\r\n"
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
	        + "            newTodoEditBtnTd.appendChild(newEditBtn);\r\n"
	        + "            var todoTable = document.getElementById(\"todoTable\"); \r\n"
	        + "            todoTable.appendChild(newTodoTr);\r\n"
	        + "          }\r\n"
	        + "    function renderTodoItems(todoList){\r\n"
	        + "        var tbody = document.getElementById(\"todoTable\");\r\n"
	        + "        tbody.innerHTML = \"\";      // Clears already existing rows\r\n"
	        + "        todoList.forEach(renderListTable);\r\n"
	        + "    }\r\n"
	        + "        renderTodoItems(todoList);\r\n"
	        + "</script>\r\n"
	        + "</body>\r\n"
	        + "</html>\r\n"
	        + "";
	        
    public Todoservlet() throws Exception {
        super.init();;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(todostr);
	    
	  }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        String currentDate = request.getParameter("CurrentDate");
	        String todoDesc = request.getParameter("TodoDesc");
	        String targetDate = request.getParameter("TargetDate");
	        String todoStatus = request.getParameter("TodoStatus");
	        
	        if (todoStatus == null || todoStatus.isEmpty()) {
	            todoStatus = "PENDING";
	        }
	        Tododto todo = new Tododto();
	        todo.setCurrentDate(currentDate);
	        todo.setTodoDesc(todoDesc);
	        todo.setTargetDate(targetDate);
	        todo.setTodoStatus(todoStatus);
	        
	        int result = Tododao.insertTodo(todo);  
	        
	        if (result > 0) {
	            System.out.println("Insertion successful");
	        } else {
	            System.out.println("Insertion failed");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		doGet(request, response);
		
	}

}
