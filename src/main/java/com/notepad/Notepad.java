package com.notepad;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Notepad {
    @FXML
    private MenuBar menuBar;
    @FXML
    private TextArea textArea;
    private File saveAsFile;

    public Window getStage() {
        Scene scene = menuBar.getScene();
        return scene.getWindow();
    }

    public void openClicked(Event event) {
        FileChooser fileChooser = new FileChooser();
        Window window = getStage();

        try {
            File openFile = fileChooser.showOpenDialog(window);
            if (openFile != null) {
                String openFilePath = openFile.getPath();
                String openFileContents = Files.readString(Paths.get(openFilePath));
                textArea.setText(openFileContents);
            }
        } catch (IOException e) {
            System.out.println("Could not read file.");
        }
    }

    public void saveAsClicked(Event event) {
        FileChooser fileChooser = new FileChooser();
        Window window = getStage();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Plain Text", "*.txt"));
        fileChooser.setInitialFileName("*.txt");

        saveAsFile = fileChooser.showSaveDialog(window);

        try {
            String textAreaString = textArea.getText();
            if (saveAsFile != null) {
                FileWriter fileWriter = new FileWriter(saveAsFile);
                fileWriter.write(textAreaString);
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveClicked(Event event) {
        try {
            String textAreaString = textArea.getText();
            if (saveAsFile != null) {
                FileWriter fileWriter = new FileWriter(saveAsFile);
                fileWriter.write(textAreaString);
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
