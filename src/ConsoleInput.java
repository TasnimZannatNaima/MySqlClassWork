import java.util.Scanner;

public class ConsoleInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}

