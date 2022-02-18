package com.vladimirpandurov.spring5recipeapp.contorllers;

import com.vladimirpandurov.spring5recipeapp.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IndexControllerTest {
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    IndexController controller;


    @BeforeEach
    public void setUp() throws  Exception{
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeService);
    }

    @Test
    void getIndexPage() {
        String viewName = controller.getIndexPage(model);

        assertEquals("index", viewName);

        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"),anySet());
    }
}