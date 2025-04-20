// // package hashmaps;

// import java.util.HashMap;
// import java.util.Map;


// import java.util.Scanner;

// public class four {
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int cards;
//         String symbol;
//         String number;

//         Map<String, List<String>> hashMap = new HashMap<>();

//         System.out.println("Enter the number of Cards you want to create: ");
//         cards = sc.nextInt();

//         //accepting multiple values under same symbol by creating new loop
        
        
//         for(int i = 0; i < cards; i++){
//             System.out.println("enter the symbol you want to create:");
//             symbol= sc.next();

//             System.out.println("Enter the card you want to create");
//             number = sc.next();

//             hashMap.add(symbol, number);
            
//         }
        
//         System.out.println("Your hashmap is: " + hashMap);

//         sc.close();
//     }
// }




import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;



public class four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cards;
        String symbol, number;

        Map<String, List<String>> hashMap = new HashMap<>();

        System.out.print("Enter the number of Cards you want to create: ");
        cards = sc.nextInt();

        for (int i = 0; i < cards; i++) {
            System.out.print("Enter the symbol you want to create: ");
            symbol = sc.next();

            System.out.print("Enter the card you want to create: ");
            number = sc.next();

            
            
            if (!hashMap.containsKey(symbol)) {
                hashMap.put(symbol, new ArrayList<>());
            }
            



            if (hashMap.get(symbol).contains(number)) {
                continue;
                // System.out.println("Card " + number + " already exists under symbol " + symbol + ". Duplicate not added.");
            } else {
                hashMap.get(symbol).add(number);
            }
            
        }

       
        System.out.println("Your hashmap is:");
        hashMap.forEach((key, value) -> System.out.println(key + " -> " + value));

        sc.close(); 
    }
}
