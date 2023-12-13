package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.*;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Service
public class WordServiceImpl implements WordService {
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private  final WordRepository wordRepository;

    public WordServiceImpl(LanguageRepository languageRepository, UserRepository userRepository, WordRepository wordRepository) {
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.wordRepository = wordRepository;
    }


    @Override
    public void add(WordAddBindingModel wordAddBindingModel) {
        Language language = languageRepository.findByName(wordAddBindingModel.getLanguage());

        if (language != null) {
            Word word = new Word();

            word.setTerm(wordAddBindingModel.getTerm());
            word.setTranslation(wordAddBindingModel.getTranslation());
            word.setExample(wordAddBindingModel.getExample());
            word.setLanguages(language);
            word.setInputDate((LocalDate.parse(wordAddBindingModel.getInputDate())));
            Optional<User> user = this.userRepository.findById(wordAddBindingModel.getUser().getId());
            word.setAddedBy(user.get());

            System.out.println();

           wordRepository.save(word);


        }
    }

    public Set<GermanWordsDTO> getGermanWords() {
        return this.wordRepository.findGermanWords();
    }

    public Set<SpanishWordsDTO> getSpanishWords() {
        return this.wordRepository.findSpanishWords();
    }

    public Set<FrenchWordsDTO> getFrenchWords() {
        return this.wordRepository.findFrenchWords();
    }

    public Set<ItalianWordsDTO> getItalianWords() {
        return this.wordRepository.findItalianWords();
    }

    @Override
    public void removeSong(Long id) {
        this.wordRepository.deleteById(id);

    }

    @Override
    public void removeAll() {
        this.wordRepository.deleteAll();
    }
}