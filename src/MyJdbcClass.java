import java.sql.*;
import java.util.ArrayList;

public class MyJdbcClass {
    private Connection conn;

    public MyJdbcClass() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/classwork", "root", "12345");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addStudent(Student student) {
        try {
            String query = "INSERT INTO students (id, name, department) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, student.getId());
            pst.setString(2, student.getName());
            pst.setString(3, student.getDepartment());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
            return false;
        }
    }

    public Student getStudent(int id) {
        try {
            String query = "SELECT * FROM students WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("department"));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving student: " + e.getMessage());
        }
        return null;
    }

    public boolean updateStudent(Student student) {
        try {
            String query = "UPDATE students SET name = ?, department = ? WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, student.getName());
            pst.setString(2, student.getDepartment());
            pst.setInt(3, student.getId());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteStudent(int id) {
        try {
            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM students";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("department"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Error listing students: " + e.getMessage());
        }
        return list;
    }
}
