package com.enigmacamp.courseproject.exception;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Getter
public class NotFoundException extends RuntimeException {

    private final String code = "X01";
    private final String status = "FAILED";

    public NotFoundException() {
        super("Data not found");
    }

    public NotFoundException(String message) {
        super(message);
    }

}
