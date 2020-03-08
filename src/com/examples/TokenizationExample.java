package com.examples;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * This class is an example of how to do Tokenization
 */
public class TokenizationExample {
    public static void main(String[] args) {

        //We will break the following sentence into a set of tokens
        String sentence = "Coronaviruses are zoonotic, meaning they are transmitted between animals and people. Are you okay ?  ";

        //Load the tokenize model from res folder
        TokenizerModel model = null;
        try (InputStream modelIn = new FileInputStream("res/en-token.bin")) {
            //Initialize the Tokenizer model
            model = new TokenizerModel(modelIn);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TokenizerME is used to break the sentence into tokens
        //ME stands for Maximum Entropy
        Tokenizer tokenDetector = new TokenizerME(Objects.requireNonNull(model));
        //Tokenize and get the tokens
        String[] tokens = tokenDetector.tokenize(sentence);

        //Display the tokensone by one
        for (String token : tokens) {
            System.out.println(token);

        }
    }
}
