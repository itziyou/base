package com.cpiaoju.base.common.validator;

import cn.hutool.core.util.StrUtil;
import com.cpiaoju.base.common.annotation.IsMobile;
import com.cpiaoju.base.common.entity.RegexpConstant;
import com.cpiaoju.base.common.util.BaseUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author ziyou
 */
public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    @Override
    public void initialize(IsMobile isMobile) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            if (StrUtil.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return BaseUtil.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}