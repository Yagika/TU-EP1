public class Aufgabe3 {
    public static void main(String[] args) {
        int degreeFahrenheit = 35;
        double degreeCelsius = degreeFahrenheit - 32;
        degreeCelsius = degreeCelsius * (5 / 9.);
        System.out.println("Grad Fahrenheit: " + degreeFahrenheit);
        System.out.println("Grad Celsius: " + degreeCelsius);
        double degreeCelsiusU = degreeCelsius;
        double degreeFahrenheitU = degreeCelsiusU  * (9 / 5.)+32;
        System.out.println("Grad Fahrenheit U: " + degreeFahrenheitU);
        System.out.println("Grad Celsius U: " + degreeCelsiusU);
    }
}
