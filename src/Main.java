public class Main {
    public static void main(String[] args) {
        ServiceClass service = new ServiceClass();
        while (true) {
            System.out.println("\n=== Student Management Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Show All Students");
            System.out.println("6. Exit");
            int choice = ConsoleInput.getInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    service.addStudent();
                    break;
                case 2:
                    service.searchStudent();
                    break;
                case 3:
                    service.updateStudent();
                    break;
                case 4:
                    service.deleteStudent();
                    break;
                case 5:
                    service.showAllStudents();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
