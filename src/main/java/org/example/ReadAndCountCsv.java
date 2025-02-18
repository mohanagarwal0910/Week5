package org.example;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
public class ReadAndCountCsv {
    public static void main(String[] args) {
        String filePath = "C:\\Week5Day1\\src\\main\\java\\org\\example\\students.csv";
        int count=0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0].trim();
                String name = data[1].trim();
                String age = data[2].trim();
                String marks = data[3].trim();
                System.out.println("----------------------");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Marks: " + marks);
                count++;
            }
        } catch (
                IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        System.out.println("The number of records is :"+ (count-1));
    }
}

