package com.example.demo;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo.Classes.Unit;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class ControllerWay {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelWay;

    @FXML
    void initialize() throws Exception {
        Unit unit1 = ControllerTree.getChoosedUnit1();
        Unit unit2 = ControllerTree.getChoosedUnit2();
if(unit1.getStatus().equals(Boolean.TRUE)&&(unit2.getStatus().equals(Boolean.TRUE))) {
    if (unit1.equals(unit2)) {
        labelWay.setText("Choose two different units");

    } else if ((unit1.getSwitches().getMainSwitch() == null) && (unit2.getSwitches().getMainSwitch() == null)) {
        if (unit1.getSwitches().equals(unit2.getSwitches())) {
            labelWay.setText(unit1 + "\n" + unit1.getSwitches() + "\n" + unit2);
        } else if (unit1.getSwitches().getNetwork().equals(unit2.getSwitches().getNetwork())) {
            labelWay.setText(unit1 + "\n" + (unit1.getSwitches()) + "\n" + (unit1.getSwitches().getNetwork()) + "\n" + (unit2.getSwitches()) + "\n" + unit2);
        } else if (unit1.getSwitches().getNetwork().getRouter().equals(unit2.getSwitches().getNetwork().getRouter())) {
            labelWay.setText(unit1 + "\n" + (unit1.getSwitches()) + "\n" + (unit1.getSwitches().getNetwork()) + "\n" + (unit1.getSwitches().getNetwork().getRouter()) + "\n" + (unit2.getSwitches().getNetwork()) + "\n" + (unit2.getSwitches()) + "\n" + unit2);
        } else {
            labelWay.setText(unit1 + "\n" + (unit1.getSwitches()) + "\n" + (unit1.getSwitches().getNetwork()) + "\n" + (unit1.getSwitches().getNetwork().getRouter()) + "\n"+unit1.getSwitches().getNetwork().getRouter().getMainRouter()+ "\n" + (unit2.getSwitches().getNetwork().getRouter()) + "\n" + (unit2.getSwitches().getNetwork()) + "\n" + (unit2.getSwitches()) + "\n" + unit2);

        }
    } else if ((unit1.getSwitches().getMainSwitch() == null) && (unit2.getSwitches().getMainSwitch() != null)) {
        if (unit1.getSwitches().equals(unit2.getSwitches().getMainSwitch())) {
            labelWay.setText(unit1 + "\n" + (unit1.getSwitches()) + "\n" + (unit2.getSwitches()) + "\n" + unit2);
        } else if (unit1.getSwitches().getNetwork().equals(unit2.getSwitches().getNetwork())) {
            labelWay.setText(unit1 + "\n" + (unit1.getSwitches()) + "\n" + (unit1.getSwitches().getNetwork()) + "\n" + (unit2.getSwitches().getMainSwitch()) + "\n" + (unit2.getSwitches()) + "\n" + unit2);
        } else if (unit1.getSwitches().getNetwork().getRouter().equals(unit2.getSwitches().getNetwork().getRouter())) {
            labelWay.setText(unit1 + "\n" + (unit1.getSwitches()) + "\n" + (unit1.getSwitches().getNetwork()) + "\n" + (unit1.getSwitches().getNetwork().getRouter()) + "\n" + (unit2.getSwitches().getNetwork()) + "\n" + (unit2.getSwitches().getMainSwitch()) + "\n" + (unit2.getSwitches()) + "\n" + unit2);
        } else {
            labelWay.setText(unit1 + "\n" + (unit1.getSwitches()) + "\n" + (unit1.getSwitches().getNetwork()) + "\n" + (unit1.getSwitches().getNetwork().getRouter()) + "\n"+unit1.getSwitches().getNetwork().getRouter().getMainRouter()+ "\n" + (unit2.getSwitches().getNetwork().getRouter()) + "\n" + (unit2.getSwitches().getNetwork()) + "\n" + (unit2.getSwitches().getMainSwitch()) + "\n" + (unit2.getSwitches()) + "\n" + unit2);

        }
    } else if ((unit1.getSwitches().getMainSwitch() != null) && (unit2.getSwitches().getMainSwitch() == null)) {
        if (unit1.getSwitches().getMainSwitch().equals(unit2.getSwitches())) {
            labelWay.setText(unit1 + "\n" + unit1.getSwitches() + "\n" + unit2.getSwitches() + "\n" + unit2);
        } else if (unit1.getSwitches().getNetwork().equals(unit2.getSwitches().getNetwork())) {
            labelWay.setText(unit1 + "\n" + String.valueOf(unit1.getSwitches()) + "\n" + String.valueOf(unit1.getSwitches().getMainSwitch()) + "\n" + String.valueOf(unit1.getSwitches().getNetwork()) + "\n" + unit2);
        } else if (unit1.getSwitches().getNetwork().getRouter().equals(unit2.getSwitches().getNetwork().getRouter())) {
            labelWay.setText(unit1 + "\n" + String.valueOf(unit1.getSwitches()) + "\n" + String.valueOf(unit1.getSwitches().getMainSwitch()) + "\n" + String.valueOf(unit1.getSwitches().getNetwork()) + "\n" + String.valueOf(unit1.getSwitches().getNetwork().getRouter()) + "\n" + String.valueOf(unit2.getSwitches().getNetwork()) + "\n" + String.valueOf(unit2.getSwitches()) + "\n" + unit2);
        } else {
            labelWay.setText(unit1 + "\n" + String.valueOf(unit1.getSwitches()) + "\n" + String.valueOf(unit1.getSwitches().getMainSwitch()) + "\n" + String.valueOf(unit1.getSwitches().getNetwork()) + "\n" + String.valueOf(unit1.getSwitches().getNetwork().getRouter()) + "\n"+unit1.getSwitches().getNetwork().getRouter().getMainRouter()+ "\n" + String.valueOf(unit2.getSwitches().getNetwork().getRouter()) + "\n" + String.valueOf(unit2.getSwitches().getNetwork()) + "\n" + String.valueOf(unit2.getSwitches()) + "\n" + unit2);

        }
    } else if ((unit1.getSwitches().getMainSwitch() != null) && (unit2.getSwitches().getMainSwitch() != null)) {
        if (unit1.getSwitches().equals(unit2.getSwitches())) {
            labelWay.setText(String.valueOf(unit1 + "\n" + unit2.getSwitches()) + "\n" + unit2);
        } else if (unit1.getSwitches().getMainSwitch().equals(unit2.getSwitches().getMainSwitch())) {
            labelWay.setText(unit1 + "\n" + String.valueOf(unit1.getSwitches()) + "\n" + String.valueOf(unit1.getSwitches().getMainSwitch()) + String.valueOf(unit2.getSwitches()) + "\n" + unit2);
        } else if (unit1.getSwitches().getNetwork().equals(unit2.getSwitches().getNetwork())) {
            labelWay.setText(unit1 + "\n" + String.valueOf(unit1.getSwitches()) + "\n" + String.valueOf(unit1.getSwitches().getMainSwitch()) + "\n" + String.valueOf(unit1.getSwitches().getNetwork()) + "\n" + String.valueOf(unit2.getSwitches().getMainSwitch()) + "\n" + unit2);
        } else if (unit1.getSwitches().getNetwork().getRouter().equals(unit2.getSwitches().getNetwork().getRouter())) {
            labelWay.setText(unit1 + "\n" + String.valueOf(unit1.getSwitches()) + "\n" + String.valueOf(unit1.getSwitches().getMainSwitch()) + "\n" + String.valueOf(unit1.getSwitches().getNetwork()) + "\n" + String.valueOf(unit1.getSwitches().getNetwork().getRouter()) + "\n" + String.valueOf(unit2.getSwitches().getNetwork()) + "\n" + String.valueOf(unit1.getSwitches().getMainSwitch()) + "\n" + String.valueOf(unit2.getSwitches()) + "\n" + unit2);
        } else {
            labelWay.setText(unit1 + "\n" + String.valueOf(unit1.getSwitches()) + "\n" + String.valueOf(unit1.getSwitches().getMainSwitch()) + "\n" + String.valueOf(unit1.getSwitches().getNetwork()) + "\n" + (unit1.getSwitches().getNetwork().getRouter()) + "\n"+unit1.getSwitches().getNetwork().getRouter().getMainRouter()+"\n" + String.valueOf(unit2.getSwitches().getNetwork().getRouter()) + "\n" + String.valueOf(unit2.getSwitches().getNetwork()) + "\n" + String.valueOf(unit1.getSwitches().getMainSwitch()) + "\n" + String.valueOf(unit2.getSwitches()) + "\n" + unit2);

        }


    }
}
else if(unit1.getStatus().equals(Boolean.FALSE)&&unit2.getStatus().equals(Boolean.FALSE)){
    labelWay.setText(unit1+"\n"+unit2+"\n"+"are sleeping");
}
else if(unit1.getStatus().equals(Boolean.FALSE)&&unit2.getStatus().equals(Boolean.TRUE)){
    labelWay.setText(unit1+"\n"+"is sleeping");
}
else if(unit1.getStatus().equals(Boolean.TRUE)&&unit2.getStatus().equals(Boolean.FALSE)){
    labelWay.setText(unit2+"\n"+"is sleeping");
}
else{
    labelWay.setText("не должно такого быть");
}

}
    }






