package com.enigmacamp.courseproject.repository;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface CourseFileRepo {

    void store(MultipartFile file);
    Resource load(String filename);

}
