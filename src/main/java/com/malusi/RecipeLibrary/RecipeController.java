package com.malusi.RecipeLibrary;

import java.util.stream.Collectors;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.util.Map;

@RestController

class RecipeController {
  private final RecipeRepository repository;

  private final RecipeModelAssembler assembler;

  RecipeController(RecipeRepository repository, RecipeModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }

  @GetMapping("/")
  public Map<String, String> info(){
    return Map.of(
          "name", "Recipe Library API",
          "version", "1.0",
          "docs", "swagger-ui/index.html"
        );
  }

  // Aggregate repository
  // tag::get-aggregate-root[]

  @GetMapping("/recipes")
  CollectionModel<EntityModel<Recipe>> all() {

    List<EntityModel<Recipe>> recipes = repository.findAll().stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());
    return CollectionModel.of(recipes, linkTo(methodOn(RecipeController.class).all()).withSelfRel());
  }
  // end::get-aggregate-root[]

  @PostMapping("/recipes")
  ResponseEntity<?> newRecipe(@RequestBody Recipe newRecipe) {
    EntityModel<Recipe> entityModel = assembler.toModel(repository.save(newRecipe));

    return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
  }

  // Single item

  @GetMapping("/recipes/{id}")
  EntityModel<Recipe> one(@PathVariable Long id) {
    Recipe recipe = repository.findById(id)
        .orElseThrow(() -> new RecipeNotFoundException(id));

    return assembler.toModel(recipe);
  }

  @PutMapping("recipes/{id}")
  ResponseEntity<?> replaceRecipe(@RequestBody Recipe newRecipe, @PathVariable Long id) {

    Recipe updatedRecipe = repository.findById(id)
        .map(recipe -> {
          recipe.setName(newRecipe.getName());
          recipe.setDescription(newRecipe.getDescription());
          recipe.setRecipeList(newRecipe.getRecipeList());
          recipe.setInstructions(newRecipe.getInstructions());
          return repository.save(recipe);
        })
        .orElseGet(() -> {
          return repository.save(newRecipe);
        });

    EntityModel<Recipe> entityModel = assembler.toModel(updatedRecipe);

    return ResponseEntity
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);

  }

  @DeleteMapping("recipes/{id}")
  void deleteRecipe(@PathVariable Long id) {
    repository.deleteById(id);
  }

}
