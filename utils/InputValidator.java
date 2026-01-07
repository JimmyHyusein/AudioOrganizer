package NEW.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidator {
    private final Scanner scanner;

    public InputValidator() {
        this.scanner = new Scanner(System.in);
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.println("Грешка: Полето не може да бъде празно.");
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        }
        return input;
    }

    public String readTextOnly(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        String regex = "^[a-zA-Zа-яА-Я\\s\\-]+$";

        while (!Pattern.matches(regex, input)) {
            System.out.println("Грешка: Моля въведете валидно име (само букви).");
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        }
        return input;
    }

    public int readInt(String prompt, int min, int max) {
        System.out.print(prompt);
        int input;
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Грешка: Моля въведете цяло число!");
                scanner.next();
                System.out.print(prompt);
            }
            input = scanner.nextInt();
            scanner.nextLine();

            if (input >= min && input <= max) {
                break;
            } else {
                System.out.println("Грешка: Числото трябва да е между " + min + " и " + max);
                System.out.print(prompt);
            }
        }
        return input;
    }
}