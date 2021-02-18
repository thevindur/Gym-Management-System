package sample;
import java.util.List;

public interface GymManager {
    void addGymMember(DefaultMember member);
    boolean deleteGymMember(int membershipNo);
    void printListOfGymMembers();
    void sortGymMembers();
    void saveGymMembers();
    List<DefaultMember> getGymMemberList();
}
