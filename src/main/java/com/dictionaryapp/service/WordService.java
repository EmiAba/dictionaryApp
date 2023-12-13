package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.*;

import java.util.Set;

public interface WordService {
    void add(WordAddBindingModel wordAddBindingModel);

    void removeSong(Long id);

    default void removeAll() {

    }

    Set<GermanWordsDTO> getGermanWords();

    Set<SpanishWordsDTO> getSpanishWords();

    Set<FrenchWordsDTO> getFrenchWords();

    Set<ItalianWordsDTO> getItalianWords();
}
