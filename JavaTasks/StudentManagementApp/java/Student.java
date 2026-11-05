public class Student extends Person {

    private int m1, m2, m3, m4, m5;
    private String grade;

    public Student(int rollNo, String name, int age,
                   int m1, int m2, int m3, int m4, int m5,
                   String grade) {

        super(rollNo, name, age);

        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;
        this.grade = grade;
    }

    public int getM1() {
        return m1;
    }

    public int getM2() {
        return m2;
    }

    public int getM3() {
        return m3;
    }

    public int getM4() {
        return m4;
    }

    public int getM5() {
        return m5;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public void displayDetails() {
        System.out.println("Roll Number: " + getRollNo());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Marks: " + m1 + ", " + m2 + ", "
                + m3 + ", " + m4 + ", " + m5);
        System.out.println("Grade: " + grade);
    }
}