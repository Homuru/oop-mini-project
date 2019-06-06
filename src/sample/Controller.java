package sample;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import javax.swing.*;


public class Controller {

    protected Object ob = new Object();

    @FXML
    protected Circle object;
    @FXML
    protected Rectangle wall;
    @FXML
    protected TextField massInput;
    @FXML
    protected TextField forceInput;
    @FXML
    protected TextField velocityInput;
    @FXML
    protected Label title;
    @FXML
    protected Button start;
    @FXML
    protected MenuButton menuBtn;
    @FXML
    protected TextField timeInput;


    @FXML
    public void initialize() {
        wall.setVisible(false);
        massInput.setDisable(true);
        forceInput.setDisable(true);
        velocityInput.setDisable(true);
        timeInput.setDisable(true);
        start.setDisable(true);
    }

    public void reset() {
        ob.stop();
        object.setTranslateX(0);
    }

    public Law getCase() {
        String s = title.getText();
//        System.out.println(s);
        if (s.equals("First Law")) {
            System.out.println("law 1");
            return new Law1();
        }
        else if (s.equals("Second Law")){
            System.out.println("law 2");
            return new Law2();

        }
        else if (s.equals("Third Law")) {
            System.out.println("law 3");
            return new Law3();
        } else
            return new Law1();
    }

    public void changeLayout(ActionEvent event) {
        String xD = ((MenuItem)event.getSource()).getText();
        this.title.setText(xD);
        System.out.println(xD);
        Law choice = getCase();
//        System.out.println("Im here!");
        choice.changeLayout(this);
    }

    public void start() {
        Law choice = getCase();
        choice.play(this);
    }

}

