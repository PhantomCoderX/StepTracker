public class Converter {

    int convertToKm(int steps) {
        return (int) ((steps * .75) / 1000);
    }

    int convertStepsToKilocalories(int steps) {
        return (int) ((steps * 50) / 1000);
    }
}
