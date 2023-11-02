package com.example.calculadora;


import com.example.calculadora.botoes.BotaoList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Calculadora extends Application {

    @Override
    public void start(Stage stage) {
        try{

            Pane group = new Pane();
            Scene scene = new Scene(group, 250, 300);
            scene.getStylesheets().add(this.getClass().getResource("properties.css").toExternalForm());



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

        }catch(Exception e){
            System.out.println(e.getMessage());

        }

    }

    public static void main(String[] args) {
        launch();
    }
}
