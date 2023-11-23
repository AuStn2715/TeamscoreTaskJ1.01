public class TaskMicro1 {
    public static void main(String[] args) {

        double[] variables = new double[8];
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
        System.out.print("число: ");
        for (int i = 0; i<8; i++) {
            System.out.print(variables[i]);
            System.out.print(" ");
        }
        System.out.println();

        System.out.print("round: ");
        for (int i = 0; i<8; i++) {
            System.out.print(Math.round(variables[i]));
            System.out.print("   ");
        }
        System.out.println();

        System.out.print("floor: ");
        for (int i = 0; i<8; i++) {
            System.out.print(Math.floor(variables[i]));
            System.out.print(" ");
        }
        System.out.println();

        System.out.print("ceil:  ");
        for (int i = 0; i<8; i++) {
            System.out.print(Math.ceil(variables[i]));
            System.out.print(" ");
        }
        System.out.println();

        System.out.print("rint:  ");
        for (int i = 0; i<8; i++) {
            System.out.print(Math.rint(variables[i]));
            System.out.print(" ");
        }
        System.out.println();

    }
}
