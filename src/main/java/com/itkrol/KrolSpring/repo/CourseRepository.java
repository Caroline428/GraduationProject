package com.itkrol.KrolSpring.repo;

import com.itkrol.KrolSpring.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
