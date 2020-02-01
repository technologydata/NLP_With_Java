package com.examples;

import opennlp.tools.stemmer.PorterStemmer;
import opennlp.tools.stemmer.snowball.SnowballStemmer;

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
     * @param allWords Words to Stem
     * @return list of words after stemming using Porter Stemming Algorithm
     */
    private List<String> porterStemming(List<String> allWords) {

        PorterStemmer porterStemmer = new PorterStemmer();

        //Process each word and stem it
        return allWords.stream()
                .map(porterStemmer::stem)
                .collect(Collectors.toList());
    }

    /**
     * This method use the SnowBall Algorithm to perform stemming
     *
     * @param allWords Words to Stem
     * @return list of words after stemming using Snowball Algorithm
     */
    private List<String> snowBallStemming(List<String> allWords) {

        //Pass the Algorithm Instance for the appropriate Language.
        SnowballStemmer snowballStemmer = new SnowballStemmer(SnowballStemmer.ALGORITHM.ENGLISH);

        //Process each word and stem it
        return allWords.stream()
                .map(word -> snowballStemmer.stem(word).toString())
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

        System.out.println("---------------Porter Stemming---------------");
        //Call the porter stemming method to stem the words
        List<String> stemmingWithPorter = stemmingExample.porterStemming(allWords);
        //Print the result for porter stemming
        stemmingExample.showResult(allWords, stemmingWithPorter);

        System.out.println("---------------Snowball Stemming---------------");
        //Call the snowball stemming method to stem the words
        List<String> stemmingWithSnowball = stemmingExample.snowBallStemming(allWords);
        //Print the result for snowball stemming
        stemmingExample.showResult(allWords, stemmingWithSnowball);

        //stemmingExample.snowBallStemming(allWords);

    }

}


