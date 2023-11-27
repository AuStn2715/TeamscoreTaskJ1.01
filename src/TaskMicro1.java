public class TaskMicro1 {
    public static void main(String[] args) {

        int VAR_COUNT = 8;
        double[] variables = new double[VAR_COUNT];
        variables[0] = 30.0;
        variables[1] = 10000.1;
        variables[2] = 12.5;
        variables[3] = 99.99;
        variables[4] = 0.0;
        variables[5] = -4.5;
        variables[6] = -23.45;
        variables[7] = -129.675;

        // задача - вывести данные в виде таблицы, но не указано какой конкретно
        // поэтому просто структурируем данные в консоли, позже можно будет легко переписать
        System.out.println("число   round   floor   ceil    rint    ");
        for (int i = 0; i<VAR_COUNT; i++) {
            PrintFormatedForTable(variables[i]);
            PrintFormatedForTable(Math.round(variables[i]));
            PrintFormatedForTable(Math.floor(variables[i]));
            PrintFormatedForTable(Math.ceil(variables[i]));
            PrintFormatedForTable(Math.rint(variables[i]));
            System.out.println();
        }

    }

    private static void PrintFormatedForTable(double number) { // не знаком с встроенными функциями выравнивания, поэтому быстро сделал свою

        int COLOMN_LENGTH = 8;
        String result = "" + number;
        int gapLegth = COLOMN_LENGTH - result.length();
        System.out.print(result + " ".repeat(gapLegth));

    }
}
