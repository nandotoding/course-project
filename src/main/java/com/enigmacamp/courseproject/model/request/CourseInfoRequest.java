package com.enigmacamp.courseproject.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CourseInfoRequest {

    @NotNull(message = "Duration is required")
    private String duration;

    @NotNull(message = "Level is required")
    private String level;

}
