import java.util.Scanner;


abstract class Account {
    protected double principal;
    protected double rate;
    protected int time;

    // Abstract method to be implemented by subclasses
    public abstract double calculateInterest();
}


class FDAccount extends Account {
    public FDAccount(double principal, double rate, int time) {
        if (principal <= 0 || rate <= 0 || time <= 0) {
            throw new IllegalArgumentException("FD values must be greater than 0.");
        }
        this.principal = principal;
        this.rate = rate;
        this.time = time;
    }

    @Override
    public double calculateInterest() {
        return (principal * rate * time) / 100;
    }
}

class RDAccount extends Account {
    private int months;

    public RDAccount(double monthlyDeposit, double rate, int months) {
        if (monthlyDeposit <= 0 || rate <= 0 || months <= 0) {
            throw new IllegalArgumentException("RD values must be greater than 0.");
        }
        this.principal = monthlyDeposit;
        this.rate = rate;
        this.months = months;
    }

    @Override
    public double calculateInterest() {
        // Formula for RD interest: I = P * n(n+1) * r / (2 * 12 * 100)
        return (principal * months * (months + 1) * rate) / (2 * 12 * 100);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Choose account type: 1. FD  2. RD");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter principal amount: ");
                double principal = sc.nextDouble();
                System.out.print("Enter interest rate: ");
                double rate = sc.nextDouble();
                System.out.print("Enter time in years: ");
                int time = sc.nextInt();

                FDAccount fd = new FDAccount(principal, rate, time);
                System.out.println("FD Interest: " + fd.calculateInterest());

            } else if (choice == 2) {
                System.out.print("Enter monthly deposit: ");
                double monthlyDeposit = sc.nextDouble();
                System.out.print("Enter interest rate: ");
                double rate = sc.nextDouble();
                System.out.print("Enter duration in months: ");
                int months = sc.nextInt();

                RDAccount rd = new RDAccount(monthlyDeposit, rate, months);
                System.out.println("RD Interest: " + rd.calculateInterest());

            } else {
                System.out.println("Invalid choice.");
            }

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            System.out.println("Interest calculation complete.");
            sc.close();
        }
    }
}
