package org.ccnuiot.bigevent.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.ccnuiot.bigevent.anno.State;

public class StateValidation implements ConstraintValidator<State, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //提供校验规则
        if (s == null) {
            return false; // 如果值为null，直接返回false
        }

        return s.equals("已发布") || s.equals("草稿"); // 如果值是"已发布"或"草稿"，返回true
    }
}
