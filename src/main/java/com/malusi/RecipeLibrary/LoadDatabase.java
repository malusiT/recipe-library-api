package com.malusi.RecipeLibrary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;
import java.util.List;

@Configuration
class LoadDatabase{

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(RecipeRepository repository){

    // String[] recipes =  {"Pizza dough (store-bought or homemade)", "1/2 cup San Marzano tomato sauce", "4 oz fresh mozzarella cheese, sliced", "6-8 fresh basil leaves", "1 tbsp extra virgin olive oil", "Salt to taste"};
    // String[] instructions = {"Preheat your oven to 500°F (260°C) with a pizza stone inside.", "Roll out the dough on a floured surface until thin.", "Spread the tomato sauce evenly, leaving a small border for the crust.", "Arrange mozzarella slices on top of the sauce.", "Bake for 8–10 minutes until the crust is golden and cheese is bubbling.", "Remove from oven, top with fresh basil, drizzle with olive oil, and serve."};
    //
    return args -> {
      // log.info("Preloading " + repository.save(new Recipe("Classic Margherita Pizza", "A timeless Italian favorite featuring a thin, crispy crust topped with vibrant tomato sauce, fresh mozzarella, and aromatic basil.", recipes,instructions)));

      if(repository.count() == 0){ //Load if database if empty
        List<String> ingredients = Arrays.asList(
            "Pizza dough (store-bought or homemade)", "1/2 cup San Marzano tomato sauce", "4 oz fresh mozzarella cheese, sliced", "6-8 fresh basil leaves", "1 tbsp extra virgin olive oil", "Salt to taste"
            );
        List<String> instructions = Arrays.asList("Preheat your oven to 500°F (260°C) with a pizza stone inside.",
              "Roll out the dough on a floured surface until thin.",
              "Spread the tomato sauce evenly, leaving a small border for the crust.",
              "Arrange mozzarella slices on top of the sauce.",
              "Bake for 8–10 minutes until the crust is golden and cheese is bubbling.",
              "Remove from oven, top with fresh basil, drizzle with olive oil, and serve.");

        repository.save(new Recipe(
              "Classic Margherita Pizza",
              "A timeless Italian favorite featuring a thin, crispy crust topped with vibrant tomato sauce, fresh mozzarella, and aromatic basil.",
              ingredients,
              instructions
              ));
        log.info("Database initialised with sample recipes.");
      // log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
      }else{
        log.info("Database already contains data, skipping preloading");
      }
    };
  }

  // {"name": Juice", "description": "flavoured juice", "ingredients": {"water", "concentrated juice"}, "instructions": {"pour water in a cup to quarter full", "pour one tablespoon of concentrated juice", "stir for a minute"}

}
