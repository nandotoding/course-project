package com.enigmacamp.courseproject.service;

import com.enigmacamp.courseproject.model.Course;
import com.enigmacamp.courseproject.model.request.CourseRequest;

public interface CourseService {
    Course create(CourseRequest courseRequest);
}
