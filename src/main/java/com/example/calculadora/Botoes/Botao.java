package com.example.calculadora.Botoes;



import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;



public class Botao {

    private Button botao;
    public  Botao (String nomeBotao){
        this.botao = new Button();
        this.botao.setText(nomeBotao);
        this.botao.setId("botao" + nomeBotao);

    }

    public Button getBotao() {
        return this.botao;
    }

    public void posicionarBotao(double posicaoLinha, double posicaoColuna){
        this.botao.setLayoutX(posicaoLinha);
        this.botao.setLayoutY(posicaoColuna);
    }


    public String aoClicar(TextArea textArea){
        if(this.getBotao().getText() != "CE"){
            textArea.setText(this.acrescentarNaEquacao( textArea));

        }else {
            textArea.setText("");


        }
 

       return textArea.getText();
    }

    private String acrescentarNaEquacao( TextArea textArea) {
        if ( this.verificaSeEOperador( textArea)){

            if (verificaSeOperadorEValido(textArea)){
                if(textArea.getLength() ==0 && this.botao.getText() == "-"){
                    System.out.println("nova equacao");
                    String textoNovo = textArea.getText() + this.getBotao().getText();
                    return textoNovo;
                }
                if (textArea.getLength() != 0){
                    System.out.println("velha equacao");
                    String textoNovo = textArea.getText() + this.getBotao().getText();
                    return textoNovo;
                }
            }

            System.out.println(textArea.getText());

           return textArea.getText();
        }
        else {

            System.out.println("pulou tudo");
            String textoNovo = textArea.getText() + this.getBotao().getText();
            return textoNovo;
        }
    }

    private boolean verificaSeEOperador( TextArea textArea) {

        return this.getBotao().getText().equals("+") || this.getBotao().getText().equals("-") ||
                this.getBotao().getText().equals("x") || this.getBotao().getText().equals("÷");

    }
    private boolean verificaSeOperadorEValido(TextArea textArea){
            if (textArea.getText().endsWith("+") || textArea.getText().endsWith("-") ||
                    textArea.getText().endsWith("x") || textArea.getText().endsWith("÷")) {
                System.out.println("passou2");
                if (this.getBotao().getText() == "-" && !textArea.getText().endsWith("-")){
                    return true;
                }
                return false;
            }
        System.out.println("nao passou");
        return true;
    }




}

