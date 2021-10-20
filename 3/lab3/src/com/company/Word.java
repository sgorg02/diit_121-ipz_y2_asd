package com.company;

public class Word {
    public String data;
    public String idata;

    public Word(String word, String word_RU) {
        this.data = word;
        this.idata = word_RU;
    }

    @Override
    public String toString() {
        return data + " - " + idata;
    }
}