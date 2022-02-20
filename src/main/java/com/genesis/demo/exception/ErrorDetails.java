package com.genesis.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;

@AllArgsConstructor
@Builder
public class ErrorDetails {
    private Date errorDate;
    private String errorMessage;
    private String field;
}
