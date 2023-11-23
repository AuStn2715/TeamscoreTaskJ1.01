import java.math.BigDecimal;
import java.util.Scanner;
public class PracticalProblem1 {
    public static void main(String[] args) {
        System.out.print("Введите стоимость товара ");
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
            input = input.replaceAll("коп","");
            input = input.replaceAll("коп.","");
            input = input.replaceAll(",",".");
            try {
                value = Double.parseDouble(input);
            }
            catch (NumberFormatException ignored2) {} // ну тут уже ничто не поможет
        }

        // задача связана с деньгами, нужны точные рассчёты
        // проблема в том что в любом случае придется это число делить на 6, так что инт не подойдет
        // valueOf() переводит точнее (иначе юудет 0.1 -> 0.100000055...)
        BigDecimal strictValueWithNds = BigDecimal.valueOf(value);
        BigDecimal strictValue = (strictValueWithNds.multiply(new BigDecimal(100))).divide(BigDecimal.valueOf(1.2), 0);
        // если не домножать на 100 - округление пойдет до десятой доли, нам нужны сотые
        double nds = ((strictValueWithNds.multiply(new BigDecimal(100))).subtract(strictValue)).doubleValue();
        // вычитание даблов тоже лучше провести с повышенной точностью
        nds = nds / 100.0;
        value = strictValue.doubleValue()/100.0;

        String result = String.format("%.2f",value);
        System.out.println("Стоимость без НДС: " + result);
        result = String.format("%.2f",nds);
        System.out.println("НДС в чеке: " + result);
        System.out.println("НДС в декларации: " + Math.round(nds));

        // забавное замечание, в случае к примеру когда товар стоит 100руб, если мы сначала считаем стоимость без ндс, то получится 83.33+16.67
        // в случае же, если мы сначала считать НДС - выйдет 83.34+16.66
        // то есть по математическим причинам 1 копейка гуляет из одной графы в другую в зависимости от порядка действий
    }
}
