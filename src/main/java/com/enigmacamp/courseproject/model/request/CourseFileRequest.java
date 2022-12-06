package com.enigmacamp.courseproject.model.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
public class CourseFileRequest {

    @NotNull(message = "file is required")
    private MultipartFile file;

}
