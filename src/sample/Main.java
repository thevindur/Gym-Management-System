package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.*;

public class Main extends Application {

    public void start(Stage primaryStage){
        GuiMain.home(primaryStage);
    }

    private final static MyGymManager manager = new MyGymManager();
    private static int count = 0;

    public static void main(String[] args) {
        try{
            try (Scanner userInput = new Scanner(System.in)) {

                int user;

                while (true) {
                    System.out.println("\n************* Welcome to the Gym Management System *************" + "\n\n");
                    System.out.println("Option 1 - Add A New Member to the Gym.");
                    System.out.println("Option 2 - Delete A Member from the Gym.");
                    System.out.println("Option 3 - Print List of Members in the Gym.");
                    System.out.println("Option 4 - Sort the Members in the Gym.");
                    System.out.println("Option 5 - Save values into a File.");
                    System.out.println("Option 6 - Open the Graphical User Interface.");
                    System.out.println("Option 7 - Quit the Program.\n");
                    System.out.print("Select the Option you want and Enter the Number Only : ");
                    user = userInput.nextInt();

                    if (user == 1) {
                        addMember();
                    } else if (user == 2) {
                        deleteMember();
                    } else if (user == 3) {
                        manager.printListOfGymMembers();
                    } else if (user == 4) {
                        manager.sortGymMembers();
                    } else if (user == 5) {
                        List<DefaultMember> memList = manager.getGymMemberList();
                        SaveToFile.writeToFile(memList, "Members.txt");
                    } else if (user == 6) {
                        launch(args);
                    } else if (user == 7) {
                        System.out.println("\n************* Thank You for using the Gym Management System !! *************");
                        System.exit(0);
                    }
                }
            }
        }catch (InputMismatchException exception){
            System.out.println("\nInvalid Input!! Please Enter an Integer.");
        }
    }




    private static void addMember(){
        Scanner userInput = new Scanner(System.in).useDelimiter("\n");
        if (count<100){
            System.out.print("Enter a New Membership ID :\t");
            int membershipNo = userInput.nextInt();
            System.out.print("Enter New Member's Name :\t");
            String membershipName = userInput.next();
            System.out.print("Enter New Member's Weight :\t");
            double memberWeight = userInput.nextDouble();
            System.out.print("Enter New Member's Contact No :\t");
            int contactNo = userInput.nextInt();
            System.out.print("Enter New Member's Joining date :\t");
            String membershipJoinDate = userInput.next();
            System.out.println("\n************* Chooses the Membership Type *************\n");
            System.out.println("Option 1 - Default Member." +
                    "\nOption 2 - Student Member." +
                    "\nOption 3 - Over Sixty Members." +
                    "\nOption 4 - Exit Program");
            System.out.print("\nSelect the Option you want and Enter the Number Only : ");
            int userIn1 = userInput.nextInt();

            DefaultMember member = null;

            switch (userIn1){
                case 1:
                    member = new DefaultMember(membershipNo,membershipName, membershipJoinDate);
                    break;
                case 2:
                    System.out.print("Enter the school name : ");
                    String schoolName = userInput.next();
                    System.out.print("Enter the Grade of the Student :");
                    int schoolGrade = userInput.nextInt();
                    System.out.print("Enter the Sport played by Student :");
                    String sports=userInput.next();
                    member = new StudentMember(membershipNo,membershipName, membershipJoinDate,schoolName,schoolGrade,sports);
                    break;
                case 3:
                    System.out.print("Enter the Age of the Member :");
                    int age = userInput.nextInt();
                    System.out.print("Enter the occupation of the Member :");
                    String occupation = userInput.next();
                    member = new Over60Members(membershipNo,membershipName, membershipJoinDate,age,occupation);
                    break;
                case 4:
                    System.out.println("\n************* Thank You for using the Gym Management System !! *************");
                    System.exit(0);
                default:
                    System.out.println("Please check your inputs");
            }
            manager.addGymMember(member);
            count++;
        }else {
            System.out.println("There are No Memberships Available");
        }
    }
    private static void deleteMember(){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter the membership ID of the member you want deleted : ");
        int deleteGymMember = userInput.nextInt();
        boolean res = manager.deleteGymMember(deleteGymMember);
        if(res){
            count--;
        }
    }

}