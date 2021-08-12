import java.util.Scanner;

public class Frame {
    public static void print(int h, int w, String word) {
        int centerH, centerW, a, b;
        if (h % 2 == 0)
            centerH = h / 2;
        else
            centerH = (h / 2) + 1;
        centerW = (w + 2 - word.length()) / 2;
        a = 1;
        while (a <= h) {
            b = 1;
            while (b <= w) {
                if ((a == centerH) && (b == centerW)) {
                    System.out.print(word);
                    b += word.length();
                }
                else {
                    if (a == 1 || a == h || b == 1 || b == w)
                        System.out.print('*');
                    else
                        System.out.print(' ');
                    b++;
                }
            }
            System.out.print('\n');
            a++;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        int height = in.nextInt();
        int width = in.nextInt();
        String word = str.nextLine();
        int maxSize = word.length() + 2;
        if (maxSize > width) {
            System.out.println("Ошибка");
            System.exit(1);
        }
        print(height, width, word);
    }
}
