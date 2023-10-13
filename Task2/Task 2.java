package oasis;

import java.util.Random;
import javax.swing.*;

public class GuessingGame {
    public static void main(String[] args) {
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int score = 0;
        
        JOptionPane.showMessageDialog(null, "Welcome to the Guess the Number Game!\nYou have " + maxAttempts + " attempts to guess the number between " + lowerBound + " and " + upperBound + ".");

        Random random = new Random();
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        
        for (int attempts = 1; attempts <= maxAttempts; attempts++) {
            String guessString = JOptionPane.showInputDialog("Attempt #" + attempts + ": Enter your guess between " + lowerBound + " and " + upperBound);
            
            if (guessString == null) {
                JOptionPane.showMessageDialog(null, "Game over. You chose to exit.");
                System.exit(0);
            }
            
            int userGuess = Integer.parseInt(guessString);
            
            if (userGuess < lowerBound || userGuess > upperBound) {
                JOptionPane.showMessageDialog(null, "Invalid guess. Please enter a number between " + lowerBound + " and " + upperBound + ".");
                attempts--;
                continue;
            }
            
            if (userGuess == randomNumber) {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number " + randomNumber + " in " + attempts + " attempts.");
                score = maxAttempts - attempts;
                break;
            } else if (userGuess < randomNumber) {
                JOptionPane.showMessageDialog(null, "Try a higher number.");
            } else {
                JOptionPane.showMessageDialog(null, "Try a lower number.");
            }
        }
        
        JOptionPane.showMessageDialog(null, "Game over. Your score: " + score);
    }
}
