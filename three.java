

import java.util.*;

public class three {

    public static void main(String[] args) {
        int option;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Select option:");
            System.out.println("1. Interest Calculator - SB");
            System.out.println("2. Interest Calculator - FD");
            System.out.println("3. Interest Calculator - RD");
            System.out.println("4. Exit");
            System.out.print("Write Option: ");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the average amount in your account: ");
                    double sbAmount = sc.nextDouble();
                    System.out.print("Enter account type (Normal/NRI): ");
                    String accountType = sc.next();
                    SBAccount sbAccount = new SBAccount(sbAmount, accountType);
                    System.out.println("Interest gained: Rs. " + sbAccount.calculateInterest());
                    break;

                case 2:
                    System.out.print("Enter the FD amount: ");
                    double fdAmount = sc.nextDouble();
                    System.out.print("Enter the number of days: ");
                    int noOfDays = sc.nextInt();
                    System.out.print("Enter your age: ");
                    int fdAge = sc.nextInt();
                    if (fdAmount < 0 || noOfDays < 0 || fdAge < 0) {
                        System.out.println("Invalid input. Please enter correct values.");
                        break;
                    }
                    FDAccount fdAccount = new FDAccount(fdAmount, noOfDays, fdAge);
                    System.out.println("Interest gained: Rs. " + fdAccount.calculateInterest());
                    break;

                case 3:
                    System.out.print("Enter the monthly amount: ");
                    double monthlyAmount = sc.nextDouble();
                    System.out.print("Enter the number of months: ");
                    int noOfMonths = sc.nextInt();
                    System.out.print("Enter your age: ");
                    int rdAge = sc.nextInt();
                    if (monthlyAmount < 0 || noOfMonths < 0 || rdAge < 0) {
                        System.out.println("Invalid input. Please enter correct values.");
                        break;
                    }
                    RDAccount rdAccount = new RDAccount(monthlyAmount, noOfMonths, rdAge);
                    System.out.println("Interest gained: Rs. " + rdAccount.calculateInterest());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    abstract static class Account {
        protected double amount;

        public Account(double amount) {
            this.amount = amount;
        }

        abstract double calculateInterest();
    }

    static class SBAccount extends Account {
        private double interestRate;

        public SBAccount(double amount, String accountType) {
            super(amount);
            this.interestRate = accountType.equalsIgnoreCase("NRI") ? 0.06 : 0.04; // 6% for NRI, 4% for Normal
        }

        @Override
        double calculateInterest() {
            return amount * interestRate;
        }
    }

    static class FDAccount extends Account {
        private int noOfDays;
        private int ageOfACHolder;
        private double interestRate;

        public FDAccount(double amount, int noOfDays, int ageOfACHolder) {
            super(amount);
            this.noOfDays = noOfDays;
            this.ageOfACHolder = ageOfACHolder;
            this.interestRate = getInterestRate();
        }

        private double getInterestRate() {
            if (amount < 1_00_00_000) {
                if (noOfDays >= 7 && noOfDays <= 14) {
                    return ageOfACHolder >= 60 ? 5.00 : 4.50;
                } else if (noOfDays >= 15 && noOfDays <= 29) {
                    return ageOfACHolder >= 60 ? 5.25 : 4.75;
                } else if (noOfDays >= 30 && noOfDays <= 45) {
                    return ageOfACHolder >= 60 ? 6.00 : 5.50;
                } else if (noOfDays >= 46 && noOfDays <= 60) {
                    return ageOfACHolder >= 60 ? 7.50 : 7.00;
                } else if (noOfDays >= 61 && noOfDays <= 184) {
                    return ageOfACHolder >= 60 ? 8.00 : 7.50;
                } else if (noOfDays >= 185 && noOfDays <= 365) {
                    return ageOfACHolder >= 60 ? 8.50 : 8.00;
                }
            } else {
                if (noOfDays >= 7 && noOfDays <= 14) {
                    return 6.50;
                } else if (noOfDays >= 15 && noOfDays <= 29) {
                    return 6.75;
                } else if (noOfDays >= 30 && noOfDays <= 45) {
                    return 6.75;
                } else if (noOfDays >= 46 && noOfDays <= 60) {
                    return 8.00;
                } else if (noOfDays >= 61 && noOfDays <= 184) {
                    return 8.50;
                } else if (noOfDays >= 185 && noOfDays <= 365) {
                    return 10.00;
                }
            }
            return 0;
        }

        @Override
        double calculateInterest() {
            return amount * (interestRate / 100);
        }
    }

    static class RDAccount extends Account {
        private int noOfMonths;
        private double monthlyAmount;
        private int ageOfACHolder;
        private double interestRate;

        public RDAccount(double monthlyAmount, int noOfMonths, int ageOfACHolder) {
            super(monthlyAmount * noOfMonths);
            this.noOfMonths = noOfMonths;
            this.monthlyAmount = monthlyAmount;
            this.ageOfACHolder = ageOfACHolder;
            this.interestRate = getInterestRate();
        }

        private double getInterestRate() {
            if (noOfMonths == 6) {
                return ageOfACHolder >= 60 ? 8.00 : 7.50;
            } else if (noOfMonths == 9) {
                return ageOfACHolder >= 60 ? 8.25 : 7.75;
            } else if (noOfMonths == 12) {
                return ageOfACHolder >= 60 ? 8.50 : 8.00;
            } else if (noOfMonths == 15) {
                return ageOfACHolder >= 60 ? 8.75 : 8.25;
            } else if (noOfMonths == 18) {
                return ageOfACHolder >= 60 ? 9.00 : 8.50;
            } else if (noOfMonths == 21) {
                return ageOfACHolder >= 60 ? 9.25 : 8.75;
            }
            return 0;
        }

        @Override
        double calculateInterest() {
            return amount * (interestRate / 100);
        }
    }
}



