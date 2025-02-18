package org.example;
import java.io.*;
public class ModifyCsv {
    
    public static void main(String[] args) {
        String inputFilePath = "C:\\Week5Day1\\src\\main\\java\\org\\example\\employees.csv";
        String outputFilePath = "C:\\Week5Day1\\src\\main\\java\\org\\example\\updated_employees.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line = reader.readLine();
            writer.write(line);
            writer.newLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                    String name = data[0].trim();
                    String department = data[1].trim();
                    double salary = Double.parseDouble(data[2].trim());
                    if (department.equalsIgnoreCase("IT")) {
                        salary *= 1.10;
                    }
                    writer.write(name + "," + department + "," + String.format("%.2f", salary));
                    writer.newLine();
                }
            System.out.println("Updated CSV file created successfully: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}
