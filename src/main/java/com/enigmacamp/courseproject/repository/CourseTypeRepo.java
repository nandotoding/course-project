package com.enigmacamp.courseproject.repository;

import com.enigmacamp.courseproject.model.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseTypeRepo extends JpaRepository<CourseType, String> {
}
