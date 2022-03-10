package com.vladimirpandurov.spring5recipeapp.converters;

import com.vladimirpandurov.spring5recipeapp.commands.NotesCommand;
import com.vladimirpandurov.spring5recipeapp.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {


    @Override
    public NotesCommand convert(Notes notes) {
        if(notes == null){
            return null;
        }

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(notes.getId());
        notesCommand.setRecipeNotes(notes.getRecipeNotes());
        return notesCommand;

    }
}
