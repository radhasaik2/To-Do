TO-DO-LIST 

To-Do-List  Task With JavaScript:
step(1): write a simple html code and required tags/elements as per requriements.
here in this task the elements used are:
@input 
@button
@table
@script
script: to specify and implement javascript requirements accordingly

step(2): the required items to be added in current task are:
#todoID
#todoitem
#todotarget date&time
#todostatus
step(2.1): creating an event to perform action based on that event to retrieve the data/list given by user:
 on click() : this eventhandler is to handle and creating a dynamic web-application and it gets executed when user clicks on specified html element.
 "<button onclick="addNewTodo()">SUBMIT</button>"

step(3): implementing JS functions:
!define a function and use DOM to create new element and to append{ it creates nodes of element content to add it to DOM } it. 
( 
to access the value of object defined in array '.value' is given with DOM to access the value/content of that html element
to get the value of html element '.innertext' is given with object
)
**
var newTodoStatusTd = document.createElement("td");
newTodoStatusTd.innerText = "Pending";
newTodoTr.appendChild(newTodoStatusTd);
**

