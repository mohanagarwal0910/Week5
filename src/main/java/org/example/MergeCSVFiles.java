package org.example;
import java.io.*;
import java.util.*;

class Students {
    int id;
    String name;
    int age;
    int marks;
    String grade;
    public Students(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = -1;
        this.grade = "N/A";
    }
    public void updateMarks(int marks, String grade) {
        this.marks = marks;
        this.grade = grade;
    }
    public String toCSV() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}
public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "C:\\Week5Day1\\src\\main\\java\\org\\example\\students1.csv";
        String file2 = "C:\\Week5Day1\\src\\main\\java\\org\\example\\students2.csv";
        String outputFile = "C:\\Week5Day1\\src\\main\\java\\org\\example\\merged_students.csv";
        Map<Integer, Students> studentMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;

                // Skip header row
                if (lineNumber == 1) continue;

                String[] values = line.split(",");

                if (values.length < 3) {
                    System.out.println("Skipping invalid row in students1.csv at line " + lineNumber);
                    continue;
                }

                int id = Integer.parseInt(values[0].trim());
                String name = values[1].trim();
                int age = Integer.parseInt(values[2].trim());

                studentMap.put(id, new Students(id, name, age));
            }
        } catch (IOException e) {
            System.err.println("Error reading file1: " + e.getMessage());
        }

        // Read students2.csv (ID, Marks, Grade)
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;

                // Skip header row
                if (lineNumber == 1) continue;

                String[] values = line.split(",");

                if (values.length < 3) {
                    System.out.println("Skipping invalid row in students2.csv at line " + lineNumber);
                    continue;
                }

                int id = Integer.parseInt(values[0].trim());
                int marks = Integer.parseInt(values[1].trim());
                String grade = values[2].trim();

                if (studentMap.containsKey(id)) {
                    studentMap.get(id).updateMarks(marks, grade);
                } else {
                    System.out.println("Warning: ID " + id + " found in students2.csv but not in students1.csv");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file2: " + e.getMessage());
        }

        // Write merged data to merged_students.csv
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            // Write header
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            for (Students student : studentMap.values()) {
                bw.write(student.toCSV());
                bw.newLine();
            }
            System.out.println("Merged CSV file created successfully: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing merged file: " + e.getMessage());
        }
    }
}

