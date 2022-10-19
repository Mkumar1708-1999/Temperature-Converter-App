package com.example.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        System.out.println("main");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        System.out.println("start");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();

    }

    private MenuBar createMenu() {

       Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(actionEvent -> System.out.println("New Menu Item Clicked"));

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");
        quitMenuItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });

        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About us");

        aboutApp.setOnAction(actionEvent -> aboutApp());

        helpMenu.getItems().addAll(aboutApp);


       MenuBar menuBar = new MenuBar();
       menuBar.getMenus().addAll(fileMenu,helpMenu);

       return menuBar;

    }
    public void aboutApp() {

        Alert alertDilog = new Alert(Alert.AlertType.INFORMATION);
        alertDilog.setTitle("My First Desktop Apps");
        alertDilog.setHeaderText("Developed By:- Mayashankar Kumar.");
        alertDilog.setContentText("This is a Temperature converting tool, here is only convert Fahrenheit to Celsius or Celsius to Fahrenheit only. Thank you for visiting us.... ");
        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");
        alertDilog.getButtonTypes().setAll(yesBtn,noBtn);

        Optional<ButtonType> clickedBtn = alertDilog.showAndWait();

        if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn) {
            System.out.println("Yes Button Clicked !");
        }else {
            System.out.println("No Button Clicked !");
        }

    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}
