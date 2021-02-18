package sample;

public class DefaultMember implements Comparable<DefaultMember>{
    private final int gymMemberID;
    private final String gymMemberName;
    private final String gymJoiningDate;

    public DefaultMember(int gymMemberID, String gymMemberName, String gymJoiningDate) {
        super();
        this.gymMemberID = gymMemberID;
        this.gymMemberName = gymMemberName;
        this.gymJoiningDate = gymJoiningDate;
    }

    public int getGymMemberID() {
        return gymMemberID;
    }

    public String getGymMemberName() {
        return gymMemberName;
    }

    public String getGymJoiningDate() {
        return gymJoiningDate;
    }

    @Override
    public int compareTo(DefaultMember o) {
        return this.gymMemberName.compareTo(o.gymMemberName);
    }
}