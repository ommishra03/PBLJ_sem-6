import java.util.*;

public class IntegerSumDemo {

    // Method to parse a list of strings into a list of Integer objects
    public static List<Integer> parseStringsToIntegers(List<String> stringList) {
        List<Integer> intList = new ArrayList<>();
        for (String s : stringList) {
            // parseInt returns primitive int, autoboxing converts it to Integer
            Integer num = Integer.parseInt(s);
            intList.add(num); // Autoboxing happens here
        }
        return intList;
    }

    // Method to calculate the sum of a list of Integers (unboxing occurs here)
    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num; // Unboxing occurs here
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numbers separated by space: ");
        String input = scanner.nextLine();

        // Split input into string list
        String[] parts = input.trim().split("\\s+");
        List<String> stringList = Arrays.asList(parts);

        // Parse strings to integers
        List<Integer> numbers = parseStringsToIntegers(stringList);

        // Calculate and print the sum
        int sum = calculateSum(numbers);
        System.out.println("Sum of the entered numbers: " + sum);

        scanner.close();
    }
}
