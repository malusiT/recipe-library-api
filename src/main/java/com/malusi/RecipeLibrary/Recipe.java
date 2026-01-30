package com.malusi.RecipeLibrary;

import java.util.List;
import java.util.Arrays;
import java.util.Objects;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.ElementCollection;

@Entity
class Recipe {

  private @Id @GeneratedValue Long id;

  @NotBlank(message = "Name is mandatory")
  @NotEmpty(message =  "Name may not be empty")
  private String name;

  @NotBlank(message = "Description is mandatory")
  @NotEmpty(message = "Description may not be empty")
  private String description;

  @ElementCollection
  @NotNull(message = "Ingredients may not be null")
  private List<String> ingredients;

  @ElementCollection
  @NotNull(message = "Instructions may not be null")
  private List<String> instructions;

  Recipe() {
  }

  Recipe(String name, String description, List<String> ingredients, List<String> instructions) {
    this.name = name;
    this.description = description;
    this.ingredients = ingredients;
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
    return this.ingredients;
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

  public void setRecipeList(List<String> ingredients){
    this.ingredients = ingredients;
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
    return Objects.equals(this.id, recipe.id) && Objects.equals(this.name, recipe.name) && Objects.equals(this.ingredients, recipe.ingredients) && Objects.equals(this.instructions, recipe.instructions);
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "Recipe{id=" + id + ", name=" + name + ", description=" + description + ", ingredients=" + ingredients.toString() + ", instructions=" + instructions.toString() + "}";
  }

  @Override
  public int hashCode(){
    return Objects.hash(this.id, this.name, this.description, this.ingredients, this.instructions);
  }

}
