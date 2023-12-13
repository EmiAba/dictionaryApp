package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.annotation.DateInPastAndFuture;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.LanguageEnum;
import com.dictionaryapp.model.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class WordAddBindingModel {

    private Long id;
    private User user;

    @Size(min = 2, max = 40, message="The term length must be between 2 and 40 characters!")
    private String term;


    @Size(min = 2, max = 80, message="The term length must be between 2 and 80 characters!")
    private String translation;

    @Size(min = 2, max = 200, message="The example length must be between 2 and 200 characters!")
        private String example;
    @NotNull(message = "You must select a date!")
    @DateInPastAndFuture(message =  "The input date must be in the past or present!")
    private String inputDate;

    @NotNull(message = "You must select a language!")
    private LanguageEnum language;

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

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }


    public LanguageEnum getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEnum language) {
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
