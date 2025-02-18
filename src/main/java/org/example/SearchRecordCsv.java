package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class SearchRecordCsv {
    public static void main(String[] args) {
        String filePath = "C:\\Week5Day1\\src\\main\\java\\org\\example\\employees.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine){
                    firstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                String name = data[0].trim();
                String department = data[1].trim();
                String salary = data[2].trim();
                String searchName="Alice Johnson";
                if(name.equalsIgnoreCase(searchName)) {
                    System.out.println("----------------------");
                    System.out.println("Name: " + name);
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
