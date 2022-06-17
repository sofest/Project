package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.demo.Builder.RouterBuilder;
import com.example.demo.Builder.RouterMain;
import com.example.demo.Classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

public class Controller {
ArrayList<Routers> array = new ArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TreeView<String> tree;

    @FXML
    private Button enterMasks;

    @FXML
    private TextField routerField;
    @FXML
    private TextField textMasks;

    @FXML
    void enterMasks(ActionEvent event) {

    }

    @FXML
    void initialize() {
        enterMasks.setOnAction(actionEvent -> {

//                Parent root = FXMLLoader.load(getClass().getResource("view2.fxml"));
//                Scene scene = new Scene(root);
//                Stage stage = new Stage();
//                stage.setScene(scene);
//                stage.show();

            RouterBuilder routerBuilder = new RouterBuilder();
            RouterMain routerMain = new RouterMain();
            String stringMask = textMasks.getText();
            String[] arrayMasks = stringMask.split(" ");
            MainRouter mainRouter = routerMain.createMainRouter(Integer.valueOf(routerField.getText()),arrayMasks);
//            ArrayList<Routers> routersArray = mainRouter.getRouters();
            TreeItem<String> lvl1Item = new TreeItem<>(mainRouter.getName());
            lvl1Item.setExpanded(true);
            for(Routers router: mainRouter.getRouters()){
                TreeItem<String> lvl2Item = new TreeItem<>(router.getName()+" "+router.getIp());
                lvl1Item.getChildren().add(lvl2Item);
                for(Network network: router.getNetworkList()){
                    TreeItem<String> lvl3Item = new TreeItem<>(network.getName() +" "+network.getIp());
                    lvl2Item.getChildren().add(lvl3Item);
                    TreeItem<String> lvl4Item = new TreeItem<>(network.getMainSwitch().getName()+" "+ network.getMainSwitch().getId());
                    lvl3Item.getChildren().add(lvl4Item);
                    for(Unit unit: network.getMainSwitch().getUnitsList()){
                        TreeItem<String> lvl0Item = new TreeItem<>(unit.getName()+" "+unit.getIp());
                        lvl4Item.getChildren().add(lvl0Item);
                    }
                    for(Switches switches: network.getMainSwitch().getSwitchesList()){
                        TreeItem<String> lvl5Item = new TreeItem<>(switches.getName()+" "+switches.getId());
                        lvl4Item.getChildren().add(lvl5Item);
                        for(Unit unit: switches.getUnitsList()){
                            TreeItem<String> lvl6Item = new TreeItem<>(unit.getName()+" "+unit.getIp());
                            lvl5Item.getChildren().add(lvl6Item);
                        }
                    }
                }
            }
            tree.setRoot(lvl1Item);

        });}

}

