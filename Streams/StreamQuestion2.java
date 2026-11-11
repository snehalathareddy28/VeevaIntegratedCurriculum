
import java.util.*;

public class StreamQuestion2 {

    static class Employee {
        int id;
        String name;
        String job;
        double salary;

        Employee(int id, String name, String job, double salary) {
            this.id = id;
            this.name = name;
            this.job = job;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }
    }

    // Company class
    static class Company {
        int id;
        String name;
        String location;
        String type;
        List<Employee> employees;

        Company(int id, String name, String location,
                String type, List<Employee> employees) {
            this.id = id;
            this.name = name;
            this.location = location;
            this.type = type;
            this.employees = employees;
        }

        public List<Employee> getEmployees() {
            return employees;
        }
    }

    public static void main(String[] args) {

        // Creating employees
        Employee e1 = new Employee(1, "John", "Java Developer", 90000);
        Employee e2 = new Employee(2, "Priya", "Tester", 60000);
        Employee e3 = new Employee(3, "Arun", "Python Developer", 80000);
        Employee e4 = new Employee(4, "Sneha", "QA Engineer", 70000);

        // Creating companies
        Company c1 = new Company(
                101, "Google", "USA", "IT",
                Arrays.asList(e1, e2)
        );

        Company c2 = new Company(
                102, "Microsoft", "India", "IT",
                Arrays.asList(e3, e4)
        );

        List<Company> companies = Arrays.asList(c1, c2);

        // Get all employee names using flatMap()
        List<String> names = companies.stream()
                .flatMap(company -> company.getEmployees().stream())
                .map(Employee::getName)
                .toList();

        System.out.println(names);
    }
}
