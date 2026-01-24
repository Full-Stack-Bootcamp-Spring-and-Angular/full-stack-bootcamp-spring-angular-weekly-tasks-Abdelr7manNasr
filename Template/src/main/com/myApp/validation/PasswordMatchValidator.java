package main.com.myApp.validation;

import main.com.myApp.model.UserModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator
        implements ConstraintValidator<PasswordMatch, UserModel> {

    @Override
    public boolean isValid(UserModel u, ConstraintValidatorContext c) {

        if (u == null) return true;

        if (u.getPassword() == null || u.getConfirmPassword() == null)
            return false;

        return u.getPassword().equals(u.getConfirmPassword());
    }
}
