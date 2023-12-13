package com.dictionaryapp.init;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.LanguageEnum;
import com.dictionaryapp.repo.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LanguageInit implements CommandLineRunner {

    private LanguageRepository languageRepository;

    public LanguageInit(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
      List<Language> languages=new ArrayList<>();
       boolean hasLanguages= languageRepository.count()>0;


       if(!hasLanguages){
           Arrays.stream(LanguageEnum.values())
                   .forEach(languageEnum -> {
                      Language language=new Language();

                      language.setName(languageEnum);
                       languages.add(language);
                   });
          languageRepository.saveAll(languages);
       }

    }
}
