import java.sql.*;
import java.util.*;

public class PatientDAO {

    public void addPatient(Patient p) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO patients VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getName());
            ps.setInt(3, p.getAge());
            ps.setString(4, p.getGender());
            ps.setString(5, p.getDisease());
            ps.executeUpdate();
            System.out.println("Patient added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayPatients() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM patients";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Age: %d | Gender: %s | Disease: %s\n",
                        rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
                        rs.getString("gender"), rs.getString("disease"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePatient(int id, String newDisease) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE patients SET disease = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newDisease);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Patient record updated.");
            else
                System.out.println("Patient not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePatient(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM patients WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Patient record deleted.");
            else
                System.out.println("Patient not found.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
