package com.malusi.recipelibrary.recipe.exception;

public class RecipeNotFoundException extends RuntimeException{

  public RecipeNotFoundException(Long id){
    super("Could not find recipe " + id);
  }
}
