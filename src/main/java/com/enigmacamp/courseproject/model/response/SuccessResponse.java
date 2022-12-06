package com.enigmacamp.courseproject.model.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class SuccessResponse<T> extends CommonResponse {

    T data;

    public SuccessResponse(String message, T data) {
        super.setCode("00");
        super.setMessage(message);
        super.setStatus(HttpStatus.OK.name());
        this.data = data;
    }

}
