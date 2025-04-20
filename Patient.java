public class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String disease;

    // Constructor
    public Patient(int id, String name, int age, String gender, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getDisease() { return disease; }
}
