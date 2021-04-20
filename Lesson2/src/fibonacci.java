import java.util.*;

public class fibonacci {
    public static String fibs(int natural) {
        List<Integer> ListFibs = new ArrayList<Integer>();
        StringBuilder answer = new StringBuilder();
        int temp = 0;
        ListFibs.add(1);
        int newFibs = 2;
        while (newFibs <= natural) {
            ListFibs.add(newFibs);
            temp = ListFibs.get(ListFibs.size() - 2);
            newFibs = newFibs + temp;
        }
        int size = ListFibs.size();
        while (--size >= 0) {
            int fibNumber = ListFibs.get(size);
            if (natural >= fibNumber)
                answer.append(1);
            else
                answer.append(0);
            if (fibNumber <= natural)
                natural -= fibNumber;
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please insert natural number");
        int natural = in.nextInt();
        if (natural <= 0) {
            System.out.println(0);
        } else
            System.out.println(fibs(natural));
    }
}