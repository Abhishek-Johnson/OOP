public class EducationalInstitute {
    public int srNo;
    public String instituteName, city, state, act, ministry;

    public EducationalInstitute(int srNo, String instituteName, String city, String state, String act,
            String ministry) {
        this.srNo = srNo;
        this.instituteName = instituteName;
        this.state = state;
        this.city = city;
        this.act = act;
        this.ministry = ministry;
    }

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