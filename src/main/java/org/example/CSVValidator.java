package org.example;
import java.io.*;
import java.util.regex.*;
public class CSVValidator {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PHONE_REGEX = "^\\d{10}$";
    public static void main(String[] args) {
        String csvFile = "C:\\Week5Day1\\src\\main\\java\\org\\example\\data.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 1) continue;
                String[] values = line.split(",");
                if (values.length < 2) {
                    System.out.println("Line " + lineNumber + ": Invalid row format.");
                    continue;
                }
                String email = values[0].trim();
                String phoneNumber = values[1].trim();
                boolean isValid = true;
                if (!Pattern.matches(EMAIL_REGEX, email)) {
                    System.out.println("Line " + lineNumber + ": Invalid Email - " + email);
                    isValid = false;
                }
                if (!Pattern.matches(PHONE_REGEX, phoneNumber)) {
                    System.out.println("Line " + lineNumber + ": Invalid Phone Number - " + phoneNumber);
                    isValid = false;
                }
                if (isValid) {
                    System.out.println("Line " + lineNumber + ": Valid data - " + email + ", " + phoneNumber);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}


