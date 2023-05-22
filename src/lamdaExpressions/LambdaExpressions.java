package lamdaExpressions;

public class LambdaExpressions {
    public static void main(String[] args) {
        // Lambda expressions for addition, subtraction, multiplication, and division
        MathOperation addition = (a, b) -> a + b;
        int result1 = addition.operate(5, 3);
        System.out.println("Addition: " + result1);

        MathOperation subtraction = (a, b) -> a - b;
        int result2 = subtraction.operate(10, 4);
        System.out.println("Subtraction: " + result2);

        MathOperation multiplication = (a, b) -> a * b;
        int result3 = multiplication.operate(6, 2);
        System.out.println("Multiplication: " + result3);

        MathOperation division = (a, b) -> a / b;
        int result4 = division.operate(15, 5);
        System.out.println("Division: " + result4);


    }

    // Functional interface for math operations
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }
}
