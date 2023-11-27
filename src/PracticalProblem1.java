import java.util.Scanner;
public class PracticalProblem1 {
    public static void main(String[] args) {
        System.out.print("Введите стоимость товара ");
        double valueWithNds = CustomInput();
        double nds = valueWithNds / 6.0; // если считать и округлять сначала НДС, то лишние доли копейки упадут в налог
        nds = Math.round(nds * 100) / 100.0;
        double value = ((int)(valueWithNds * 100) - (int)(nds * 100)) / 100.0; // проводим вычитание на интах, чтобы избежать ошибок

        System.out.println("Стоимость без НДС: " + value);
        System.out.println("НДС в чеке: " + nds);
        System.out.println("НДС в декларации: " + Math.round(nds));

    }

    private static double CustomInput() {
        var in = new Scanner(System.in);
        var input = in.nextLine();
        in.close();
        double value = -1;

        try {
            value = Double.parseDouble(input);
        }
        catch (NumberFormatException ignored) { // задача "практическая", допустим пользователь ввёл что-то вроде "99руб 99коп", или через запятую
            input = input.replaceAll("руб ",".");
            input = input.replaceAll("руб. ",".");
            input = input.replaceAll("руб, ",".");
            input = input.replaceAll("коп","");
            input = input.replaceAll("коп.","");
            input = input.replaceAll(",",".");
            try {
                value = Double.parseDouble(input);
            }
            catch (NumberFormatException ignored2) { // ну тут уже ничто не поможет
                System.out.println("Не получается распознать введённые данные");
            }
        }

        return value;
    }
}
