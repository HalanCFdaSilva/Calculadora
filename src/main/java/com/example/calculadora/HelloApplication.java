package com.example.calculadora;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Scene scene = new Scene(group, 320, 240);
        Button butao = new Button();
        butao.setLayoutX(25);
        butao.setLayoutY(25);
        butao.setText("+");
        butao.setOnAction(new EventHandler<ActionEvent>() {
                              @Override
                              public void handle(ActionEvent actionEvent) {
                                  Group groupBotao = new Group();
                                  Scene scene1 = new Scene(groupBotao, 500,300);
                                  Label label = new Label("botão ativado");
                                  groupBotao.getChildren().add(label);
                                  stage.setScene(scene1);
                              }
                          }
        );

        Button buttonTeste = new Button();
        buttonTeste.setText("teste");
        buttonTeste.setMinSize(222,50);

        group.getChildren().addAll(butao,buttonTeste);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}