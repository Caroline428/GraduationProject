package com.itkrol.KrolSpring.repo;

import com.itkrol.KrolSpring.models.Post;
import org.springframework.data.repository.CrudRepository;
public interface PostRepository extends CrudRepository<Post, Long> {

}
