package com.test.moj;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 

@Path("/todo")
public class ToDoResource {
 
	private static List<ToDo> todoList =new ArrayList<ToDo>();
	private static int todoCount=0;
	
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON}) 
	public Response getToDos() {
		return Response.status(200).entity(getAllToDos()).build();
 	}
	
	@PUT
	@Path("/{title}")
	@Consumes({MediaType.APPLICATION_JSON}) 
	public Response saveToDos(@PathParam("title")String  title) {
		saveToDo(new ToDo(todoCount++,title,"Pending"));
		return Response.status(200).build();
 	}
	

	/**	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON}) 
	public Response getToDo(@PathParam("id")int  id) {
		
		Optional<ToDo> todo=getAllToDos().stream().filter(x -> x.getId() == id).findFirst();
		return Response.status(200).entity(todo.get()).build();
 	}
	

	@DELETE
	@Path("/delete/{id}")
	@Produces({MediaType.APPLICATION_JSON}) 
	public Response deleteToDo(@PathParam("id")int  id) {
		Optional<ToDo> todo=getAllToDos().stream().filter(x -> x.getId() == id).findFirst();
		todoList.remove(todo);
		return Response.status(200).build();
 	}
	**/
	private void saveToDo(ToDo todo){
		todoList.add(todo);
	}

	private List<ToDo> getAllToDos(){
		return todoList;
	}
	
}
