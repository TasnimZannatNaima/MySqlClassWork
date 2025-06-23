import java.util.List;

public class ServiceClass {
        private MyJdbcClass db;

        public ServiceClass() {
                db = new MyJdbcClass();
        }

        public void addStudent() {
                int id = ConsoleInput.getInt("Enter student ID: ");
                String name = ConsoleInput.getString("Enter name: ");
                String dept = ConsoleInput.getString("Enter department: ");
                Student s = new Student(id, name, dept);
                if (db.addStudent(s)) {
                        System.out.println("Student added successfully.");
                } else {
                        System.out.println("Failed to add student.");
                }
        }

        public void searchStudent() {
                int id = ConsoleInput.getInt("Enter student ID to search: ");
                Student s = db.getStudent(id);
                if (s != null) {
                        System.out.println("Found: " + s);
                } else {
                        System.out.println("Student not found.");
                }
        }

        public void updateStudent() {
                int id = ConsoleInput.getInt("Enter student ID to update: ");
                String name = ConsoleInput.getString("Enter new name: ");
                String dept = ConsoleInput.getString("Enter new department: ");
                Student s = new Student(id, name, dept);
                if (db.updateStudent(s)) {
                        System.out.println("Student updated successfully.");
                } else {
                        System.out.println("Failed to update student.");
                }
        }

        public void deleteStudent() {
                int id = ConsoleInput.getInt("Enter student ID to delete: ");
                if (db.deleteStudent(id)) {
                        System.out.println("Student deleted successfully.");
                } else {
                        System.out.println("Failed to delete student.");
                }
        }

        public void showAllStudents() {
                List<Student> list = db.getAllStudents();
                if (list.isEmpty()) {
                        System.out.println("No students found.");
                } else {
                        for (Student s : list) {
                                System.out.println(s);
                        }
                }
        }
}
