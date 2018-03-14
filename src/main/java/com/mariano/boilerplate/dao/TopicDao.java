package com.mariano.boilerplate.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mariano.boilerplate.model.Topic;
@RepositoryRestResource
public interface TopicDao extends PagingAndSortingRepository<Topic, Integer> {

}
