import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Balda {

    private File Words = new File("./src/words.txt");

    public static boolean checkWord(String temp, Set<Character> allow, ArrayList<String> words,
                                    ArrayList<String> used) {
        if (words.contains(temp) && !used.contains(temp)) {
            char[] tempChar = temp.toCharArray();
            for (char i : tempChar) {
                if (!allow.contains(i)) {
                    return false;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    public static String firstWord(ArrayList<String> words) {
        Random random = new Random();
        String first;
        do {
            first = words.get(random.nextInt(words.size()));
        } while (first.length() < 8);
        return first;
    }

    public static ArrayList<String> wordsAdd(File src) throws IOException {
        try {
            ArrayList<String> dictionary = new ArrayList<String>();
            FileReader FR = new FileReader(src);
            BufferedReader reader = new BufferedReader(FR);
            String temp;
            do {
                temp = reader.readLine();
                dictionary.add(temp);
            } while (temp != null);
            return dictionary;
        }
        catch (IOException mes) {
            throw new IOException(mes.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        File Words = new File("./src/words.txt");
        ArrayList<String> words = wordsAdd(Words);
        ArrayList<String> used = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        int again = 1,
                finish = 0,
                wordsFirstPlayer = 0,
                charFirstPlayer = 0,
                wordsSecondPlayer = 0,
                charSecondPlayer = 0;
        String temp;

        used.add(firstWord(words));
        System.out.println("Слово для этой игры - " + used.get(0));
        Set<Character> allow = new HashSet<Character>();
        for(char c : used.get(0).toCharArray()) {
            allow.add(c);
        }
        System.out.println("Составьте из букв этого слова другое и введите его в консоль");
        while (finish < 2) {
            finish = 0;
            System.out.println("Ход игрока №1");
            again = 1;
            while (again == 1) {
                temp = scanner.nextLine();
                if (temp.isEmpty()) {
                    finish++;
                    System.out.println("Вы ввели пустое слово");
                    again = 0;
                } else {
                    if (checkWord(temp, allow, words, used)) {
                        used.add(temp);
                        wordsFirstPlayer++;
                        charFirstPlayer += temp.length();
                        System.out.println("Слово принято");
                        again = 0;
                    } else {
                        System.out.println("Ваше слово не подходит введите его заново");
                        again = 1;
                    }
                }
            }
            System.out.println("Ход игрока №2");
            again = 1;
            while (again == 1) {
                temp = scanner.nextLine();
                if (temp.isEmpty()) {
                    finish++;
                    System.out.println("Вы ввели пустое слово");
                    again = 0;
                } else {
                    if (checkWord(temp, allow, words, used)) {
                        used.add(temp);
                        wordsSecondPlayer++;
                        charSecondPlayer += temp.length();
                        System.out.println("Слово принято");
                        again = 0;
                    } else {
                        System.out.println("Ваше слово не подходит введите его заново");
                        again = 1;
                    }
                }
            }
        }
        System.out.println("Игра закончена");
        if (charFirstPlayer > charSecondPlayer) {
            System.out.println("Игрок №1 выиграл");
        }
        else if (charFirstPlayer < charSecondPlayer) {
            System.out.println("Игрок №2 выиграл");
        }
        else {
            System.out.println("Победила дружба, оба игрока набрали одинаковое количество очков");
        }
        System.out.println( "\n" + "Статистика:");
        System.out.println( "Игрок №1 ввёл " + wordsFirstPlayer + " слов, заработав " + charFirstPlayer + " очков");
        System.out.println( "Игрок №2 ввёл " + wordsSecondPlayer + " слов, заработав " + charSecondPlayer + " очков");
    }
}
