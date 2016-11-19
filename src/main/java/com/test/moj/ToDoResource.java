package com.test.moj;
 
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 

@Path("/todo")
public class ToDoResource {
 
	private static List<ToDo> todoList =new ArrayList<ToDo>();
	private static int todoCount=1;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON}) 
	public Response getToDos() {
		return Response.status(200).entity(getAllToDos()).build();
 	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON}) 
	@Path("/{id}")
	public Response getToDo(@PathParam("id")int  id) {
		return Response.status(200).entity(getToDoById(id)).build();
 	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON}) 
	@Path("/{title}")
	public Response createToDo(@PathParam("title")String  title) {
		saveToDo(new ToDo(todoCount++,title,"Pending","Medium"));
		return Response.status(200).build();
 	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON}) 
	@Path("/{id}/{status}/{priority}")
	public Response saveToDos(@PathParam("id")int  id,@PathParam("status")String  status,@PathParam("priority")String  priority) {
		ToDo todo=getToDoById(id);
		todo.setStatus(status);
		todo.setPriority(priority);
		return Response.status(200).build();
 	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON}) 
	public Response deleteToDo(@PathParam("id")int  id) {
		todoList.remove(getToDoById(id));
		return Response.status(200).build();
 	}
	
	private void saveToDo(ToDo todo){
		todoList.add(todo);
	}

	private List<ToDo> getAllToDos(){
		return todoList;
	}
	
	private ToDo getToDoById(int id){
		ToDo result=null;
		List<ToDo> todos=getAllToDos();
		for (ToDo toDo : todos) {
			if(toDo.getId()==id){
				result= toDo;
			}
		}
		return result;
	}
}
