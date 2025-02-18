package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class FilterRecordsCsv {
    public static void main(String[] args) {
        String filePath = "C:\\Week5Day1\\src\\main\\java\\org\\example\\students.csv";
        int count=0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine){
                    firstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String age = data[2];
                //String marks = data[3];
                int marks = Integer.parseInt(data[3]);
               if(marks>80) {
                   System.out.println("----------------------");
                    System.out.println("ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    System.out.println("Marks: " + marks);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
