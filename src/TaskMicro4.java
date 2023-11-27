import java.util.Scanner;
import java.util.Random;
public class TaskMicro4 {
    public static void main(String[] args) {
        System.out.print("Введите n ");
        var in = new Scanner(System.in);
        int n = in.nextInt();
        //in.close();

        int prevNumber;
        var rnd = new Random();
        int maxRepeats = 0; // пока мы не уверены что хотя бы 1 число есть - длина серии = 0

        if (n > 0) {
            int number = rnd.nextInt(2000) - 1000; // создадим первое заранее
            int curRepeats = 1;
            maxRepeats = 1; // мы ввели первое число, так что комбо автоматически стало равным 1

            for (int i = 1; i < n; i++) {
                prevNumber = number;
                number = rnd.nextInt(2000) - 1000;

                boolean currentNumberCombinesWithOld = (number * prevNumber > 0) || (number == 0 && prevNumber == 0);

                if (currentNumberCombinesWithOld) {
                    curRepeats++;
                    if (curRepeats > maxRepeats) {
                        maxRepeats = curRepeats;
                    }
                }
                else {
                    curRepeats = 1;
                }
            }
        }

        System.out.println("Самая длинная серия: " + maxRepeats);
    }
}
