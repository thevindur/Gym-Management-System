package sample;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class GuiGymViewMembers {

    public static void viewMembers(Stage primaryStage, List<DefaultMember> list){
        Pane root = new Pane();

        Button homeBtn = new Button("Home");
        homeBtn.setId("Button1");
        homeBtn.setOnAction(event -> { Stage stage = (Stage) homeBtn.getScene().getWindow(); stage.close(); GuiMain.home(primaryStage);});

        Button ViewMembersBtn = new Button("View Members");
        ViewMembersBtn.setId("ButtonSelected");

        Button SearchBtn = new Button("Search");
        SearchBtn.setId("Button1");
        SearchBtn.setOnAction(event -> { Stage stage = (Stage) SearchBtn.getScene().getWindow(); stage.close(); GuiGymSearchMembers.searchMembers(primaryStage);});

        Button HelpBtn = new Button("How to Use");
        HelpBtn.setId("Button1");
        HelpBtn.setOnAction(event -> { Stage stage = (Stage) HelpBtn.getScene().getWindow(); stage.close(); GuiGymHelp.GymHowToUse(primaryStage);});

        Button ExitBtn = new Button("Exit");
        ExitBtn.setId("Button1");
        ExitBtn.setOnAction(event -> { Stage stage = (Stage) ExitBtn.getScene().getWindow(); stage.close();});

        VBox menuButtons = VBoxBuilder.create()
                .spacing(75.0) //In case you are using HBoxBuilder
                .padding(new Insets(50, 10, 5, 25))
                .children(homeBtn,ViewMembersBtn,SearchBtn,HelpBtn,ExitBtn)
                .build();
        menuButtons.setId("Menubar");
        menuButtons.setMinSize(200,950);
        menuButtons.setTranslateX(0);
        menuButtons.setTranslateY(0);

        Label mainHeading = new Label("List of Members in the Gym");
        mainHeading.setId("MainHeading1");

        Label lblNoOfMembers = new Label("Number of Memberships Purchased :");
        lblNoOfMembers.setId("MainLbl");
        Label lblNoOfAvailableMembers = new Label("Number of Available Memberships :");
        lblNoOfAvailableMembers.setId("MainLbl");
        Label lblMaxNoOfMembers = new Label("Maximum Number of Memberships :");
        lblMaxNoOfMembers.setId("MainLbl");
        Text txtNoOfMembers = new Text("0");
        txtNoOfMembers.setId("MainLbl");
        Text txtNoOfAvailableMembers = new Text("0");
        txtNoOfAvailableMembers.setId("MainLbl");
        Text textMaxNoOfMembers = new Text("100");
        textMaxNoOfMembers.setId("MainLbl");

        GridPane gridPaneMembers = new GridPane();
        gridPaneMembers.setId("Result");
        gridPaneMembers.setHgap(20);
        gridPaneMembers.setVgap(40);

        gridPaneMembers.add(lblNoOfMembers,0,0);
        gridPaneMembers.add(txtNoOfMembers,1,0);
        gridPaneMembers.add(lblNoOfAvailableMembers,4,0);
        gridPaneMembers.add(txtNoOfAvailableMembers,5,0);
        gridPaneMembers.add(lblMaxNoOfMembers,0,1);
        gridPaneMembers.add(textMaxNoOfMembers,1,1);

        TableView gymMembersList = new TableView();

        TableColumn<Integer, DefaultMember> column1 = new TableColumn<>("ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("ID"));
        column1.setMinWidth(150);

        TableColumn<String, DefaultMember> column2 = new TableColumn<>("Full Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        column2.setMinWidth(150);

        TableColumn<Integer, DefaultMember> column3 = new TableColumn<>("Age");
        column3.setCellValueFactory(new PropertyValueFactory<>("age"));
        column3.setMinWidth(150);

        TableColumn<String, DefaultMember> column4 = new TableColumn<>("School Name");
        column4.setCellValueFactory(new PropertyValueFactory<>("schoolName"));
        column4.setMinWidth(150);

        TableColumn<Integer, DefaultMember> column5 = new TableColumn<>("Contact No");
        column5.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        column5.setMinWidth(150);

        for(DefaultMember defaultMember : list) {
            gymMembersList.getItems().addAll(defaultMember.getGymMemberID(),defaultMember.getGymMemberName(),defaultMember.getGymMemberID(),defaultMember.getGymMemberName(),defaultMember.getGymMemberID());
        }

        gymMembersList.getColumns().addAll(column1,column2,column3,column4,column5);
        gymMembersList.setMaxHeight(700);
        gymMembersList.setId("List");


        VBox content = VBoxBuilder.create()
                .spacing(50.0) //In case you are using HBoxBuilder
                .padding(new Insets(50, 25, 5, 25))
                .children(mainHeading,gridPaneMembers,gymMembersList)
                .build();
        content.setId("Content");
        content.setMinSize(1020,815);
        content.setTranslateX(250);
        content.setTranslateY(50);

        HBox bgImage = new HBox();
        bgImage.setId("BgImage");
        bgImage.setMinSize(1150,950);
        bgImage.setTranslateX(200);
        bgImage.setTranslateY(0);


        primaryStage.setTitle("Gym Management System View Members");
        Scene scene = new Scene(new Group(menuButtons,bgImage,content,root), 1300, 900);
        scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}