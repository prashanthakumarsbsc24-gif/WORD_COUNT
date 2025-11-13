import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounterSimple {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===== WORD COUNTER =====");
        System.out.print("Enter the full path of the text file: ");
        String filePath = input.nextLine();

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println(" File not found! Please check the path and try again.");
            return;
        }

        int vowels = 0, consonants = 0, lines = 0, words = 0, digits = 0, special = 0;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lines++;

                for (int i = 0; i < line.length(); i++) {
                    char ch = Character.toLowerCase(line.charAt(i));

                    if (Character.isLetter(ch)) {
                        if ("aeiou".indexOf(ch) != -1)
                            vowels++;
                        else
                            consonants++;
                    } else if (Character.isDigit(ch)) {
                        digits++;
                    } else if (ch == ' ') {
                        words++;
                    } else {
                        special++;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }

        words = words + 1; // Adjust word count

        System.out.println("\n===== FILE ANALYSIS =====");
        System.out.println("Total Lines: " + lines);
        System.out.println("Total Words: " + words);
        System.out.println("Total Vowels: " + vowels);
        System.out.println("Total Consonants: " + consonants);
        System.out.println("Total Digits: " + digits);
        System.out.println("Total Special Characters: " + special);
    }
}

