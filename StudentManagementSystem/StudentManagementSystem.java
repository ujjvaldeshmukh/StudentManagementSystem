package StudentManagementSystem;

import java.util.List;

public class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = StudentDataStorage.loadStudents();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
        StudentDataStorage.saveStudents(students);
    }

    public void removeStudent(int rollNumber) {
        boolean removed = students.removeIf(student -> student.getRollNumber() == rollNumber);
        if (removed) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found!");
        }
        StudentDataStorage.saveStudents(students);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void editStudent(int rollNumber, String newName, String newGrade) {
        Student student = searchStudent(rollNumber);
        if (student != null) {
            student.setName(newName);
            student.setGrade(newGrade);
            System.out.println("Student details updated successfully!");
            StudentDataStorage.saveStudents(students);
        } else {
            System.out.println("Student not found!");
        }
    }
}