package com.enigmacamp.courseproject.controller;

import com.enigmacamp.courseproject.exception.NotFoundException;
import com.enigmacamp.courseproject.model.Course;
import com.enigmacamp.courseproject.model.request.CourseFileRequest;
import com.enigmacamp.courseproject.model.response.CommonResponse;
import com.enigmacamp.courseproject.model.response.PagingResponse;
import com.enigmacamp.courseproject.model.response.SuccessResponse;
import com.enigmacamp.courseproject.service.CourseService;
import com.enigmacamp.courseproject.util.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<CommonResponse> getAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "useNative", required = false) boolean useNative,
            @RequestBody(required = false) List<SearchCriteria> criteria
    ) {
        Pageable pageable;
        pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(direction), sortBy));

        if (useNative) {
            PagingResponse<Course> pagedCourses = courseService.getAllPaging(pageable);

            return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>(HttpStatus.OK.toString(), pagedCourses));
        }

        Page<Course> courses;

        if (criteria != null) {
            courses = courseService.getAll(criteria, pageable);
        } else {
            courses = courseService.getAll(pageable);
        }

        CommonResponse response;
        response = new SuccessResponse<>(HttpStatus.OK.toString(), new PagingResponse<>("Success",courses));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
