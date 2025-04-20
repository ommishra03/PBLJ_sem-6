import java.util.Scanner;

public class EmployeeInfoApp {

    public static void main(String[] args) {

        // Getting input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask how many employees we want to store
        System.out.print("Enter the number of employees you want to store info for: ");
        int numberOfEmployees = scanner.nextInt();

        // Create arrays to store employee information
        String[] employeeNames = new String[numberOfEmployees];
        int[] employeeAges = new int[numberOfEmployees];
        double[] employeeSalaries = new double[numberOfEmployees];
        String[] employeeDepartments = new String[numberOfEmployees];

        // Collect data for each employee
        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("\n--- Enter details for employee " + (i + 1) + " ---");

            System.out.print("Enter name: ");
            scanner.nextLine(); // consume leftover newline
            employeeNames[i] = scanner.nextLine();

            System.out.print("Enter age: ");
            employeeAges[i] = scanner.nextInt();

            System.out.print("Enter salary: ");
            employeeSalaries[i] = scanner.nextDouble();

            System.out.print("Enter department: ");
            scanner.nextLine(); // consume newline
            employeeDepartments[i] = scanner.nextLine();
        }

        // Display all employee data
        System.out.println("\n===== Employee Information =====");
        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("\nEmployee " + (i + 1));
            System.out.println("Name: " + employeeNames[i]);
            System.out.println("Age: " + employeeAges[i]);
            System.out.println("Salary: ₹" + employeeSalaries[i]);
            System.out.println("Department: " + employeeDepartments[i]);
        }

        scanner.close();
    }
}
