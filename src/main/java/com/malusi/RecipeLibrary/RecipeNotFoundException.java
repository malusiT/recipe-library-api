package com.malusi.RecipeLibrary;

class RecipeNotFoundException extends RuntimeException{

  RecipeNotFoundException(Long id){
    super("Could not find recipe " + id);
  }
}
