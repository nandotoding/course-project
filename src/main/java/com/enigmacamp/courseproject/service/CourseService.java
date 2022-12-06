package com.enigmacamp.courseproject.service;

import com.enigmacamp.courseproject.model.Course;
import com.enigmacamp.courseproject.model.request.CourseFileRequest;
import org.springframework.web.multipart.MultipartFile;

public interface CourseService {

    void uploadMaterial(MultipartFile multipartFile);
    Course create(CourseFileRequest courseFileRequest);

}
