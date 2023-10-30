package com.example.calculadora;


import com.example.calculadora.Botoes.BotaoList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;



public class Calculadora extends Application {

    @Override
    public void start(Stage stage) {
        Group group = new Group();
        Scene scene = new Scene(group, 250, 300);
        scene.getStylesheets().add(getClass().
                getResource("properties.css").toExternalForm());


        TextArea textArea = new TextArea();
        textArea.setMaxSize(250,50);
        textArea.setId("texto");

        Label label = new Label();
        label.setLayoutY(200);
        label.setLayoutX(50);




        BotaoList botaoList = new BotaoList();
        textArea.setText(botaoList.aoClicarEmUmBotao(textArea));


        botaoList.getBotoes().forEach(botao -> group.getChildren().add(botao.getBotao()) );
        group.getChildren().add(textArea);
        group.getChildren().add(botaoList.getLabel());
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
