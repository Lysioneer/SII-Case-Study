package com.sii.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class to throw when there is no suitable record in db.
 *
 * Created by Simek Jan on 21.9.2023.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {

    @Getter
    @Setter
    private String message;

    public RecordNotFoundException(String message) {
        this.message = message;
    }
}
