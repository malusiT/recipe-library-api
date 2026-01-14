package com.malusi.RecipeLibrary;

import java.util.Arrays;
import java.util.Objects;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
class Recipe {

  private @Id @GeneratedValue Long id;
  private String name;
  private String description;
  private String[] recipeList;
  private String[] instructions;

  Recipe() {
  }

  Recipe(String name, String description, String[] recipeList, String[] instructions) {
    this.name = name;
    this.description = description;
    this.recipeList = recipeList;
    this.instructions = instructions;

  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public String[] getRecipeList() {
    return this.recipeList;
  }

  public String[] getInstructions() {
    return this.instructions;
  }

  public void setName(String name){
    this.name = name;
  }
  
  public void setDescription(String description){
    this.description = description;
  }

  public void setRecipeList(String[] recipeList){
    this.recipeList = recipeList;
  }
  
  public void setInstructions(String[] instructions){
    this.instructions = instructions;
  }


  @Override
  public boolean equals(Object o){
    
    if(this == o){
      return true;
    }
    if(!(o instanceof Recipe))
      return false;
    Recipe recipe = (Recipe) o;
    return Objects.equals(this.id, recipe.id) && Objects.equals(this.name, recipe.name) && Objects.equals(this.recipeList, recipe.recipeList) && Objects.equals(this.instructions, recipe.instructions);
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "Recipe{id=" + id + ", name=" + name + ", description=" + description + ", recipeList=" +Arrays.toString(recipeList) + ", instructions=" + Arrays.toString(instructions) + "}";
  }

  @Override
  public int hashCode(){
    return Objects.hash(this.id, this.name, this.description, this.recipeList, this.instructions);
  }

}
