package com.enigmacamp.courseproject.model.response;

import lombok.Data;

@Data
public class ErrorResponse extends CommonResponse {

    public ErrorResponse(String code, String status, String message) {
        super.setCode(code);
        super.setStatus(status);
        super.setMessage(message);
    }

}
