import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        new Calculator(scanner.nextLine());
        scanner.close();
    }
}