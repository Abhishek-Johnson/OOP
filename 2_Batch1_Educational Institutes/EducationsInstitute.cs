/*
#Author: Abhishek Johnson
#Roll_no: 2
#Title: Displaying Institutions of National Importance 
#Start_date: 24/07/2024
#Modified_date: 25/07/2024
#Description: This code uses a csv file for inputing the details of institues and converts them into an array of objects
*/

using System;

class EducationalInstitute
{
    public int srNo;
    public string instituteName, city, state, act, ministry;
    public EducationalInstitute(int srNo, string instituteName, string city, string state, string act, string ministry)
    {
        this.srNo = srNo;
        this.instituteName = instituteName;
        this.city = city;
        this.state = state;
        this.act = act;
        this.ministry = ministry;
    }
    static void Main(string[] args)
    {
        EducationalInstitute i1 = new EducationalInstitute(96, "Indian Institute of Technology Goa", "Farmagudi", "Goa", "Institutes of Technology Act 1961 and its subsequent amendments", "Ministry of Education");

        Console.WriteLine("Sr.No.:	\t\t\t" + i1.srNo + "\nName of Institute: \t" + i1.instituteName + "\nCity: \t\t\t\t" + i1.city + "\nState:	\t\t\t" + i1.state + "\nAct:	\t\t\t" + i1.act + "\nMinistry: \t\t\t" + i1.ministry);
    }
}