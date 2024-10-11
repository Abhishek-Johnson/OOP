/*
#Author: Abhishek Johnson
#Roll_no: 2
#Title: Displaying Institutions of National Importance 
#Start_date: 10/07/2024
#Modified_date: 10/10/2024
#Description: This code uses a csv file for inputing the details of institues and converts them into an array of objects
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestEducationalInstitute {

    private static List<EducationalInstitute> institutes = new ArrayList<>();

    public static void main(String[] args) {
        loadInstitutesFromCSV("data/finalData.csv");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Display all institutes");
            System.out.println("2. Search institute by name");
            System.out.println("3. Search institute by city or state");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllInstitutes();
                    break;
                case 2:
                    System.out.print("Enter institute name: ");
                    String name = scanner.nextLine();
                    searchInstituteByName(name);
                    break;
                case 3:
                    System.out.print("Enter city or state: ");
                    String cityOrState = scanner.nextLine();
                    searchInstituteByCityOrState(cityOrState);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }

    private static void loadInstitutesFromCSV(String csvFile) {
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                if (data.length >= 6) {
                    int srNo = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    String city = data[2].trim();
                    String state = data[3].trim();
                    String act = data[4].trim();
                    String ministry = data[5].trim();

                    EducationalInstitute institute = new EducationalInstitute(srNo, name, city, state, act, ministry);
                    institutes.add(institute);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayAllInstitutes() {
        for (EducationalInstitute institute : institutes) {
            System.out.println(institute);
        }
    }

    private static void searchInstituteByName(String name) {
        boolean found = false;
        for (EducationalInstitute institute : institutes) {
            if (institute.instituteName.toLowerCase().contains(name.toLowerCase())) {
                System.out.println();
                System.out.println(institute);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No institutes found with name containing: " + name);
        }
    }

    private static void searchInstituteByCityOrState(String cityOrState) {
        boolean found = false;
        for (EducationalInstitute institute : institutes) {
            if (institute.city.equalsIgnoreCase(cityOrState) || institute.state.equalsIgnoreCase(cityOrState)) {
                System.out.println();
                System.out.println(institute);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No institutes found in city or state: " + cityOrState);
        }
    }
}
