import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Algorithms {
    private static File f;
    private static Scanner s;
    public static void main(String[] args) throws FileNotFoundException {
        f = new File("words.txt");
        System.out.println("Two letter words: " + twoLetters());
        System.out.println("Amount of words tied for longest: " + longest());
        int palindromes = 0;
        s = new Scanner(f);
        while(s.hasNext()) {
            if(palindromes(s.next())) {
                palindromes++;
            }
        }
        System.out.println("Palindromes: " + palindromes);
        s.close();
    }

    public static int twoLetters() throws FileNotFoundException {
        s = new Scanner(f);
        int amount = 0;
        while(s.hasNext()) {
            if(s.next().length() == 2) {
                amount++;
            }
        }
        return amount;
    }

    public static int longest() throws FileNotFoundException {
        s = new Scanner(f);
        int longest = 0;
        int amount = 0;
        while(s.hasNext()) {
            String str = s.next();
            if(str.length() > longest) {
                longest = str.length();
            }
        }
        s.close();
        s = new Scanner(f);
        while(s.hasNext()) {
            if(s.next().length() == longest) {
                amount++;
            }
        }
        s.close();
        return amount;
    }

    public static boolean palindromes(String str) throws FileNotFoundException {
        boolean palindrome = false;
        for(int i = 0; i < (str.length() / 2); i++){
            if(str.charAt(i) == str.charAt(str.length() - i - 1)) {
                palindrome = true;
            }
            else {
                palindrome = false;
            }
        }
        return palindrome;
    }
}