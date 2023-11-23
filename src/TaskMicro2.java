import java.util.Scanner;
public class TaskMicro2 {
    public static void main(String[] args) throws NumberFormatException {

        System.out.print("Введите значение: ");
        Scanner in = new Scanner(System.in);
        var input = in.next();
        in.close();

        boolean inputDataTypeIsNotDefined = true;
        String inputDataType = "Текст"; // по условию задачи любое не числовое или логическое значение можно считать текстом, поэтому это значение по умолчанию

        if (inputDataTypeIsNotDefined) {
            try {
                Double.parseDouble(input); // можно стереть, ведь эта попытка привести ввод к числу будет и дальше, оставил для наглядности
                inputDataTypeIsNotDefined = false;
                inputDataType = "Рациональное число";
                if (Double.parseDouble(input)%1 == 0) { // число 12.0 - целое, поэтому проверяю не равна ли дробная часть нулю
                    inputDataType = "Целое число";
                }
            }
            catch (NumberFormatException ignored) {}
        }

        if (inputDataTypeIsNotDefined) {
            if (input.equals("true") || input.equals("false")) {
                inputDataTypeIsNotDefined = false; // эта строка не имеет смысла сейчас, но логично оставить на случай, если придется добавлять новые типы данных
                inputDataType = "Логическое значение";
            }
        }

        System.out.print(inputDataType);
    }
}