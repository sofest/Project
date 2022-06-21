package com.example.demo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

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
    public static Unit choosedUnit3;
    public static Unit getChoosedUnit1(){return choosedUnit1;}
    public static Unit getChoosedUnit2(){return choosedUnit2;}
    RouterMainBuilder routerMainBuilder = new RouterMainBuilder();
    MainRouter mainRouter = routerMainBuilder.createMainRouter(Integer.valueOf(Controller.getRouterNum()), Controller.getArrayMasks());


    ArrayList<Network> networksList = new ArrayList<>();
    ArrayList<Unit> unitsList = new ArrayList<>();

    @FXML
    private Label labelInfo;


    @FXML
    private TextField textIP;

    @FXML
    private ComboBox<Unit> chooseUnit1;

    @FXML
    private ComboBox<Unit> chooseUnit2;

    @FXML
    private ComboBox<Unit> chooseUnit3;

    @FXML
    private TreeView<String> tree;

    @FXML
    void initialize() {
        try {
            TreeItem<String> lvl1Item = new TreeItem<>(mainRouter.getName()+" ("+mainRouter.getIp()+")");
            lvl1Item.setExpanded(true);
            for (Routers router : mainRouter.getRouters()) {
                TreeItem<String> lvl2Item = new TreeItem<>(router.getName() + " " + router.getId()+" ("+router.getIp()+")");
                lvl1Item.getChildren().add(lvl2Item);
                for (Network network : router.getNetworkList()) {
                    networksList.add(network);
                    TreeItem<String> lvl3Item = new TreeItem<>(network.getName() + " (" + network.getIp() + ")");
                    lvl2Item.getChildren().add(lvl3Item);
                    TreeItem<String> lvl4Item = new TreeItem<>(network.getMainSwitch().getName() + " " + network.getMainSwitch().getId());
                    lvl3Item.getChildren().add(lvl4Item);
                    int i = 1;
                    for (Unit unit : network.getMainSwitch().getUnitsList()) {
                        if(unit.getStatus().equals(Boolean.FALSE)) {
                            TreeItem<String> lvl0Item = new TreeItem<>(unit.getName() + i + " " + unit.getId() + " (" + unit.getIp() + ")"+" zZz");
                            unitsList.add(unit);
                            lvl4Item.getChildren().add(lvl0Item);
                            i += 1;
                        }
                        else{
                            TreeItem<String> lvl0Item = new TreeItem<>(unit.getName() + i + " " + unit.getId() + " (" + unit.getIp() + ")");
                            unitsList.add(unit);
                            lvl4Item.getChildren().add(lvl0Item);
                            i += 1;
                        }
                    }
                    for (Switches switches : network.getMainSwitch().getSwitchesList()) {
                        TreeItem<String> lvl5Item = new TreeItem<>(switches.getName() + " " + switches.getId());
                        lvl4Item.getChildren().add(lvl5Item);
                        int j = 1;
                        for (Unit unit : switches.getUnitsList()) {
                            if(unit.getStatus().equals(Boolean.FALSE)) {
                                TreeItem<String> lvl6Item = new TreeItem<>(unit.getName() + j + " " + unit.getId() + " (" + unit.getIp() + ")"+" zZz");
                                unitsList.add(unit);
                                lvl5Item.getChildren().add(lvl6Item);
                                j += 1;
                            }
                            else{
                                TreeItem<String> lvl6Item = new TreeItem<>(unit.getName() + j + " " + unit.getId() + " (" + unit.getIp() + ")");
                                unitsList.add(unit);
                                lvl5Item.getChildren().add(lvl6Item);
                                j += 1;
                            }
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
        chooseUnit3.setItems(langs);
        chooseUnit3.setValue(langs.get(0));
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
    @FXML
    void changeIPUnit(ActionEvent event) {
        Unit chosedUnit = chooseUnit3.getValue();
        String firstPartIP = chosedUnit.getIp().substring(0,chosedUnit.getIp().lastIndexOf(".")+1);
        try {
            int count=0;
            int sum=0;
            String ourFirstPartIP = textIP.getText().substring(0, textIP.getText().lastIndexOf(".")+1);
            Integer ourSecondPartIP = Integer.valueOf(textIP.getText().substring(textIP.getText().lastIndexOf(".")+1, textIP.getText().length()));
            sum+=checkTheFirstPart(firstPartIP,ourFirstPartIP,count);
            sum+=checkThatTheLastIsNumber(ourSecondPartIP,count);
            sum+=checkThereIsNoTheSameIP(textIP.getText(),chosedUnit,count);
            if(sum==0){
                labelInfo.setText("IP was changed");
                chosedUnit.setIp(textIP.getText());
                initialize();
            }
            else{
                labelInfo.setText("Sorry, try another IP");
            }

        }
        catch (Exception e){
            error((e));
            e.printStackTrace();
        }

    }
    public Integer checkTheFirstPart(String firstPartIP, String ourFirstPartIP, Integer count){
        if(firstPartIP.equals(ourFirstPartIP)){
        }
        else{
            count++;
        }
        return count;
    }
    public Integer checkThatTheLastIsNumber(Integer ourSecondPartIP,Integer count){
        if(ourSecondPartIP>=25||ourSecondPartIP==1){
            count++;
        }
        return count;
    }
    public Integer checkThereIsNoTheSameIP(String textIP, Unit chosedUnit,Integer count){
        for(Network network: chosedUnit.getSwitches().getNetwork().getRouter().getNetworkList()){
            if(network.getIp().equals(textIP)){
                count++;
            }
        }
        for(Unit unit: chosedUnit.getSwitches().getNetwork().getUnitsList()){
            if(unit.getIp().equals(textIP)){
                count++;
            }
        }
        return count;
    }


    void error(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("It's not the IP, try again");
        alert.showAndWait();
    }
    @FXML
    void changeStatusUnit() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, unitsList.size());
        for (int i = 0; i < randomNum; i++) {

            int indexRandom = ThreadLocalRandom.current().nextInt(0, unitsList.size());
            unitsList.get(indexRandom).setStatus(Boolean.FALSE);
            initialize();

        }
    }
}




