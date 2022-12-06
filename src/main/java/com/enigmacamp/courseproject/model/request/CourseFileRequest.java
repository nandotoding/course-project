package com.enigmacamp.courseproject.model.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CourseFileRequest {

    @NotBlank
    private String title;

    private String description;

    @NotNull(message = "file is required")
    private MultipartFile file;

    @NotBlank
    private String duration;

    @NotBlank
    private String level;

    @NotBlank
    private String typeName;

}
