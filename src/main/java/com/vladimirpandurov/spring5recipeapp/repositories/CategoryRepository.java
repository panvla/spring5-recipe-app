package com.vladimirpandurov.spring5recipeapp.repositories;

import com.vladimirpandurov.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {


}
