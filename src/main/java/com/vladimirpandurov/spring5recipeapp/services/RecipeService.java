package com.vladimirpandurov.spring5recipeapp.services;

import com.vladimirpandurov.spring5recipeapp.commands.RecipeCommand;
import com.vladimirpandurov.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
