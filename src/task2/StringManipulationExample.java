package task2;

public class StringManipulationExample {
    public static void main(String[] args) {
      StringManipulator uppercase = s -> s.toUpperCase();

      //Change to uppercase
          String input = "What a wonderful world!";
          String manipulated = uppercase.manipulate(input);
          System.out.println("Uppercase: "+manipulated );

      //Count the length of the string
          StringManipulator lengthCounter = s -> Integer.toString((s.length()));
          String length1 = lengthCounter.manipulate(input);
          System.out.println("Length: " + length1);

      //Check if a string is empty
          StringManipulator emptyChecker = s -> Boolean.toString(s.isEmpty());
          String input2 = "1";
          String isEmpty = emptyChecker.manipulate(input2);
        System.out.println("Is empty: "+isEmpty);
      }

}
