import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String text = "Привет я просто 46 и 4 7 потом 78. Потом 12 следующий раз 4";
        System.out.println("Количество цифр в тексте: " + countDigits(text));
    }

    public static int countDigits(String text) {
        List<Character> digits = new ArrayList<>();
        int count = 0;

        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.add(c);
                count++;
            }
        }

        

        System.out.println("Найденные цифры: " + digits);
        return count;
    }
}