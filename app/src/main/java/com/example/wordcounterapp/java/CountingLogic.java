package com.example.wordcounterapp.java;

public class CountingLogic {
    //static method belong to class itself, no need for instance to call this method
    //static method to count words
    public static int getCharsCount (String userPhrase){
        return userPhrase.length();
    }

    //static method to count words
    public static int getWordCount(String userPhrase) {
        if (userPhrase.trim().isEmpty()) {
            return 0;
        }
        //words separated by
        String[] words = userPhrase.split("[\\s,.]+");
        return words.length;
    }
}