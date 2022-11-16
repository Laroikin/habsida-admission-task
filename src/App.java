import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input: ");
        Calculator obj = new Calculator(scanner.nextLine());
        obj.calculate();
        scanner.close();
    }
}