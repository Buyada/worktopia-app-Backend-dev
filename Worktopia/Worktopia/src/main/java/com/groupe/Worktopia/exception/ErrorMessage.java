package com.groupe.Worktopia.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorMessage {
    private Integer statusCode;
    private LocalDateTime timestamp;
    private String message;
    private String error;
}
