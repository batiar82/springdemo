package com.mariano.boilerplate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mariano.boilerplate.model.Post;

@Repository
public interface PostDao extends JpaRepository<Post,Long> {
	/*
	@Query(nativeQuery = true,value = "call get_feed(:userId)")   // call store procedure with arguments
    List<Post> getFeed(@Param("userId")Long userId);
    */
	/*
	@Procedure()
	public List<Post> getFeed(Long userId);
	*/
}
