/*
#Author: Abhishek Johnson
#Roll_no: 2
#Title: Displaying Institutions of National Importance
#Start_date: 24/07/2024
#Modified_date: 25/07/2024
#Description: This code uses a csv file for inputing the details of institues and converts them into an array of objects
*/

#include <iostream>
#include <string>
using namespace std;

class EducationalInstitute
{
public:
    int srNo;
    string instituteName;
    string city;
    string state;
    string act;
    string ministry;

    EducationalInstitute(int srNo, string instituteName, string city, string state, string act, string ministry)
        : srNo(srNo), instituteName(instituteName), city(city), state(state), act(act), ministry(ministry)
    {
    }

    void toString()
    {
        cout << "Sr.No.:\t\t\t\t " << srNo << "\n"
             << "Name of Institute:\t " << instituteName << "\n"
             << "City:\t\t\t\t " << city << "\n"
             << "State:\t\t\t\t " << state << "\n"
             << "Act:\t\t\t\t " << act << "\n"
             << "Ministry:\t\t\t " << ministry << "\n\n";
    }
};

int main()
{
    EducationalInstitute i1(96, "Indian Institute of Technology Goa", "Farmagudi", "Goa", "Institutes of Technology Act 1961 and its subsequent amendments", "Ministry of Education");
    i1.toString();

    return 0;
}
