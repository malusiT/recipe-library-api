package com.malusi.RecipeLibrary;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class RecipeNotFoundAdvice {

  @ExceptionHandler(RecipeNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String recipeNotFoundHandler(RecipeNotFoundException ex) {
    return ex.getMessage();
  }
}
