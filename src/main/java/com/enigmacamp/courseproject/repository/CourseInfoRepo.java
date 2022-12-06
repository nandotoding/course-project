package com.enigmacamp.courseproject.repository;

import com.enigmacamp.courseproject.model.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseInfoRepo extends JpaRepository<CourseInfo, String> {
}
