package com.example.demo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.demo.Builder.RouterBuilder;
import com.example.demo.Builder.RouterMainBuilder;
import com.example.demo.Classes.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;

public class Controller {
ArrayList<Routers> array = new ArrayList();

    @FXML
    private ResourceBundle resources;
    @FXML
    private Label lbl;

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
    void enterMasks(ActionEvent event){
        RouterBuilder routerBuilder = new RouterBuilder();
        RouterMainBuilder routerMainBuilder = new RouterMainBuilder();
        String stringMask = textMasks.getText();
        String[] arrayMasks = stringMask.split(" ");
        try {
            MainRouter mainRouter = routerMainBuilder.createMainRouter(Integer.valueOf(routerField.getText()), arrayMasks);

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
                    for (Unit unit : network.getMainSwitch().getUnitsList()) {
                        TreeItem<String> lvl0Item = new TreeItem<>(unit.getName() + " " + unit.getId() + " (" + unit.getIp() + ")");
                        lvl4Item.getChildren().add(lvl0Item);
                    }
                    for (Switches switches : network.getMainSwitch().getSwitchesList()) {
                        TreeItem<String> lvl5Item = new TreeItem<>(switches.getName() + " " + switches.getId());
                        lvl4Item.getChildren().add(lvl5Item);
                        for (Unit unit : switches.getUnitsList()) {
                            TreeItem<String> lvl6Item = new TreeItem<>(unit.getName() + " " + unit.getId() + " (" + unit.getIp() + ")");
                            lvl5Item.getChildren().add(lvl6Item);
                        }
                    }
                }
            }
            tree.setRoot(lvl1Item);
        
        MultipleSelectionModel<TreeItem<String>> selectionModel = tree.getSelectionModel();

        selectionModel.selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>(){

            public void changed(ObservableValue<? extends TreeItem<String>> changed,
                                TreeItem<String> oldValue, TreeItem<String> newValue)
            {
                if (newValue.getValue().equals(mainRouter.getName())){
                    String s= new String();
                    for(Routers router: mainRouter.getRouters()){
                        s=s+router.getIp()+"\n";
                    }
                                lbl.setText("Parameters: "+s );}
            }
        });}
        
        catch (Exception e){
            error(e);
        e.printStackTrace();
    }
    }

//

    void error(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}

