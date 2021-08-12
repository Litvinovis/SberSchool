import java.util.Scanner;

public class Kth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert set of numbers without space");
        String set = scanner.nextLine();
        System.out.println("Please insert Kth number");
        int a = scanner.nextInt();
        char answer = set.charAt(a - 1);
        System.out.println("number is " + answer);
    }
}