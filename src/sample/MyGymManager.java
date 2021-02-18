package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyGymManager implements GymManager{

    public static List<DefaultMember> memberList = new ArrayList<>();

    @Override
    public void addGymMember(DefaultMember member) {
        System.out.println("Add A New Member to the Gym.");
        if(memberList.size() < 100){
            memberList.add(member);
        }else{
            System.out.println("There are no New Memberships Available");
        }
        System.out.println("Number of Members Enrolled in the Gym Currently : " + memberList.size());
        System.out.println("Number of New Memberships Available : " + (100 - memberList.size()));
    }

    @Override
    public boolean deleteGymMember(int membershipNo) {
        boolean flag = false;
        for(DefaultMember member:memberList){
            if (Objects.equals(member.getGymMemberID(), membershipNo)){
                flag = true;
                memberList.remove(member);
                System.out.println("Member with the Membership ID "+membershipNo+" has been removed.");
                System.out.println("Number of Members Enrolled in the Gym Currently : " + memberList.size());
                System.out.println("Number of New Memberships Available : " + (100 - memberList.size()));
                if (member instanceof StudentMember){
                    System.out.println("Membership type is : Student Member");
                }else if (member instanceof Over60Members){
                    System.out.println("Membership type is : Over60Member");
                }else {
                    System.out.println("Membership type is : Default Member");
                }
                break;
            }
        }
        if (!flag){
            System.out.println("There is no such membership ID. Please Check Again!!");
        }
        return flag;
    }

    @Override
    public void printListOfGymMembers() {
        for(DefaultMember member:memberList){
            System.out.print("( { Membership No : " + member.getGymMemberID()+" }, ");
            System.out.print("{ Name is : "+member.getGymMemberName()+" }, ");
            System.out.print("{ Membership Start Date is : "+member.getGymJoiningDate()+" }, ");
            if (member instanceof StudentMember){
                System.out.print("{ Student member's School is : "+((StudentMember) member).getGymMemberSchoolName()+" }, ");
                System.out.print("{ Student member's Grade is : "+((StudentMember) member).getGymMemberSchoolGrade()+" }, ");
                System.out.println("{ Student member's Sport is : "+((StudentMember) member).getGymMemberSport()+" }, ");
                System.out.println("{ Membership type is : Student Member } )");
            }else if (member instanceof Over60Members){
                System.out.print("{ Member's Age is : "+((Over60Members) member).getGymMemberAge()+" }, ");
                System.out.print("{ Member's Occupation : "+((Over60Members) member).getGymMemberOccupation()+" }, ");
                System.out.println("{ Membership type is : Over60Member } )");
            }else {
                System.out.println("{ Membership type is : Default Member } )");
            }
        }
        if (memberList.size()==0){
            System.out.println("There are no members in the Gym.");
        }
    }

    @Override
    public void sortGymMembers() {
        DefaultMember[] arr = memberList.toArray(new DefaultMember[] {});
        GymMemberSortingList.bubbleSort(arr, true);
        for(DefaultMember member: arr){
            System.out.print("( { Membership No : " + member.getGymMemberID()+" }, ");
            System.out.print("{ Name is : "+member.getGymMemberName()+" }, ");
            System.out.print("{ Membership Start Date is : "+member.getGymJoiningDate()+" }, ");
            if (member instanceof StudentMember){
                System.out.print("{ Student member's School is : "+((StudentMember) member).getGymMemberSchoolName()+" }, ");
                System.out.print("{ Student member's Grade is : "+((StudentMember) member).getGymMemberSchoolGrade()+" }, ");
                System.out.println("{ Student member's Sport is : "+((StudentMember) member).getGymMemberSport()+" }, ");
                System.out.println("{ Membership type is : Student Member } )");
            }else if (member instanceof Over60Members){
                System.out.print("{ Member's Age is : "+((Over60Members) member).getGymMemberAge()+" }, ");
                System.out.print("{ Member's Occupation : "+((Over60Members) member).getGymMemberOccupation()+" }, ");
                System.out.println("{ Membership type is : Over60Member } )");
            }else {
                System.out.println("{ Membership type is : Default Member } )");
            }
        }
    }

    @Override
    public void saveGymMembers() { }

    @Override
    public List<DefaultMember> getGymMemberList() {
        return this.memberList;
    }

}