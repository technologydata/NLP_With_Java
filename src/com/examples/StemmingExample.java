package com.examples;

import opennlp.tools.stemmer.PorterStemmer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is an Example of how to do Stemming .
 */
public class StemmingExample {


    /**
     * Method to implement Porter Stemming on a list of words
     *
     * @param allWords Words to stem
     * @return list of words after stemming
     */
    private List<String> porterStemming(List<String> allWords) {

        PorterStemmer porterStemmer = new PorterStemmer();

        //Process each word and stem it
        return allWords.stream()
                .map(porterStemmer::stem)
                .collect(Collectors.toList());
    }

    /**
     * This method prints the result after stemming
     *
     * @param allWords List of words before stemming
     * @param result   List of words after stemming
     */
    private void showResult(List<String> allWords, List<String> result) {
        for (int i = 0; i < allWords.size(); i++) {
            System.out.println("Original Word: " + allWords.get(i)
                    + ", Stemmed Word: " + result.get(i));
        }
    }

    public static void main(String[] args) {

        StemmingExample stemmingExample = new StemmingExample();
        String text = "If you eat apple then you will not feel hungry while playing " +
                "and you can play longer without hunger " +
                "You like to eat grapes He has eaten many grapes because he likes eating ";

        //Convert the text into list of words based on space
        List<String> allWords = Arrays.asList(text.split("\\s+"));

        //Call the porter stemming method to stem the words
        List<String> result = stemmingExample.porterStemming(allWords);

        //Print the result
        stemmingExample.showResult(allWords, result);

    }

}


