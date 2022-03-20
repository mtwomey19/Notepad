package com.notepad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class NotepadMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        URL notepadSceneLocation;
        notepadSceneLocation = NotepadMain.class.getResource("/fxml/Notepad.fxml");
        FXMLLoader loader = new FXMLLoader(notepadSceneLocation);
        Parent root = loader.load();
        Scene notepadScene = new Scene(root);

        primaryStage.setScene(notepadScene);
        primaryStage.setTitle("Notepad");
        primaryStage.show();
    }
}
