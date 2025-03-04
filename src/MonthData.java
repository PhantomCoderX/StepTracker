class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int day = 0; day < days.length; day++) {
            System.out.println((day + 1) + " день: " + days[day]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int day : days) {
            sumSteps += day;
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int day : days) {
            if (day > maxSteps) {
                maxSteps = day;
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int stepsPerDay : days) {
            if (stepsPerDay >= goalByStepsPerDay) {
                if (++currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
}