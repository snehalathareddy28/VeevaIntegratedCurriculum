
import java.io.*;
import java.util.*;

public class StudentManagement {

    static Scanner sc = new Scanner(System.in);
    static final String FILE = "Students.csv";

    // Add a student
    static void addRecord() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            if (findStudent(roll) != null) {
                System.out.println("Roll number already exists!");
                return;
            }

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            System.out.print("Enter five subject marks: ");
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int m3 = sc.nextInt();
            int m4 = sc.nextInt();
            int m5 = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Grade: ");
            String grade = sc.nextLine();

            Student student = new Student(
                    roll, name, age, m1, m2, m3, m4, m5, grade
            );

            try (BufferedWriter bw =
                         new BufferedWriter(new FileWriter(FILE, true))) {

                bw.write(toCSV(student));
                bw.newLine();
            }

            System.out.println("Student added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numbers correctly.");
            sc.nextLine();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // Convert Student object into CSV format
    static String toCSV(Student s) {
        return s.getRollNo() + "," + s.getName() + "," + s.getAge()
                + "," + s.getM1() + "," + s.getM2() + ","
                + s.getM3() + "," + s.getM4() + "," + s.getM5()
                + "," + s.getGrade();
    }

    // Read all students
    static void viewAll() {
        File file = new File(FILE);

        if (!file.exists()) {
            System.out.println("No student records found.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                Student s = fromCSV(line);

                if (s != null) {
                    s.displayDetails();
                    System.out.println("------------------------");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No student records found.");
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // Convert CSV row into Student object
    static Student fromCSV(String line) {
        try {
            String[] data = line.split(",", -1);

            if (data.length != 9) {
                return null;
            }

            return new Student(
                    Integer.parseInt(data[0]),
                    data[1],
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3]),
                    Integer.parseInt(data[4]),
                    Integer.parseInt(data[5]),
                    Integer.parseInt(data[6]),
                    Integer.parseInt(data[7]),
                    data[8]
            );

        } catch (NumberFormatException e) {
            System.out.println("Skipping invalid CSV row: " + line);
            return null;
        }
    }

    // Find student by roll number
    static Student findStudent(int roll) {
        File file = new File(FILE);

        if (!file.exists()) {
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                Student s = fromCSV(line);

                if (s != null && s.getRollNo() == roll) {
                    return s;
                }
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        return null;
    }

    // Search by roll number
    static void searchByRoll() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(roll);

        if (s != null) {
            s.displayDetails();
        } else {
            System.out.println("Student not found.");
        }
    }

    // Search by name
    static void searchByName() {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                Student s = fromCSV(line);

                if (s != null && s.getName().equalsIgnoreCase(name)) {
                    s.displayDetails();
                    System.out.println("------------------------");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Student not found.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("No student records found.");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // Update student details
    static void updateRecord() {
        System.out.print("Enter Roll Number to update: ");
        int roll = sc.nextInt();
        sc.nextLine();

        List<Student> students = readStudents();
        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);

            if (s.getRollNo() == roll) {
                System.out.println("Enter updated details:");

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Age: ");
                int age = sc.nextInt();

                System.out.print("Five subject marks: ");
                int m1 = sc.nextInt();
                int m2 = sc.nextInt();
                int m3 = sc.nextInt();
                int m4 = sc.nextInt();
                int m5 = sc.nextInt();
                sc.nextLine();

                System.out.print("Grade: ");
                String grade = sc.nextLine();

                students.set(i, new Student(
                        roll, name, age, m1, m2, m3, m4, m5, grade
                ));

                found = true;
                break;
            }
        }

        if (found) {
            writeStudents(students);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Delete student by roll number
    static void deleteRecord() {
        System.out.print("Enter Roll Number to delete: ");
        int roll = sc.nextInt();
        sc.nextLine();

        List<Student> students = readStudents();

        boolean removed = students.removeIf(
                s -> s.getRollNo() == roll
        );

        if (removed) {
            writeStudents(students);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Read CSV records into a list
    static List<Student> readStudents() {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;

            while ((line = br.readLine()) != null) {
                Student s = fromCSV(line);

                if (s != null) {
                    students.add(s);
                }
            }

        } catch (FileNotFoundException e) {
            // No file means there are currently no records.
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        return students;
    }

    // Rewrite CSV file after update or delete
    static void writeStudents(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {

            for (Student s : students) {
                bw.write(toCSV(s));
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // Main menu
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Roll Number");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addRecord();
                        break;
                    case 2:
                        viewAll();
                        break;
                    case 3:
                        searchByRoll();
                        break;
                    case 4:
                        searchByName();
                        break;
                    case 5:
                        updateRecord();
                        break;
                    case 6:
                        deleteRecord();
                        break;
                    case 7:
                        System.out.println("Exiting Student Management System.");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid menu number.");
                sc.nextLine();
            }
        }
    }
}
