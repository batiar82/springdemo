package com.mariano.boilerplate.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mariano.boilerplate.DTO.PostDTO;
import com.mariano.boilerplate.model.Post;
import com.mariano.boilerplate.model.Topic;
import com.mariano.boilerplate.model.DTO.TopicDTO;

@Service
public class TopicService {
    
    @PersistenceContext
    private EntityManager entityManager;

    private int pageSize = 25;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicService.class);
    
    
    @Transactional
    public void updateTopic(Integer topicId, TopicDTO updated) {
    	Topic topic = entityManager.find(Topic.class, topicId);
        if (topic != null) {
        	//LOGGER.debug("Antes de update");
             topic.setName(updated.getName());
             //LOGGER.debug("Despues de update");
        } else {
             throw new EntityNotFoundException();
        }
        LOGGER.debug("Saliendo");
        //System.out.println("Hizo update");
    }
    
    public List<PostDTO> listPostTitlesAndTopics(int pageNumber) {
        List<Post> posts = entityManager.createQuery("SELECT p FROM Post p JOIN FETCH p.topic")//")// JOIN Topic t ON p.id = t.posts.id ")
            .setFirstResult((pageNumber - 1) * pageSize)
            .setMaxResults(pageSize)
 .getResultList();
        List<PostDTO> result = new ArrayList<PostDTO>(posts.size());
        System.out.println("Se hizo el query");
        for(Post post : posts) {
            PostDTO postDto = new PostDTO();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setTopicName(post.getTopic().getName());
            System.out.println("Agrego uno");
            result.add(postDto);
        }

        return result;
    }
    public List<PostDTO> listPostTitlesAndTopicsNew(int pageNumber) {
        List<Post> posts = entityManager.createQuery("SELECT p FROM Post p JOIN FETCH p.topic")//")// JOIN Topic t ON p.id = t.posts.id ")
            .setFirstResult((pageNumber - 1) * pageSize)
            .setMaxResults(pageSize)
 .getResultList();
        
        
        
        List<PostDTO> result = new ArrayList<PostDTO>(posts.size());
        posts.forEach(p -> result.add(new PostDTO(p.getId(),p.getTitle(),p.getTopic().getName())));
        return result;
    }
    public List<Topic> getTopics(int pageNumber) {
        List<Topic> topics = entityManager.createQuery("SELECT t FROM Topic t")//")// JOIN Topic t ON p.id = t.posts.id ")
            .setFirstResult((pageNumber - 1) * pageSize)
            .setMaxResults(pageSize)
 .getResultList();
        return topics;
    }

    
	public Topic findById(Integer id) {
		return entityManager.find(Topic.class, id);
	}
	@Transactional
	public Topic update(Integer id,TopicDTO topic) {
		Topic t=entityManager.find(Topic.class, id);
		if(t!=null) {
			t.setName(topic.getName());
			entityManager.persist(t);
		}
		else
			throw new EntityNotFoundException();
		return t;
	}
	@Transactional
	public Topic save(Topic topic) {
		entityManager.persist(topic);
		return topic;
	}

	public Topic delete(Integer id) {
		Topic t=entityManager.find(Topic.class, id);
		entityManager.remove(t);
		return null;
	}
}
