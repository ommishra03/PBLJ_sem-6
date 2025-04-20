import java.io.*;

class Student implements Serializable {
    int id;
    String name;
    double gpa;

    Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
}

public class SerializeDemo {

    public static void main(String[] args) {
        Student s1 = new Student(101, "Om", 8.7);

        try {
            FileOutputStream fileOut = new FileOutputStream("student.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(s1);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        Student deserializedStudent = null;

        try {
            FileInputStream fileIn = new FileInputStream("student.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserializedStudent = (Student) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }

        if (deserializedStudent != null) {
            System.out.println(deserializedStudent.id);
            System.out.println(deserializedStudent.name);
            System.out.println(deserializedStudent.gpa);
        }
    }
}
