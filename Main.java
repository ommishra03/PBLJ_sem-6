import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientDAO dao = new PatientDAO();

        while (true) {
            System.out.println("\n=== Hospital Management Menu ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Display Patients");
            System.out.println("3. Update Patient Disease");
            System.out.println("4. Delete Patient");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();  // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();
                    Patient p = new Patient(id, name, age, gender, disease);
                    dao.addPatient(p);
                    break;
                case 2:
                    dao.displayPatients();
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new disease: ");
                    String newDisease = sc.nextLine();
                    dao.updatePatient(uid, newDisease);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    dao.deletePatient(did);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
