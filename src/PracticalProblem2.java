import java.util.Scanner;
public class PracticalProblem2 {
    public static void main(String[] args) {
        long minutesLeft;
        if (args.length > 0) { // по задаче требуется возможность вводить аргумент из командной строки
            minutesLeft = Long.parseLong(args[0]);
        }
        else {
            Scanner in = new Scanner(System.in);
            minutesLeft = in.nextLong(); // речь идет о минутах в году например, большое число
            in.close();
        }

        if (minutesLeft < 1) {
            System.out.println("Уже началось!");
        }
        else {
            int MINUTES_COUNT_IN_DAY = 1440;
            long daysLeft = minutesLeft / MINUTES_COUNT_IN_DAY;
            minutesLeft = minutesLeft - daysLeft * MINUTES_COUNT_IN_DAY;
            int hoursLeft = (int)(minutesLeft / 60); // часов будет не более 24, лонг не нужен
            minutesLeft = minutesLeft - hoursLeft * 60L;
            CustomTimeOutput(daysLeft, hoursLeft, minutesLeft);
        }
    }


    private static void CustomTimeOutput(long days, int hours, long minutes) {
        double critNumber; // сотни, тысячи и тд не влияют на окончание

        if (days > 0) { // было бы странно выводить "осталось 0 дней", но можно просто убрать эту проверку и будет именно так и выводиться
            String daysEnding = null;
            critNumber = days % 100;

            if (critNumber > 20) {
                critNumber = critNumber % 10; // 21 ДЕНЬ, 31 ДЕНЬ, десятки не влияют, кроме первого
                if (critNumber > 0.5 && critNumber < 1.5) { // на случай ошибок округления не ==1.0
                    daysEnding = "день";
                }
                else if (critNumber > 1.5 && critNumber < 4.5) // делаю не 1.0 - 5.0 на случай ошибок округления
                {
                    daysEnding = "дня";
                }
                else {
                    daysEnding = "дней";
                }
            }
            else {
                if (critNumber > 0.5 && critNumber < 1.5) {
                    daysEnding = "день";
                }
                else if (critNumber > 1.5 && critNumber < 4.5) // делаю не 1.0 - 5.0 на случай ошибок округления
                {
                    daysEnding = "дня";
                }
                else {
                    daysEnding = "дней";
                }
            }

            System.out.print(days + " " + daysEnding + " ");
        }

        if (hours > 0) {
            String hoursEnding = null;
            critNumber = hours % 100;

            if (critNumber > 20) {
                critNumber = critNumber % 10;
                if (critNumber > 0.5 && critNumber < 1.5) {
                    hoursEnding = "час";
                }
                else if (critNumber > 1.5 && critNumber < 4.5)
                {
                    hoursEnding = "часа";
                }
                else {
                    hoursEnding = "часов";
                }
            }
            else {
                if (critNumber > 0.5 && critNumber < 1.5) {
                    hoursEnding = "час";
                }
                else if (critNumber > 1.5 && critNumber < 4.5)
                {
                    hoursEnding = "часа";
                }
                else {
                    hoursEnding = "часов";
                }
            }

            System.out.print(hours + " " + hoursEnding + " ");
        }

        if (minutes > 0) {
            String minutesEnding = null;
            critNumber = minutes % 100;

            if (critNumber > 20) {
                critNumber = critNumber % 10;
                if (critNumber > 0.5 && critNumber < 1.5) {
                    minutesEnding = "минута";
                } else if (critNumber > 1.5 && critNumber < 4.5) {
                    minutesEnding = "минуты";
                } else {
                    minutesEnding = "минут";
                }
            } else {
                if (critNumber > 0.5 && critNumber < 1.5) {
                    minutesEnding = "минута";
                } else if (critNumber > 1.5 && critNumber < 4.5) {
                    minutesEnding = "минуты";
                } else {
                    minutesEnding = "минут";
                }
            }

            System.out.print(minutes + " " + minutesEnding + " ");
        }

    }
}
