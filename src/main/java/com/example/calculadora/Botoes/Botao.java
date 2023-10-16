package com.example.calculadora.Botoes;



import javafx.scene.control.Button;



public class Botao {

    private Button botao;
    public  Botao (String nomeBotao){
        this.botao = new Button();
        this.botao.setText(nomeBotao);

    }

    public Button getBotao() {
        return this.botao;
    }

    public void posicionarBotao(double posicaoLinha, double posicaoColuna){
        this.botao.setLayoutX(posicaoLinha);
        this.botao.setLayoutY(posicaoColuna);
    }




}

