import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamQuestion1 {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(

                new Employee(1, "Sneha", "Developer", "B.Tech",
                        LocalDate.of(2022, 1, 10), 700000, "Engineering"),

                new Employee(2, "Rahul", "Tester", "B.Tech",
                        LocalDate.of(2021, 5, 12), 500000, "Testing"),

                new Employee(3, "John", "Developer", "M.Tech",
                        LocalDate.of(2020, 3, 15), 900000, "Engineering"),

                new Employee(4, "Priya", "Manager", "MBA",
                        LocalDate.of(2019, 7, 20), 800000, "HR"),

                new Employee(5, "Arun", "Tester", "B.Tech",
                        LocalDate.of(2023, 2, 10), 650000, "Testing"),

                new Employee(6, "Kiran", "Developer", "B.Tech",
                        LocalDate.of(2022, 8, 10), 850000, "Engineering")
        );

        Map<String, Optional<Employee>> result =
                employees.stream()

                        .collect(Collectors.groupingBy(
                                Employee::getDept,

                                Collectors.maxBy(
                                        Comparator.comparing(Employee::getSalary)
                                )
                        ));

        result.forEach((department, employee) ->
                System.out.println(
                        department + " -> " + employee.orElse(null)
                )
        );
    }
}