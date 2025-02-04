package pl.gornik;

public class Function {
    private double[] coefficients;

    public Function(double[] coefficients){
        this.coefficients = coefficients;
    }

    public double calculateRoot(double start, double stop, double accuracy) {
        double middle = 0;
        while (calculateValueFunction(start) != 0 && calculateValueFunction(stop) != 0 && (stop - start) >= accuracy) {
            middle = (start + stop) / 2;
            if (calculateValueFunction(start) * calculateValueFunction(middle) < 0) {
                stop = middle;
            } else {
                start = middle;
            }
        }
        return middle;
    }

    public double calculateValueFunction(double number) {
        double value = 0;
        for (int i = 0; i < coefficients.length; i++) {
            value += coefficients[i] * Math.pow(number, coefficients.length - i - 1);
        }
        return value;
    }

    public void printFunction() {
        String function = "f(x) = ";
        for (int i = 0; i < coefficients.length; i++) {
            if (i == 0 && coefficients[i] != 0) {
                function += (coefficients[i] + "x^" + (coefficients.length - 1 - i));
            }
            else if (i == coefficients.length - 1) {
                if (coefficients[i] > 0){
                    function += (" + " + coefficients[i]);
                } else if (coefficients[i] < 0) {
                    function += (" - " + Math.abs(coefficients[i]));
                }
            }
            else if (coefficients[i] > 0){
                function += (" + " + coefficients[i] + "x^" + (coefficients.length - 1 - i));
            }
            else if (coefficients[i] < 0){
                function += (" - " + Math.abs(coefficients[i]) + "x^" + (coefficients.length - 1 - i));
            }
        }
        System.out.println(function);
    }
}
