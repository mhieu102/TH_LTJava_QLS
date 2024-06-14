package com.example.TH_LTJava_QLS.Validator;


import com.example.TH_LTJava_QLS.Model.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<com.example.TH_LTJava_QLS.Validator.annotation.ValidCategoryId, Category> {
    public boolean isValid(Category category, ConstraintValidatorContext context){
        return category != null && category.getId() != null;
    }

}