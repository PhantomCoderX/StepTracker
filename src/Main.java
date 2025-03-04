import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    tracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    tracker.changeStepGoal();
                    break;
                case 3:
                    tracker.printStatistic();
                    break;
                case 4:
                    System.out.println("До свидания!");
                    return; // Выход из программы
                default:
                    System.out.println("Неизвестная команда");
            }
        }
    }

    static void printMenu() {
        System.out.println("====== Меню ======");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Напечатать статистику за определённый месяц");
        System.out.println("4. Выйти из приложения");
        System.out.println("==================");
        System.out.print("--> ");
    }
}