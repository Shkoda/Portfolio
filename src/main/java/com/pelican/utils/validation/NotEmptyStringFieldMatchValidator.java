package com.pelican.utils.validation;


import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Nightingale on 10.09.2014.
 */
public class NotEmptyStringFieldMatchValidator implements ConstraintValidator<NotEmptyStringFieldMatch, Object> {
    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final NotEmptyStringFieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        try {
            final String firstObj = BeanUtils.getProperty(value, firstFieldName);
            final String secondObj = BeanUtils.getProperty(value, secondFieldName);

            return firstObj != null && !firstObj.isEmpty() && firstObj.equals(secondObj);

        } catch (final Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
