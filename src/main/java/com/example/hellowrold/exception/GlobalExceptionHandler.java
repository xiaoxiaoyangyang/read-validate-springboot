package com.example.hellowrold.exception;

import com.example.hellowrold.entity.info.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler({ BindException.class,ConstraintViolationException.class })
    public ResultInfo validationErrorHandler(ConstraintViolationException exception) {
        // 获取BindingResult对象
//        BindingResult bindingResult = exception.getBindingResult();
        BindingResult bindingResult = null;
        // 获取bindingResul中的所有错误
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        String message = exception.getMessage();
        String localizedMessage = exception.getLocalizedMessage();

        return new ResultInfo(400, message, null);
    }
}
