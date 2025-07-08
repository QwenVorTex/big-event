package org.ccnuiot.bigevent.anno;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.ccnuiot.bigevent.validation.StateValidation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {StateValidation.class}
)
public @interface State {
    //提供校验失败时的提示信息
    String message() default "state must be '已发布' or '草稿'";

    //指定分组
    Class<?>[] groups() default {};

    //负载    获取到State注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
