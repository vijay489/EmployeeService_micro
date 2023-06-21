package org.example.Exception;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExceptionResponse {
    private LocalDate dateTime;
    private String message;
}
