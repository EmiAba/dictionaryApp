package com.dictionaryapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "words")
public class Word extends BaseEntity {
    @Column(nullable = false)
    @Size(min = 2, max = 40)
    private String term;

    @Column(nullable = false)
    @Size(min = 2, max = 80)
    private String translation;
    @Column(nullable = false)
    @Size(min = 2, max = 200)
    private String example;
    @ManyToOne
    @NotNull
    private Language languages;
    @ManyToOne
    private User addedBy;


    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Language getLanguages() {
        return languages;
    }

    public void setLanguages(Language languages) {
        this.languages = languages;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }
}
