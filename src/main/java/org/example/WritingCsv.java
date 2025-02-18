package org.example;
import java.io.*;
public class WritingCsv {
    public static void main(String[] args) {
        String filePath = "C:\\Week5Day1\\src\\main\\java\\org\\example\\output.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("104,Alice Williams,Finance,62000\n");
            writer.write("105,Bob Johnson,Sales,58000\n");
            System.out.println("CSV file written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
