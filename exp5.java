import java.util.List;
import java.util.ArrayList;
public class exp5 {
    public static void main(String[] args) {
        String[] numberStrings = {"10", "20", "30", "40", "50"};
        List<Integer> numbers = new ArrayList<>();
        int sum = 0;      
        for (String str : numberStrings) {
            numbers.add(Integer.parseInt(str)); // Autoboxing
        }
                for (Integer num : numbers) {
            sum += num; // Unboxing
        }
                System.out.println("Sum of numbers: " + sum);
    }
}
 
