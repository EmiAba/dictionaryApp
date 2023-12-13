package com.dictionaryapp.model.annotation;

import com.dictionaryapp.validation.DateInPastAndFutureValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = DateInPastAndFutureValidator.class)
public @interface DateInPastAndFuture {

    String message() default "Date is not in future!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}