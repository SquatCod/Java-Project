import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main implements ASCII_hangman {

    static int Mistake_counter = 0;

    private static String GetRandomWord(String path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        Random word = new Random();
        return lines.get(word.nextInt(lines.size()));

    }

        public static void main(String[] args) {

            String path = new File("").getAbsolutePath() + "/src/Hangman_words";
            String RandomWord = GetRandomWord(path);

            String encrypted = RandomWord.replaceAll("[a-zA-Z]", "_");
            System.out.println("Enter a character to save the hangman!\n");

            char[] wordCharacters = RandomWord.toCharArray();

            while (Mistake_counter < 6) {

                System.out.println(Art[Mistake_counter]);
                System.out.println(encrypted);
                String input = new Scanner(System.in).next();

                boolean checker = false;

                for (char letter : wordCharacters) {
                    if (input.matches(String.valueOf(letter))) {
                        System.out.println("correct");
                        checker = true;
                    }
                }
                if (!checker){
                    Mistake_counter += 1;
                    System.out.println("Incorrect letter");
                }
            }
            System.out.println(parts_6);
            System.out.println("you have lost, the poor hangman :(");
            System.exit(0);
        }
    }