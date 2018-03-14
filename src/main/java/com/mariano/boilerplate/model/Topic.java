package com.mariano.boilerplate.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="topic")
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition="int(11)")
	private Integer id;
	@Column(name="name", nullable=false)
	private String name;
	@OneToMany(mappedBy="topic")
	//@JsonIgnore
	private Set<Post> posts;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	
	
}
