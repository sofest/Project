package com.example.demo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.demo.Builder.RouterMainBuilder;
import com.example.demo.Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerTree {
    public static Unit choosedUnit1;
    public static Unit choosedUnit2;
    public static Unit getChoosedUnit1(){return choosedUnit1;}
    public static Unit getChoosedUnit2(){return choosedUnit2;}


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Unit> chooseUnit1;

    @FXML
    private ComboBox<Unit> chooseUnit2;

    @FXML
    private Button genWayButton;

    @FXML
    private TreeView<String> tree;

    @FXML
    void initialize() {
        ArrayList<Unit> unitsList = new ArrayList<>();
        RouterMainBuilder routerMainBuilder = new RouterMainBuilder();
        try {
            MainRouter mainRouter = routerMainBuilder.createMainRouter(Integer.valueOf(Controller.getRouterNum()), Controller.getArrayMasks());

//            ArrayList<Routers> routersArray = mainRouter.getRouters();
            TreeItem<String> lvl1Item = new TreeItem<>(mainRouter.getName());
            lvl1Item.setExpanded(true);
            for (Routers router : mainRouter.getRouters()) {
                TreeItem<String> lvl2Item = new TreeItem<>(router.getName() + " " + router.getId() + " (" + router.getIp() + ")");
                lvl1Item.getChildren().add(lvl2Item);
                for (Network network : router.getNetworkList()) {
                    TreeItem<String> lvl3Item = new TreeItem<>(network.getName() + " (" + network.getIp() + ")");
                    lvl2Item.getChildren().add(lvl3Item);
                    TreeItem<String> lvl4Item = new TreeItem<>(network.getMainSwitch().getName() + " " + network.getMainSwitch().getId());
                    lvl3Item.getChildren().add(lvl4Item);
                    int i = 1;
                    for (Unit unit : network.getMainSwitch().getUnitsList()) {
                        TreeItem<String> lvl0Item = new TreeItem<>(unit.getName() + i + " " + unit.getId() + " (" + unit.getIp() + ")");
                        unitsList.add(unit);
                        lvl4Item.getChildren().add(lvl0Item);
                        i += 1;
                    }
                    for (Switches switches : network.getMainSwitch().getSwitchesList()) {
                        TreeItem<String> lvl5Item = new TreeItem<>(switches.getName() + " " + switches.getId());
                        lvl4Item.getChildren().add(lvl5Item);
                        int j = 1;
                        for (Unit unit : switches.getUnitsList()) {
                            TreeItem<String> lvl6Item = new TreeItem<>(unit.getName() + j + " " + unit.getId() + " (" + unit.getIp() + ")");
                            unitsList.add(unit);
                            lvl5Item.getChildren().add(lvl6Item);
                            j += 1;
                        }
                    }
                }
            }
            tree.setRoot(lvl1Item);
            genCombobox(unitsList);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void genCombobox(ArrayList<Unit> unitsList) {
        ObservableList<Unit> langs = FXCollections.observableArrayList(unitsList);
        chooseUnit1.setItems(langs);
        chooseUnit1.setValue(langs.get(0));
        chooseUnit2.setItems(langs);
        chooseUnit2.setValue(langs.get(0));
    }
    @FXML
    void generateWay(ActionEvent event) {
        choosedUnit1=chooseUnit1.getValue();
        choosedUnit2=chooseUnit2.getValue();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("view3.fxml"));
            Scene Scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(Scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}




