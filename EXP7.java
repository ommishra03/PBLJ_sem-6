import java.io.*;
import java.util.*;

class Employee implements Serializable {
    String name;
    int id;
    String designation;
    double salary;

    Employee(String name, int id, String designation, double salary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.salary = salary;
    }

    public String toString() {
        return id + " " + name + " " + designation + " " + salary;
    }
}

public class EmployeeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            File f = new File("employees.ser");
            if (f.exists()) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
                employees = (ArrayList<Employee>) in.readObject();
                in.close();
            }
        } catch (Exception e) {
        }

        while (true) {
            System.out.println("1. Add an Employee\n2. Display All\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter designation: ");
                String designation = sc.nextLine();
                System.out.print("Enter salary: ");
                double salary = sc.nextDouble();

                employees.add(new Employee(name, id, designation, salary));

                try {
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employees.ser"));
                    out.writeObject(employees);
                    out.close();
                } catch (IOException e) {
                    System.out.println("Error saving employee");
                }

            } else if (choice == 2) {
                for (Employee emp : employees)
                    System.out.println(emp);
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid Option");
            }
        }

        sc.close();
    }
}
