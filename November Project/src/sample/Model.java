package sample;

public class Model {
    public double calculateSqrt(double number) {
        return Math.sqrt(number);
    }

    public double calculatePercent(double number1, double number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number1 * number2 / 100.0;
            case "-":
                return number1 - number2 * number2 / 100.0;
            case "x":
                return number1 * number2 / 100.0;
            case "÷":
                if (number2 == 0) {
                    return 0;
                }
                return number1 / (number2 / 100.0);
            default:
                break;
        }
        return 0;
    }

    public double calculate(double number1, double number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "x":
                return number1 * number2;
            case "÷":
                if (number2 == 0) {
                    return 0;
                }
                return number1 / number2;
            default:
                break;
        }
        return 0;
    }
}
