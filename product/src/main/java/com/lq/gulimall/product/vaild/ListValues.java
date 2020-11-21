package com.lq.gulimall.product.vaild;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {ListaVlauesConstraintValidator.class}
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ListValues {

    String message() default "{com.lq.common.vaild.ListValue.message}";

    Class<?>[] groups() default {};
    int[]values()default {};

    Class<? extends Payload>[] payload() default {};

}
