package sample;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GuiGymSearchMembers {

    private final static MyGymManager manager = new MyGymManager();

    public static void searchMembers(Stage primaryStage){
        Pane root = new Pane();

        Button homeBtn = new Button("Home");
        homeBtn.setId("Button1");
        homeBtn.setOnAction(event -> { Stage stage = (Stage) homeBtn.getScene().getWindow(); stage.close(); GuiMain.home(primaryStage);});

        Button ViewMembersBtn = new Button("View Members");
        ViewMembersBtn.setId("Button1");
        ViewMembersBtn.setOnAction(event -> { Stage stage = (Stage) ViewMembersBtn.getScene().getWindow(); stage.close(); GuiGymViewMembers.viewMembers(primaryStage, MyGymManager.memberList);});

        Button SearchBtn = new Button("Search");
        SearchBtn.setId("ButtonSelected");

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

        Label mainHeading = new Label("Search for Members in the Gym");
        mainHeading.setId("MainHeading2");

        Label searchOptionsLbl = new Label("Select Search Option : ");
        searchOptionsLbl.setId("MainLbl");
        ChoiceBox<String> searchOptions = new ChoiceBox<>();
        searchOptions.getItems().addAll("ID","Name","Age","SchoolName");
        searchOptions.setValue("ID");

        HBox leftBar = new HBox();
        leftBar.setSpacing(20);
        leftBar.getChildren().addAll(searchOptionsLbl,searchOptions);

        TextField searchValue = new TextField();
        searchValue.setId("SearchBox");
        Button searchBtn = new Button("Search");
        searchBtn.setId("SearchBtn");

        HBox rightBar = new HBox();
        rightBar.setSpacing(20);
        rightBar.getChildren().addAll(searchValue,searchBtn);

        HBox MainBar = new HBox();
        MainBar.setSpacing(200);
        MainBar.getChildren().addAll(leftBar,rightBar);


        TableView gymMembersList = new TableView();
        TableColumn column1 = new TableColumn<>("ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("ID"));
        column1.setMinWidth(150);
        gymMembersList.getColumns().add(column1);

        TableColumn column2 = new TableColumn<>("Full Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        column2.setMinWidth(150);
        TableColumn column3 = new TableColumn<>("Age");
        column3.setCellValueFactory(new PropertyValueFactory<>("age"));
        column3.setMinWidth(150);
        TableColumn column4 = new TableColumn<>("School Name");
        column4.setCellValueFactory(new PropertyValueFactory<>("schoolName"));
        column4.setMinWidth(150);
        TableColumn column5 = new TableColumn<>("Contact No");
        column5.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        column5.setMinWidth(150);

        gymMembersList.getColumns().addAll(column1,column2,column3,column4,column5);
        gymMembersList.setId("List");

        searchBtn.setOnAction(event -> {
            ArrayList<DefaultMember> arrayList = (ArrayList<DefaultMember>) manager.getGymMemberList();
            for (int i=0; i<arrayList.size(); i++){
                if (searchValue.getText().equalsIgnoreCase(String.valueOf(arrayList.get(i).getGymMemberID()))) {
                    gymMembersList.getItems().add(arrayList.get(i).getGymMemberID());
                }
            }
        });

        VBox content = VBoxBuilder.create()
                .spacing(70.0) //In case you are using HBoxBuilder
                .padding(new Insets(50, 25, 20, 25))
                .children(mainHeading,MainBar,gymMembersList)
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
