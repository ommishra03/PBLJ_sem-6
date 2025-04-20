import java.util.*;

class Card {
    private String symbol;
    private int number;

    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        return symbol + " " + number;
    }
}

public class CardCollector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<Card>> cardMap = new HashMap<>();

        System.out.print("Enter number of cards: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter card " + (i + 1) + " details:");
            System.out.print("Enter symbol: ");
            String symbol = sc.nextLine();

            System.out.print("Enter number: ");
            int number = sc.nextInt();
            sc.nextLine(); // consume newline

            Card card = new Card(symbol, number);

            // Add to map
            cardMap.computeIfAbsent(symbol, k -> new ArrayList<>()).add(card);
        }

        // Get distinct symbols and sort alphabetically
        List<String> symbols = new ArrayList<>(cardMap.keySet());
        Collections.sort(symbols);

        System.out.println("\nDistinct symbols in alphabetical order:");
        for (String s : symbols) {
            System.out.println(s);
        }

        // Optional: Show cards grouped by symbol
        System.out.println("\nCards grouped by symbol:");
        for (String s : symbols) {
            System.out.println("Symbol: " + s);
            for (Card c : cardMap.get(s)) {
                System.out.println("  Number: " + c.getNumber());
            }
        }

        sc.close();
    }
}
