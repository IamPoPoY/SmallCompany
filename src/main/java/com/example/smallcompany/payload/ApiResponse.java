package com.example.smallcompany.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ApiResponse {
    private String message;
    private boolean Success;
        private T data;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        Success = success;
    }

    public ApiResponse(boolean success, T data) {
        Success = success;
        this.data = data;
    }

    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    private class T {

    }
}