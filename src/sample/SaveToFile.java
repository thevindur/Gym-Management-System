package sample;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveToFile{
    public static void writeToFile(List<DefaultMember> membersList, String fileName) {
            try {
                FileWriter myWriter = new FileWriter(fileName,true);
                for (DefaultMember member : membersList) {
                    myWriter.write("( { Membership No : " + member.getGymMemberID() + " }, " + "{ Name is : " + member.getGymMemberName() + " }, " + "{ Membership Start Date is : " + member.getGymJoiningDate() +  " }, ");
                    if (member instanceof StudentMember) {
                        myWriter.write("{ Student member's School is : " + ((StudentMember) member).getGymMemberSchoolName() + " }, " + "{ Student member's Grade is : "+ ((StudentMember) member).getGymMemberSchoolGrade() +" }, " + "{ Student member's Sport is : "+((StudentMember) member).getGymMemberSport()+" }, " + "{ Membership type is : Student Member } )\n");
                    } else if (member instanceof Over60Members) {
                        myWriter.write("{ Member's Age is : " + ((Over60Members) member).getGymMemberAge() + " }, " + "{ Member's Occupation : " + ((Over60Members) member).getGymMemberOccupation()+" }, " + "{ Membership type is : Over60Member } )\n");
                    }else{
                        myWriter.write("{ Membership type is : Default Member } )\n");
                    }
                }
                myWriter.close();
                System.out.println("Gym Members have been successfully added to the Members.txt File.\n");
            } catch (IOException exception) {
                System.out.println("Error!!");
                exception.printStackTrace();
            }
    }
}