package com.enigmacamp.courseproject.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CourseTypeRequest {

    @NotNull(message = "Type name is required")
    private String typeName;

}
