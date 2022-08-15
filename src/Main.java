import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main implements ASCII_hangman {

    static int Mistake_counter = 0;

        public static void main(String[] args) {
        hangman();
        }

        private static void hangman(){
            String path = new File("").getAbsolutePath() + "/src/Hangman_words";
            String RandomWord = GetRandomWord(path);
            List<String> wordCharacters = List.of(RandomWord.split(""));

            for (String Word : wordCharacters){
                RandomWord.split("[a-zA-Z]" );
            }

            List<String> encrypted = new ArrayList<>();
            for (String letter : wordCharacters ){
                encrypted.add("_");
            }

            System.out.println("Enter a character to save the hangman!\n");


            while (Mistake_counter < 6) {

                System.out.println(Art[Mistake_counter]);
                System.out.println(encrypted);
                String input = new Scanner(System.in).next();

                boolean checker = false;

                for (String letter : wordCharacters) {
                    if (input.matches(letter)) {
                        System.out.println("correct");
                        checker = true;
                        encrypted.set(wordCharacters.indexOf(letter), letter);
                    }
                }
                if (!checker){
                    Mistake_counter += 1;
                    System.out.println("Incorrect letter");
                }
                if (encrypted.contains("_") == false){
                    System.out.println("you have saved the hangman, pray it wasent captial punishment for horrendous crimes.");
                    rematchFunc();
                }
            }
            System.out.println(parts_6);
            System.out.println("you have lost, the poor hangman :(");
            System.out.println("the word was " + RandomWord);
            rematchFunc();
        }
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
        private static void rematchFunc(){
            System.out.println("would you like to rematch? type yes/no");
            String rematch = "yes";
            String Rinput = new Scanner(System.in).next();
            if (Rinput.matches(rematch)){
                Mistake_counter = 0;
                hangman();
            }else {
                System.exit(0);}
        };
    }