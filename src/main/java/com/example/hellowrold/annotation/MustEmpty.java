package com.example.hellowrold.annotation;

import com.example.hellowrold.validator.MustEmptyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy=MustEmptyValidator.class)
@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MustEmpty {
    String message() default "属性必须为空";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
