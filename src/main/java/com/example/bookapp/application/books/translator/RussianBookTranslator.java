package com.example.bookapp.application.books.translator;

import com.example.bookapp.domain.books.BookTranslator;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("fromEnglishToRussian")
public class RussianBookTranslator implements BookTranslator {
    @Override
    public String translate(String bookName) {
        Translate translate =  TranslateOptions.newBuilder()
                .setApiKey("AIzaSyDUnPhDjbihNW6jsogfExK5Iud1F2Pha5k")
                .build().getService();

        Translation translation = translate.translate(
                bookName,
                Translate.TranslateOption.sourceLanguage("en"),
                Translate.TranslateOption.targetLanguage("ru")
        );
        return translation.getTranslatedText();
    }
    //
}