package com.enigmacamp.courseproject.controller;

import com.enigmacamp.courseproject.exception.NotFoundException;
import com.enigmacamp.courseproject.model.Course;
import com.enigmacamp.courseproject.model.request.CourseFileRequest;
import com.enigmacamp.courseproject.model.response.SuccessResponse;
import com.enigmacamp.courseproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity createCourse(@ModelAttribute @Valid CourseFileRequest courseFileRequest, BindingResult errors) {

        if (errors.hasErrors()) {
            throw new NotFoundException();
        }

        Course courseData = courseService.create(courseFileRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success", courseData));
    }
}
