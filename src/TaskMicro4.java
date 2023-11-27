import java.util.Scanner;
import java.util.Random;
public class TaskMicro4 {
    public static void main(String[] args) {
        System.out.print("Введите n ");
        var in = new Scanner(System.in);
        int n = 0;
        var input = in.next();
        try {
            n = (int)Double.parseDouble(input); // проверка ввода на всякий случай
        }
        catch (NumberFormatException ignored) {}
        in.close();

        int prevNumber;
        var rnd = new Random();
        int maxCombo = 0; // пока мы не уверены что хотя бы 1 число есть - комбо 0

        if (n > 0) {
            int number = rnd.nextInt(2000) - 1000; // создадим первое заранее
            int curCombo = 1;
            maxCombo = 1; // мы ввели первое число, так что комбо автоматически стало равным 1

            for (int i = 1; i < n; i++) {
                prevNumber = number;
                number = rnd.nextInt(2000) - 1000;

                boolean currentNumberCombinesWithOld = (number * prevNumber > 0) || (number == 0 && prevNumber == 0);

                if (currentNumberCombinesWithOld) {
                    curCombo++;
                    if (curCombo > maxCombo) {
                        maxCombo = curCombo;
                    }
                }
                else {
                    curCombo = 1;
                }
            }
        }

        System.out.println("Самая длинная серия: " + maxCombo);
    }
}
