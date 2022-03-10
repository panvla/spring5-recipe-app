package com.vladimirpandurov.spring5recipeapp.converters;

import com.vladimirpandurov.spring5recipeapp.commands.UnitOfMeasureCommand;
import com.vladimirpandurov.spring5recipeapp.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {


    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if(source != null){
            final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
            uomc.setId(source.getId());
            uomc.setDescription(source.getDescription());
            return uomc;
        }

        return null;
    }
}
