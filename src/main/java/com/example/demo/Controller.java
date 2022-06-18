package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.demo.Classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {
ArrayList<Routers> array = new ArrayList();
    static String routerNum;
    static String[] arrayMasks;
    public static String[] getArrayMasks(){
        return arrayMasks;
    }
    public static String getRouterNum(){
        return routerNum;
    }

    @FXML
    private ResourceBundle resources;
    @FXML
    private Label lbl;

    @FXML
    private URL location;

    @FXML
    private Button enterMasks;

    @FXML
    private TextField routerField;
    @FXML
    private TextField textMasks;

    @FXML
    void enterMasks(ActionEvent event) throws IOException {
        String stringMask = textMasks.getText();
        arrayMasks = stringMask.split(" ");
        routerNum=routerField.getText();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("viev2.fxml"));
            Scene Scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(Scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void error(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}

