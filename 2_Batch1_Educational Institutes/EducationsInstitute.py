#Author: Abhishek Johnson
#Roll_no: 2
#Title: Displaying Institutions of National Importance 
#Start_date: 10/07/2024
#Modified_date: 10/10/2024
#Description: This code uses a csv file for inputing the details of institues and converts them into an array of objects

import csv

class EducationalInstitute:
    def __init__(self, sr_no, institute_name, city, state, act, ministry):
        self.sr_no = sr_no
        self.institute_name = institute_name
        self.city = city
        self.state = state
        self.act = act
        self.ministry = ministry

    def __str__(self):
        return (f"Sr.No. = {self.sr_no}\n"
                f"Name of Institute = {self.institute_name}.\n"
                f"City = {self.city}.\n"
                f"State = {self.state}.\n"
                f"Act = {self.act}.\n"
                f"Ministry = {self.ministry}.\n")


def load_institutes_from_csv(csv_file):
    institutes = []
    with open(csv_file, mode='r', newline='', encoding='utf-8') as file:
        reader = csv.reader(file)
        for row in reader:
            if len(row) >= 6:
                try:
                    sr_no = int(row[0].strip()) 
                except ValueError:
                    print(f"Skipping row due to invalid serial number: {row[0]}")
                    continue 

                institute_name = row[1].strip()
                city = row[2].strip()
                state = row[3].strip()
                act = row[4].strip()
                ministry = row[5].strip()

                institute = EducationalInstitute(sr_no, institute_name, city, state, act, ministry)
                institutes.append(institute)
    return institutes



def display_all_institutes(institutes):
    for institute in institutes:
        print(institute)


def search_institute_by_name(institutes, name):
    found = False
    for institute in institutes:
        if name.lower() in institute.institute_name.lower():
            print(institute)
            found = True
    if not found:
        print(f"No institutes found with name containing: {name}")


def search_institute_by_city_or_state(institutes, city_or_state):
    found = False
    for institute in institutes:
        if city_or_state.lower() in (institute.city.lower(), institute.state.lower()):
            print(institute)
            found = True
    if not found:
        print(f"No institutes found in city or state: {city_or_state}")


def main():
    institutes = load_institutes_from_csv('data/finalData.csv')

    while True:
        print("Menu:")
        print("1. Display all institutes")
        print("2. Search institute by name")
        print("3. Search institute by city or state")
        print("4. Exit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            display_all_institutes(institutes)
        elif choice == 2:
            name = input("Enter institute name: ")
            search_institute_by_name(institutes, name)
        elif choice == 3:
            city_or_state = input("Enter city or state: ")
            search_institute_by_city_or_state(institutes, city_or_state)
        elif choice == 4:
            print("Exiting...")
            break
        else:
            print("Invalid choice. Please try again.")


if __name__ == "__main__":
    main()
