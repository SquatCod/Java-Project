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

        while (Mistake_counter < 6) {

            System.out.println("Enter a character to save the hangman!\n" + Art[Mistake_counter] + "\n" + RandomWord.replaceAll("[a-zA-Z]", "_"));
            String input = new Scanner(System.in).next();

            boolean checker = false;

            for (char letter : RandomWord.toCharArray()) {
                if (input.matches(String.valueOf(letter))) {
                    System.out.println("correct");
                    checker = true;
                }
            }
            if (!checker){
                Mistake_counter += 1;
                System.out.println("Incorrect letter");
            }
            if (Mistake_counter > 5) {
                System.out.println("you have lost, the poor hangman :(");
            }
        }
    }
}