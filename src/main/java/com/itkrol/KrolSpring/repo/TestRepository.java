package com.itkrol.KrolSpring.repo;

import com.itkrol.KrolSpring.models.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Long> {
}
