package com.enigmacamp.courseproject.repository;

import com.enigmacamp.courseproject.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, String>, JpaSpecificationExecutor<Course> {

    @Query(
            value = "select * from course",
            countQuery = "select count(*) from course",
            nativeQuery = true
    )
    Page<Course> findAllPaging(Pageable pageable);

}
