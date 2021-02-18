package sample;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GuiGymHelp {
    public static void GymHowToUse(Stage primaryStage){
        Pane root = new Pane();

        Button homeBtn = new Button("Home");
        homeBtn.setId("Button1");
        homeBtn.setOnAction(event -> { Stage stage = (Stage) homeBtn.getScene().getWindow(); stage.close(); GuiMain.home(primaryStage);});

        Button ViewMembersBtn = new Button("View Members");
        ViewMembersBtn.setId("Button1");
        ViewMembersBtn.setOnAction(event -> { Stage stage = (Stage) ViewMembersBtn.getScene().getWindow(); stage.close(); GuiGymViewMembers.viewMembers(primaryStage,MyGymManager.memberList);});

        Button SearchBtn = new Button("Search");
        SearchBtn.setId("Button1");
        SearchBtn.setOnAction(event -> { Stage stage = (Stage) SearchBtn.getScene().getWindow(); stage.close(); GuiGymSearchMembers.searchMembers(primaryStage);});

        Button HelpBtn = new Button("How to Use");
        HelpBtn.setId("ButtonSelected");

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

        Label mainHeading = new Label("How to use the Gym Management System");
        mainHeading.setId("MainHeading3");





        HBox content = HBoxBuilder.create()
                .spacing(75.0) //In case you are using HBoxBuilder
                .padding(new Insets(50, 10, 5, 25))
                .children(mainHeading)
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