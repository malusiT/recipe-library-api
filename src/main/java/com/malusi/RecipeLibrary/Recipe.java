package com.malusi.RecipeLibrary;

import java.util.List;
import java.util.Arrays;
import java.util.Objects;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ElementCollection;


// Validation imports
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

// Timestamp imports
import java.time.Instant;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


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

  @NotNull(message = "Duration may not be null")
  private int duration;

  // Set when entity is created (stored as UTC instant in the database)
  @CreationTimestamp
  // @Column(name="createdAt", nullable = false, updatable = false)
  private Instant createdAt;

  @UpdateTimestamp
  // @Column(name = "updatedAt", nullable = false)
  private Instant updatedAt;


  Recipe() {
  }

  Recipe(String name, String description, List<String> ingredients, List<String> instructions) {
    this.name = name;
    this.description = description;
    this.ingredients = ingredients;
    this.instructions = instructions;

    // For date creation
    Instant now = Instant.now();
    this.createdAt = now;
    this.updatedAt = now;
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

  public List<String> getIngredients() {
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

  public Instant getCreatedAt(){
    return createdAt;
  }

  public Instant getUpdatedAt(){
    return updatedAt;
  }

  public void setUpdatedAt(Instant now){
    this.updatedAt = now;
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
    return "Recipe{id=" + id + ", name=" + name + ", description=" + description + ", ingredients=" + ingredients.toString() + ", instructions=" + instructions.toString() + ", createdAt="+ createdAt + " , updatedAt="+ updatedAt + "}";
  }

  @Override
  public int hashCode(){
    return Objects.hash(this.id, this.name, this.description, this.ingredients, this.instructions);
  }

}
