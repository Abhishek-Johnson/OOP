/**
 * Represents an Educational Institute.
 * Contains information about the institute such as name, city, state, act, and
 * ministry.
 * This code uses a CSV file for inputting the details of institutes and
 * converts them into an array of objects.
 * 
 * @author Abhishek Johnson
 * @roll_no 2
 * @title Displaying Institutions of National Importance
 * @start_date 10/07/2024
 * @modified_date 10/10/2024
 */

public class EducationalInstitute {
    public int srNo;
    public String instituteName, city, state, act, ministry;

    /**
     * Constructor to initialize an EducationalInstitute object.
     * 
     * @param srNo          Serial number of the institute.
     * @param instituteName Name of the institute.
     * @param city          City where the institute is located.
     * @param state         State where the institute is located.
     * @param act           The act under which the institute is established.
     * @param ministry      Ministry overseeing the institute.
     */

    public EducationalInstitute(int srNo, String instituteName, String city, String state, String act, String ministry) {
        this.srNo = srNo;
        this.instituteName = instituteName;
        this.state = state;
        this.city = city;
        this.act = act;
        this.ministry = ministry;
    }

    /**
     * Provides a string representation of the institute details.
     * 
     * @return String containing formatted details of the institute.
     */

    @Override
    public String toString() {
        return "Sr.No. = " + srNo + "\n" +
                "Name of Institute = " + instituteName + ".\n" +
                "City = " + city + ".\n" +
                "State = " + state + ".\n" +
                "Act = " + act + ".\n" +
                "Ministry = " + ministry + ".\n";
    }
}