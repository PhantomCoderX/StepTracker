import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter convert;

    StepTracker(Scanner scan) {
        scanner = scan;
        convert = new Converter();
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        System.out.print("--> ");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Месяц должен быть от 1 до 12, а у вас: " + month);
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        System.out.print("--> ");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("День должен быть от 1 до 30, а у вас: " + day);
            return;
        }

        System.out.println("Введите количество шагов");
        System.out.print("--> ");
        int steps = scanner.nextInt();
        if (steps <= 0) {
            System.out.println("Количество шагов должно быть больше нуля, а у вас: " + steps);
            return;
        }

        // получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[month - 1];
        // сохранение полученных данных
        monthData.days[day - 1] = steps;
    }

    void changeStepGoal() {
        System.out.println("Введите новое значение количества шагов");
        System.out.print("--> ");
        int goal = scanner.nextInt();
        if (goal <= 0) {
            System.out.println("Цель шагов должна быть больше нуля, а у вас: " + goal);
            return;
        }

        goalByStepsPerDay = goal;
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        System.out.print("--> ");
        int curMonth = scanner.nextInt();
        if (curMonth < 1 || curMonth > 12) {
            return;
        }

        MonthData curMonthData = monthToData[curMonth - 1]; // получение соответствующего месяца
        int sumSteps = curMonthData.sumStepsFromMonth(); // получение суммы шагов за месяц
        curMonthData.printDaysAndStepsFromMonth(); // вывод общей статистики по дням
        System.out.println("*** Общее количество шагов за месяц: " + sumSteps); // вывод суммы шагов за месяц
        int maxSteps = curMonthData.maxSteps();
        System.out.println("*** Максимальное пройденное количество шагов за месяц: " + maxSteps); // вывод максимального пройденного количества шагов за месяц
        int averageSteps = sumSteps / 30;
        System.out.println("*** Среднее количество шагов: " + averageSteps); // вывод среднего пройденного количества шагов за месяц
        int convertToKm = convert.convertToKm(sumSteps);
        System.out.println("*** Пройденная дистанция (в км): " + convertToKm); // вывод пройденной за месяц дистанции в километрах
        int caloriesPerMonth = convert.convertStepsToKilocalories(sumSteps);
        System.out.println("*** Количество сожжённых килокалорий: " + caloriesPerMonth); // вывод количества сожжённых килокалорий за месяц
        int bestSeries = curMonthData.bestSeries(goalByStepsPerDay);
        System.out.println("*** Лучшая серия: " + bestSeries);// вывод лучшей серии
        System.out.println(); // дополнительный перенос строки
    }
}