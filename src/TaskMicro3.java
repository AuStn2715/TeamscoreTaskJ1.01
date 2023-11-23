import java.util.Scanner;
public class TaskMicro3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        int numberCount = 0;
        double minNumber = Double.NaN; // в пустом множестве нет минимального и максимального чисел, но null пихать не хочется
        double maxNumber = Double.NaN;
        double sum = 0.0;

        while (true) {
            input = in.nextLine();
            if (input.isEmpty()) {
                break;
            }
            try {
                var parsedInput = Double.parseDouble(input);
                numberCount++;

                if (numberCount == 1) {
                    minNumber = parsedInput;
                    maxNumber = parsedInput;
                }

                sum += parsedInput;

                if (parsedInput < minNumber) {
                    minNumber = parsedInput;
                }
                else if (parsedInput > maxNumber) {
                    maxNumber = parsedInput;
                }
            } catch (NumberFormatException ignored) {
                break;
            }
        }
        //in.close();
        double average = sum / numberCount;

        System.out.println("Количество чисел: " + numberCount);
        System.out.println("Минимальное: " + minNumber);
        System.out.println("Максимальное: " + maxNumber);
        System.out.println("Сумма этих чисел: " + sum);
        System.out.println("Среднее значение: " + average);
    }
}
