package com.mariano.boilerplate.model;

import java.util.Comparator;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post {
	@Id
	@GeneratedValue
	@Column(columnDefinition="int(11)")
	private Integer id;
	@Column(name="text", columnDefinition="varchar(536)", nullable=false)
	private String text;
	@Column(name="title",columnDefinition="varchar(536)", nullable=false)
	private String title;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="topic_id", nullable=false, columnDefinition="int(11)")
	private Topic topic;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
		
	}
