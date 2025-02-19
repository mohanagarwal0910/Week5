package org.example;
import java.io.*;
import java.util.*;
class Student {
    
    private String name;
    private String email;
    private String phoneNumber;
    public Student(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "Student{Name='" + name + "', Email='" + email + "', Phone='" + phoneNumber + "'}";
    }
}
public class CSVToStudentList {
    public static void main(String[] args) {
        String csvFile = "C:\\Week5Day1\\src\\main\\java\\org\\example\\student.csv";
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 1) continue;
                String[] values = line.split(",");
                if (values.length < 3) {
                    System.out.println("Skipping invalid row at line " + lineNumber);
                    continue;
                }
                String name = values[0].trim();
                String email = values[1].trim();
                String phoneNumber = values[2].trim();
                students.add(new Student(name, email, phoneNumber));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        System.out.println("\nList of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
