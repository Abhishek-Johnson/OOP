public class EducationalInstitute implements Institute {
    private int srNo;
    private String instituteName, city, state, act, ministry;

    public EducationalInstitute(int srNo, String instituteName, String city, String state, String act, String ministry) {
        this.srNo = srNo;
        this.instituteName = instituteName;
        this.state = state;
        this.city = city;
        this.act = act;
        this.ministry = ministry;
    }

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getMinistry() {
        return ministry;
    }

    public void setMinistry(String ministry) {
        this.ministry = ministry;
    }

    @Override
    public String getDetails() {
        return "Sr.No. = " + srNo + "\n" +
                "Name of Institute = " + instituteName + ".\n" +
                "City = " + city + ".\n" +
                "State = " + state + ".\n" +
                "Act = " + act + ".\n" +
                "Ministry = " + ministry + ".\n";
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
