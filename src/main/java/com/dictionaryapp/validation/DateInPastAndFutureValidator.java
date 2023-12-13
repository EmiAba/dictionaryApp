package com.dictionaryapp.validation;

import com.dictionaryapp.model.annotation.DateInPastAndFuture;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;
import java.time.LocalDate;

public class DateInPastAndFutureValidator implements ConstraintValidator<DateInPastAndFuture, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null && !value.isBlank()) {
            LocalDate parse = LocalDate.parse(value);
            return parse.isAfter(LocalDate.now());
        }

        return false;
    }

    @Override
    public void initialize(DateInPastAndFuture constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}