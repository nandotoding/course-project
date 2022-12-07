package com.enigmacamp.courseproject.service;

import com.enigmacamp.courseproject.model.Course;
import com.enigmacamp.courseproject.model.request.CourseFileRequest;
import com.enigmacamp.courseproject.model.response.PagingResponse;
import com.enigmacamp.courseproject.util.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CourseService {

    void uploadMaterial(MultipartFile multipartFile);
    Course create(CourseFileRequest courseFileRequest);
    PagingResponse<Course> getAllPaging(Pageable pageable);
    Page<Course> getAll(Pageable pageable);
    Page<Course> getAll(List<SearchCriteria> searchCriteria, Pageable pageable);

}
