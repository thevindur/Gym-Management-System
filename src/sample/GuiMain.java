package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GuiMain {
    public static void home(Stage primaryStage){
        Pane root = new Pane();

        Button start = new Button("View Gym Members");
        start.setId("Button");
        start.setLayoutX(125);
        start.setLayoutY(550);
        root.getChildren().add(start);
        start.setOnAction(event -> {
            Stage stage = (Stage) start.getScene().getWindow();
            stage.close();
            GuiGymViewMembers.viewMembers(primaryStage, MyGymManager.memberList);
        });

        Button start2 = new Button("Search Gym Members");
        start2.setId("Button");
        start2.setLayoutX(125);
        start2.setLayoutY(640);
        root.getChildren().add(start2);
        start2.setOnAction(event -> {
            Stage stage = (Stage) start.getScene().getWindow();
            stage.close();
            GuiGymSearchMembers.searchMembers(primaryStage);
        });

        Button help = new Button("How to Use");
        help.setId("Button");
        help.setLayoutX(125);
        help.setLayoutY(730);
        root.getChildren().add(help);
        help.setOnAction(event -> {
            Stage stage = (Stage) help.getScene().getWindow();
            stage.close();
            GuiGymHelp.GymHowToUse(primaryStage);
        });

        Button quit = new Button("Quit");
        quit.setId("Button");
        quit.setLayoutX(125);
        quit.setLayoutY(820);
        root.getChildren().add(quit);
        quit.setOnAction(event -> {
            Stage stage = (Stage) quit.getScene().getWindow();
            stage.close();
        });

        primaryStage.setTitle("Gym Management System Home");
        root.setId("pane");
        Scene scene = new Scene(root, 520, 900);
        scene.getStylesheets().add(Main.class.getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
