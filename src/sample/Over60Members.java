package sample;

class Over60Members extends DefaultMember{
    private int gymMemberAge;
    private String gymMemberOccupation;

    public Over60Members(int gymMemberID, String gymMemberName, String gymJoiningDate, int gymMemberAge, String gymMemberOccupation) {
        super(gymMemberID, gymMemberName, gymJoiningDate);
        setGymMemberAge(gymMemberAge);
        setGymMemberOccupation(gymMemberOccupation);
        this.gymMemberOccupation = gymMemberOccupation;
    }

    public int getGymMemberAge() {
        return gymMemberAge;
    }

    public void setGymMemberAge(int gymMemberAge) {
        if (gymMemberAge >= 60){
            this.gymMemberAge = gymMemberAge;
        }else{
            throw new IllegalArgumentException("Not a Valid Age for this Membership.");
        }

    }

    public String getGymMemberOccupation() {
        return gymMemberOccupation;
    }

    public void setGymMemberOccupation(String gymMemberOccupation) {
        this.gymMemberOccupation = gymMemberOccupation;
    }
}
