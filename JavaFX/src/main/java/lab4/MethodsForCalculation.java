package lab4;

public class MethodsForCalculation {
    private int number;

    public MethodsForCalculation(int number) {
        this.number = number;
        System.out.println("Number for calculation - " + number);
    }


    public int getNumber() {
        return number;
    }


    public static String ResultFactorialText(MethodsForCalculation methodsForCalculation) {
        String result = "Calculation Factorial for " + methodsForCalculation.getNumber();
        return result;
    }

    @Annotation(3)
    public static String ResultFactorial(MethodsForCalculation methodsForCalculation) {
        int result = 1;
        for (int i = 1; i <= methodsForCalculation.getNumber(); i++) {
            result = result * i;
        }
        String result1 = "Result factorial - " + result;
        return result1;
    }

    @Annotation(2)
    protected static String ResultHarmonicSeriesText(MethodsForCalculation methodsForCalculation) {
        String result = "Calculation Harmonic Series for " + methodsForCalculation.getNumber();
        return result;
    }

    protected static String ResultHarmonicSeries(MethodsForCalculation methodsForCalculation) {
        double result = 0;
        int n = methodsForCalculation.getNumber();
        for (int i = 1; i <= n; i++) {
            result = result + (1 / (double) i);

        }
        String result1 = "Result harmonic Series - " + result;
        return result1;
    }

    @Annotation(1)
    private static String ResultExponentText(MethodsForCalculation methodsForCalculation) {
        String result = "Calculation Exponent for " + methodsForCalculation.getNumber();
        return result;
    }

    private static String ResultExponent(MethodsForCalculation methodsForCalculation) {
        double result = 0;
        result = Math.exp(methodsForCalculation.getNumber());
        String result1 = "Result exponent - " + result;
        return result1;

    }

}
