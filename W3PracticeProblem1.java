class Student {
    String name;
    int marks;
}

public class W3PracticeProblem1 {
    public static void main(String[] args) {

        Student student = new Student();

        student.name = "Divya";
        student.marks = 88;

        System.out.println("Name: " + student.name + " | Marks: " + student.marks);
    }
}