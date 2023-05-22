package task3;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalInterfacesExample {
    public static void main(String[] args) {
        // Predicate interface
        Predicate<Integer> isPositive = num -> num > 0;
        System.out.println("Is 5 positive? " + isPositive.test(5));
        System.out.println("Is -2 positive? " + isPositive.test(-2));

        // Function interface
        Function<Integer, Integer> doubleNumber = num -> num * 2;
        int result = doubleNumber.apply(5);
        System.out.println("Double of 5: " + result);

        // Consumer interface
        Consumer<String> printMessage = message -> System.out.println("Message: " + message);
        printMessage.accept("Hello, world!");

        // Supplier interface
        Supplier<Double> randomNumber = () -> Math.random();
        double number = randomNumber.get();
        System.out.println("Random number: " + number);
    }
}
