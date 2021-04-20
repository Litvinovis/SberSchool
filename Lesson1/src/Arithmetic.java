
import java.util.Scanner;

public class Arithmetic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the first number");
        int a = in.nextInt();
        System.out.println("Please enter the arithmetic operation");
        char opera = in.next().charAt(0);
        System.out.println("Please enter the second number");
        int b = in.nextInt();
        int answer = 0;
        switch(opera) {
            case '+' :
                answer = a + b;
                break;
            case '-' :
                answer = a - b;
                break;
            case '*' :
                answer = a * b;
                break;
            case '/' :
                answer = a / b;
                break;
            default:
                System.out.println("Please enter valid arithmetic operation");
                System.exit(1);
        }
        System.out.println("answer is " + answer);
    }
}
