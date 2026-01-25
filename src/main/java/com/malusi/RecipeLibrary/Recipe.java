package com.malusi.RecipeLibrary;

import java.util.List;
import java.util.Arrays;
import java.util.Objects;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.ElementCollection;

@Entity
class Recipe {

  private @Id @GeneratedValue Long id;
  private String name;
  private String description;

  @ElementCollection
  private List<String> recipeList;

  @ElementCollection
  private List<String> instructions;

  Recipe() {
  }

  Recipe(String name, String description, List<String> recipeList, List<String> instructions) {
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

  public List<String> getRecipeList() {
    return this.recipeList;
  }

  public List<String> getInstructions() {
    return this.instructions;
  }

  public void setName(String name){
    this.name = name;
  }
  
  public void setDescription(String description){
    this.description = description;
  }

  public void setRecipeList(List<String> recipeList){
    this.recipeList = recipeList;
  }
  
  public void setInstructions(List<String> instructions){
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
    return "Recipe{id=" + id + ", name=" + name + ", description=" + description + ", recipeList=" + recipeList.toString() + ", instructions=" + instructions.toString() + "}";
  }

  @Override
  public int hashCode(){
    return Objects.hash(this.id, this.name, this.description, this.recipeList, this.instructions);
  }

}
