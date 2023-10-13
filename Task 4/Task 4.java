package oasis;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class User {
    private String username;
    private String password;
    // Add more user profile information here

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter and setter methods for profile information

    public boolean authenticate(String enteredPassword) {
        return this.password.equals(enteredPassword);
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

class MCQQuestion {
    private String question;
    private String[] options;
    private int correctAnswer;

    public MCQQuestion(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int selectedOption) {
        return selectedOption == correctAnswer;
    }
}

public class onlinetest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username, password;
        
        // Simulated user registration
        System.out.println("Welcome to the Online Examination System!");
        System.out.print("Enter your username: ");
        username = scanner.nextLine();
        System.out.print("Enter your password: ");
        password = scanner.nextLine();
        User user = new User(username, password);

        // Simulated login
        System.out.print("Please enter your password to login: ");
        String enteredPassword = scanner.nextLine();
        if (user.authenticate(enteredPassword)) {
            System.out.println("Login successful!");

            // Simulated MCQs
            MCQQuestion[] questions = {
                new MCQQuestion("What is 2 + 2?", new String[]{"A. 3", "B. 4", "C. 5"}, 1),
                new MCQQuestion("What is the capital of France?", new String[]{"A. London", "B. Berlin", "C. Paris"}, 2),
                // Add more questions here
            };

            int score = 0;
            int timeLimitMinutes = 10;
            long startTime = System.currentTimeMillis();
            long endTime = startTime + TimeUnit.MINUTES.toMillis(timeLimitMinutes);

            for (MCQQuestion question : questions) {
                System.out.println(question.getQuestion());
                String[] options = question.getOptions();
                for (int i = 0; i < options.length; i++) {
                    System.out.println(options[i]);
                }

                System.out.print("Select an option (1-" + options.length + "): ");
                int selectedOption = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (question.isCorrect(selectedOption)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect.");
                }

                // Check if time is up
                if (System.currentTimeMillis() >= endTime) {
                    System.out.println("Time's up!");
                    break;
                }
            }

            System.out.println("Exam completed!");
            System.out.println("Your score: " + score);
		
        } else {
            System.out.println("Login failed. Incorrect password.");
        }

        // Simulated profile update and password change
        System.out.print("Do you want to update your profile or change your password? (Y/N): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            // Implement profile update and password change logic here
            System.out.println("Profile updated successfully!");
            
            
            System.out.print("Enter your current password: ");
            String currentPassword = scanner.nextLine();

            if (user.authenticate(currentPassword)) {
                System.out.print("Enter your new password: ");
                String newPassword = scanner.nextLine();
                user.setPassword(newPassword);
                System.out.println("Password changed successfully!");

            // Simulated session closure and logout
            System.out.println("Closing session...");
            user = null; // Log out the user
        } else {
            System.out.println("Login failed. Incorrect password.");
        }

        System.out.println("Thank you for using the Online Examination System!");
    }
    }
}
