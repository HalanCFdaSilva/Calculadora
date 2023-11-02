package com.example.calculadora.botoes;



import javafx.scene.control.Button;
import javafx.scene.control.TextArea;



public class Botao {

    private final Button botao;
    
    public  Botao (String nomeBotao){
        this.botao = new Button();
        this.botao.setText(nomeBotao);
        this.setIdBotao(nomeBotao);

    }
    
    public void setIdBotao(String nomeBotao){

    switch(nomeBotao){
        
        case "+":
            this.getBotao().setId("botaoSoma");
            break;
        case "÷":
            this.getBotao().setId("botaoDivisao");
            break;
        case "x":
            this.getBotao().setId("botaoMultiplicacao");
            break;
        case "-":
            this.getBotao().setId("botaoSubtracao");
            break;
        default:
            this.getBotao().setId("botao" + nomeBotao);
            break;
      }
    }

    public Button getBotao() {
        return this.botao;
    }

    public void posicionarBotao(double posicaoLinha, double posicaoColuna){
        this.botao.setLayoutX(posicaoLinha);
        this.botao.setLayoutY(posicaoColuna);
    }


    public String aoClicar(TextArea textArea){
        if(!this.getBotao().getText().equals("CE")){
            textArea.setText(this.acrescentarNaEquacao( textArea));

        }else {
            textArea.setText("");


        }
 

       return textArea.getText();
    }

    private String acrescentarNaEquacao( TextArea textArea) {
        if ( this.verificaSeEOperador()){

            if (verificaSeOperadorEValido(textArea)){
                if(textArea.getLength() ==0 && this.botao.getText().equals("-")){
                    System.out.println("nova equacao");
                    return textArea.getText() + this.getBotao().getText();

                }
                if (textArea.getLength() != 0){
                    System.out.println("velha equacao");
                    return textArea.getText() + this.getBotao().getText();
                }
            }


           return textArea.getText();
        }
        else {

            return textArea.getText() + this.getBotao().getText();

        }
    }

    private boolean verificaSeEOperador( ) {

        return this.getBotao().getText().equals("+") || this.getBotao().getText().equals("-") ||
                this.getBotao().getText().equals("x") || this.getBotao().getText().equals("÷");

    }
    private boolean verificaSeOperadorEValido(TextArea textArea){
            if (textArea.getText().endsWith("+") || textArea.getText().endsWith("-") ||
                    textArea.getText().endsWith("x") || textArea.getText().endsWith("÷")) {
                System.out.println("passou2");
                return this.getBotao().getText().equals("-") && !textArea.getText().endsWith("-");
            }
        return true;
    }




}

