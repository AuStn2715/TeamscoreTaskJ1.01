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
        //in.close();

        int number;
        int oldNumber;
        int maxCombo = 0;
        var rnd = new Random();

        number = rnd.nextInt(2000) - 1000; // создадим первое заранее
        int curCombo = 1;

        for (int i = 1; i < n; i++) {
            oldNumber = number;
            number = rnd.nextInt(2000) - 1000;

            boolean currentNumberCombinesWithOld = (number * oldNumber > 0) || (number == 0 && oldNumber == 0);

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

        System.out.println("Самая длинная серия: " + maxCombo);
    }
}
