package com.example.wordcounterapp;

import static com.example.wordcounterapp.java.CountingLogic.getCharsCount;
import static com.example.wordcounterapp.java.CountingLogic.getWordCount;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CountingLogicUnitTest {
    @Test
    public void zeroValue_getCharsCount() {

        String inputString = "";
        int actualValue = getCharsCount(inputString);
        int expectedValue = 0;

        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void zeroValue_getWordCount() {

        String inputString = "";
        int actualValue = getWordCount(inputString);
        int expectedValue = 0;

        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void normalValue_getCharsCount() {

        String inputString = "123";
        int actualValue = getCharsCount(inputString);
        int expectedValue = 3;

        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void normalValue_getWordCount() {

        String inputString = "Hello world";
        int actualValue = getWordCount(inputString);
        int expectedValue = 2;

        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void emptySpaces_getCharsCount() {

        String inputString = "    ";
        int actualValue = getCharsCount(inputString);
        int expectedValue = 4;

        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void emptySpaces_getWordCount() {

        String inputString = "     ";
        int actualValue = getWordCount(inputString);
        int expectedValue = 0;

        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void emptySpacesChars_getCharsCount() {

        String inputString = "123    234";
        int actualValue = getCharsCount(inputString);
        int expectedValue = 10;

        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void emptySpacesWords_getWordCount() {

        String inputString = "Hello   words";
        int actualValue = getWordCount(inputString);
        int expectedValue = 2;

        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void commasChars_getCharsCount() {

        String inputString = "123,2";
        int actualValue = getCharsCount(inputString);
        int expectedValue = 5;

        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void commasWord_getWordCount() {

        String inputString = "Helle,words";
        int actualValue = getWordCount(inputString);
        int expectedValue = 2;

        assertEquals(expectedValue, actualValue);
    }
}