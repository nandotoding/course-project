package com.enigmacamp.courseproject.model.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CourseRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Course file is required")
    private CourseFileRequest courseFileRequest;

    @NotNull(message = "Course type is required")
    private CourseTypeRequest courseType;

    @NotNull(message = "Course info is required")
    private CourseInfoRequest courseInfo;

}
