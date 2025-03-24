package com.groupe.Worktopia;

import lombok.Data;

import java.time.LocalDate;
@Data

public class ApiError {

    private String message;
    private int code;
    private LocalDate timestamp;
}
