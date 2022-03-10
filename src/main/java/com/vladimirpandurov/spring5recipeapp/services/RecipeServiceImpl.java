package com.vladimirpandurov.spring5recipeapp.services;

import com.vladimirpandurov.spring5recipeapp.commands.RecipeCommand;
import com.vladimirpandurov.spring5recipeapp.converters.RecipeCommandToRecipe;
import com.vladimirpandurov.spring5recipeapp.converters.RecipeToRecipeCommand;
import com.vladimirpandurov.spring5recipeapp.domain.Recipe;
import com.vladimirpandurov.spring5recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;



    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
    @Override
    public Recipe findById(Long l){
            Optional<Recipe> recipeOptional = recipeRepository.findById(l);
            if(!recipeOptional.isPresent()){
                throw new RuntimeException("Recipe Not Found");
            }

        return recipeOptional.get();
    }

    public RecipeCommand saveRecipeCommand(RecipeCommand command){
        Recipe datachedRecipe = recipeCommandToRecipe.convert(command);
        Recipe savedRecipe = recipeRepository.save(datachedRecipe);
        log.debug("Saved RecipeId: " + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

}
