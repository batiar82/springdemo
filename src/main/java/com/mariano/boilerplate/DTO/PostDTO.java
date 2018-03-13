package com.mariano.boilerplate.DTO;

public class PostDTO {
	private Integer id;
	private String title;
	private String topicName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public PostDTO(Integer id, String title, String topicName) {
		super();
		this.id = id;
		this.title = title;
		this.topicName = topicName;
	}
	public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
