package com.enigmacamp.courseproject.exception;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Data
public class FileExtensionNotSupportedException extends RuntimeException {

    private final String code = "X02";
    private final String status = "FAILED";

    public FileExtensionNotSupportedException() {
        super("File extension is not supported");
    }

    public FileExtensionNotSupportedException(String message) {
        super(message);
    }
}
