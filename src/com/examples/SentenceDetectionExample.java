package com.examples;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * This class is an example of how to do sentence detection.
 */
public class SentenceDetectionExample {
    public static void main(String[] args) {

        //We will break the following paragraph into sentences
        String paragraph = "Coronaviruses are zoonotic, meaning they are transmitted between animals and people.  "
                + "Common signs of infection include respiratory symptoms, fever, cough, shortness of breath and breathing difficulties. " +
                "Are you facing any problems ? " +
                "Standard recommendations to prevent infection spread include regular hand washing, covering mouth and nose when coughing and sneezing, thoroughly cooking meat and eggs.";

        //Load the english language sentences model from res folder
        SentenceModel model = null;
        try (InputStream modelIn = new FileInputStream("res/en-sent.bin")) {
            //Initialize the sentence model
            model = new SentenceModel(modelIn);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //SentenceDetectorME is used to read the sentence with the help of model created above
        //ME stands for Maximum Entropy
        SentenceDetectorME sentenceDetector = new SentenceDetectorME(Objects.requireNonNull(model));
        //Read the sentences
        String[] sentences = sentenceDetector.sentDetect(paragraph);

        //Display the sentences
        for (String sentence : sentences) {
            System.out.println(sentence);

        }

        //Checking the probabilities of the last decoded sentence
        double[] probs = sentenceDetector.getSentenceProbabilities();

        System.out.println("  ");

        for (double prob : probs) System.out.println(prob);

    }
}
