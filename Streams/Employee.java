import java.time.LocalDate;
public class Employee {

    private int id;
    private String name;
    private String job;
    private String qualification;
    private LocalDate doj;
    private double salary;
    private String dept;

    public Employee(int id, String name, String job,
                    String qualification, LocalDate doj,
                    double salary, String dept) {

        this.id = id;
        this.name = name;
        this.job = job;
        this.qualification = qualification;
        this.doj = doj;
        this.salary = salary;
        this.dept = dept;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getJob() { return job; }
    public String getQualification() { return qualification; }
    public LocalDate getDoj() { return doj; }
    public double getSalary() { return salary; }
    public String getDept() { return dept; }

    @Override
    public String toString() {
        return name + " | " + dept + " | " + salary;
    }
}