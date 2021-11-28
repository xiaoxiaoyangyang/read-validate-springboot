package com.example.hellowrold.entity.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultInfo {
    private Integer statusCode;
    private String message;
    private String body;
}
