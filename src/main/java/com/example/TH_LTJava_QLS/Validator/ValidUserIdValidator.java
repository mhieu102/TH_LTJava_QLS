package com.example.TH_LTJava_QLS.Validator;



import com.example.TH_LTJava_QLS.Model.User;
import com.example.TH_LTJava_QLS.Validator.annotation.ValidUserId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context){
        if (user == null)
            return true;
        return user.getId() !=null;
    }
}