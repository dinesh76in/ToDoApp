package com.test.moj;

public class ToDo {

	private int id;
	private String title;
	private String status ;
	private String priority ;

	public ToDo(int id, String title, String status,String priority) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.priority = priority;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

}
