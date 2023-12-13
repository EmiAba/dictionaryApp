package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="languages")
public class Language extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private  LanguageEnum name;

    private String description;


    @OneToMany(mappedBy = "languages")
    private Set<Word> words;

    public LanguageEnum getName() {
        return name;
    }

    public void setName(LanguageEnum name) {
        this.name = name;
        setDescription(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    private void setDescription(LanguageEnum name) {
        String description = "";

        switch (name) {
            case GERMAN -> description = "A West Germanic language, is spoken by over 90 million people worldwide. Known for its complex grammar and compound words, it's the official language of Germany and widely used in Europe.";
            case SPANISH -> description = "A Romance language, is spoken by over 460 million people worldwide. It boasts a rich history, diverse dialects, and is known for its melodious sound, making it a global cultural treasure.";
            case FRENCH-> description = "A Romance language spoken worldwide, known for its elegance and cultural richness. It's the official language of France and numerous nations, famed for its cuisine, art, and literature.";
            case ITALIAN -> description ="A Romance language spoken in Italy and parts of Switzerland, with rich cultural heritage. Known for its melodious sounds, it's a gateway to Italian art, cuisine, and history.";

        }

        this.description = description;
    }


    public Set<Word> getWords() {
        return words;
    }

    public void setWords(Set<Word> words) {
        this.words = words;
    }
}
