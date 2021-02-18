package sample;

class StudentMember extends DefaultMember{
    private final String gymMemberSchoolName;
    private final int gymMemberSchoolGrade;
    private final String gymMemberSport;

    public StudentMember(int gymMemberID, String gymMemberName, String gymJoiningDate, String gymMemberSchoolName, int gymMemberSchoolGrade, String gymMemberSport) {
        super(gymMemberID, gymMemberName, gymJoiningDate);
        this.gymMemberSchoolName = gymMemberSchoolName;
        this.gymMemberSchoolGrade = gymMemberSchoolGrade;
        this.gymMemberSport = gymMemberSport;
    }

    public String getGymMemberSchoolName() {
        return gymMemberSchoolName;
    }

    public int getGymMemberSchoolGrade() {
        return gymMemberSchoolGrade;
    }

    public String getGymMemberSport() {
        return gymMemberSport;
    }

}
