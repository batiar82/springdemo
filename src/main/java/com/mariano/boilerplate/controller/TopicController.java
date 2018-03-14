package com.mariano.boilerplate.controller;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mariano.boilerplate.model.Topic;
import com.mariano.boilerplate.model.DTO.TopicDTO;
import com.mariano.boilerplate.service.impl.TopicService;

//@RestController
public class TopicController {
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(
		value="/api/topics",
		method=RequestMethod.GET,
		produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Topic>> getTopics(){
		List<Topic> topics= topicService.getTopics(1);	
		return new ResponseEntity<List<Topic>>(topics,HttpStatus.OK);
	}
	@RequestMapping(
		value="api/topics/{id}", method=RequestMethod.GET)
	public Topic getTopic(@PathVariable Integer id) {
		System.out.println("rECIBI "+id);
		
		return topicService.findById(id);
	}
	@RequestMapping(value="/api/topics",
			method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Topic> addTopic(@RequestBody Topic topic){
		Topic newTopic=topicService.save(topic);
		return new ResponseEntity<Topic>(newTopic,HttpStatus.CREATED);
	}
	@RequestMapping(value="/api/topics/{id}",
			method=RequestMethod.PUT,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Topic> updateTopic(@PathVariable Integer id,@RequestBody TopicDTO topic){
		try {
			Topic newTopic=topicService.update(id,topic);
			return new ResponseEntity<Topic>(newTopic,HttpStatus.OK);
		}catch(EntityNotFoundException e) {
			return new ResponseEntity<Topic>(HttpStatus.NOT_FOUND);
		}
		
	}
	@RequestMapping(value="/api/topics/{id}",
			method=RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Topic> deleteTopic(@PathVariable Integer id){
		try {
			Topic result=topicService.delete(id);
			return new ResponseEntity<Topic>(result,HttpStatus.OK);
		}catch(EntityNotFoundException e) {
			return new ResponseEntity<Topic>(HttpStatus.NOT_FOUND);
		}
		
	}
}
