package org.example;
import java.io.*;
import java.util.*;
public class SortCsv {
    public static void main(String[] args) {
        String fileName = "C:\\Week5Day1\\src\\main\\java\\org\\example\\employees.csv";
        List<String[]> employeeData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;
            String[] header = null;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (firstLine) {
                    header = data;
                    firstLine = false;
                    continue;
                }
                employeeData.add(data);
            }
            
            for (int i = 0; i < employeeData.size(); i++) {
                for (int j = 0; j < employeeData.size() - 1 - i; j++) {
                    try {
                        double salaryA = Double.parseDouble(employeeData.get(j)[2].trim());
                        double salaryB = Double.parseDouble(employeeData.get(j + 1)[2].trim());
                        if (salaryA < salaryB) {
                            String[] temp = employeeData.get(j);
                            employeeData.set(j, employeeData.get(j + 1));
                            employeeData.set(j + 1, temp);
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
            System.out.println("Top 5 Highest-Paid Employees:");
            System.out.println("--------------------------------------");
            System.out.println(String.join(" | ", header));
            for (int i = 0; i < Math.min(5, employeeData.size()); i++) {
                System.out.println(String.join(" | ", employeeData.get(i)));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
