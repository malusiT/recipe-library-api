package com.malusi.recipelibrary.recipe.assembler;

import com.malusi.recipelibrary.recipe.controller.RecipeController;
import com.malusi.recipelibrary.recipe.entity.Recipe;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class RecipeModelAssembler implements RepresentationModelAssembler<Recipe, EntityModel<Recipe>>{

  @Override
  public EntityModel<Recipe> toModel(Recipe recipe){
    return EntityModel.of(recipe,
          linkTo(methodOn(RecipeController.class).one(recipe.getId())).withSelfRel(),
          linkTo(methodOn(RecipeController.class).all()).withRel("recipes"));
  }

}
