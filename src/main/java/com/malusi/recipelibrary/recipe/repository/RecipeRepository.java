package com.malusi.recipelibrary.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.malusi.recipelibrary.recipe.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

}
