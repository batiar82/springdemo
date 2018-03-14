package com.mariano.boilerplate;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mariano.boilerplate.dao.PostDao;
import com.mariano.boilerplate.model.DTO.TopicDTO;
import com.mariano.boilerplate.service.impl.TopicService;


@Component
//@Transactional
public class UserTest implements CommandLineRunner {
	
	@Autowired
	private TopicService topicService;
	/*
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PostDao postDao;
	*/
	private static final Logger log = LoggerFactory.getLogger(UserTest.class);
	/*@Autowired
	private Logger log;*/
	@Override
	public void run(String... args) throws Exception {
		System.out.println("USER TEST");
		//log.info("LALALAL EN TESTUSER");
		//TopicDTO updated=new TopicDTO();
		//updated.setName("Nuevo de java");
		//topicService.updateTopic(1, updated);
		//updated.setName("Cambio de nuevo");
		//ßtopicService.updateTopic(1, updated);
		//topicService.listPostTitlesAndTopics(1);
		/*User user= new User();
		user.setName("Mariano");
		user.setRole("ADMIN");
		userDao.save(user);
		
		User userb= new User();
		userb.setName("Juan");
		userb.setRole("USER");
		userDao.save(userb);
		
		User userc= new User();
		userc.setName("Pedro nuevoo");
		userc.setRole("USER");
		userDao.save(userc);
		
		Post post = new Post();
		post.setText("LAlala lal al la dsksldk lkasd laskd ldk aldk");
		post.setCreatedAt(new Date());
		post.setAuthor(user);
		post.setLikes(2L);
		postDao.save(post);
		
		Post postb = new Post();
		postb.setText("bbf bfb fb fb fkj bflkjb flkbj ");
		postb.setCreatedAt(new Date());
		postb.setAuthor(user);
		postb.setLikes(50L);
		postDao.save(postb);
		
		Post postc = new Post();
		postc.setText("Post de Juan");
		postc.setCreatedAt(new Date());
		postc.setAuthor(userb);
		postc.setLikes(50L);
		postDao.save(postc);
		
		user.follow(userb);
		user.like(postc);
		user.follow(userc);
		
		userc.like(postc);
		userc.follow(user);
		
		userService.save(user);
		userService.save(userb);
		userService.save(userc);
*/
		
	}

}
