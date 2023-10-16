package com.example.calculadora.Botoes;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class BotaoList {
    private ArrayList<Botao> botoes;
    Resultado resultado;

    public BotaoList() {
        this.botoes = new ArrayList<>();

        Botao botaoSoma = new Botao("+");
        botaoSoma.posicionarBotao(25,50);
        botoes.add(botaoSoma);

        Botao botaoSubtracao = new Botao("-");
        botaoSubtracao.posicionarBotao(50,50);
        botoes.add(botaoSubtracao);

        Botao botaoMultiplicacao = new Botao("x");
        botaoMultiplicacao.posicionarBotao(75,50);
        botoes.add(botaoMultiplicacao);

        Botao botaoDivisao = new Botao("÷");
        botaoDivisao.posicionarBotao(100,50);
        botoes.add(botaoDivisao);


        Botao botaoSolucao = new Botao("=");
        botaoSolucao.posicionarBotao(125,50);
        botoes.add(botaoSolucao);


        Botao botaoUm = new Botao("1");
        botaoUm.posicionarBotao(50,150);
        botoes.add(botaoUm);


        Botao botaoDois = new Botao("2");
        botaoDois.posicionarBotao(75,150);
        botoes.add(botaoDois);


        Botao botaoTres = new Botao("3");
        botaoTres.posicionarBotao(100,150);
        botoes.add(botaoTres);


        Botao botaoQuatro = new Botao("4");
        botaoQuatro.posicionarBotao(125,150);
        botoes.add(botaoQuatro);


        Botao botaoCinco = new Botao("5");
        botaoCinco.posicionarBotao(25,100);
        botoes.add(botaoCinco);

        Botao botaoSeis = new Botao("6");
        botaoSeis.posicionarBotao(50,100);
        botoes.add(botaoSeis);

        Botao botaoSete = new Botao("7");
        botaoSete.posicionarBotao(75,100);
        botoes.add(botaoSete);

        Botao botaoOito = new Botao("8");
        botaoOito.posicionarBotao(100,100);
        botoes.add(botaoOito);

        Botao botaoNove = new Botao("9");
        botaoNove.posicionarBotao(125,100);
        botoes.add(botaoNove);

        Botao botaoZero = new Botao("0");
        botaoZero.posicionarBotao(25,150);
        botoes.add(botaoZero);

        this.resultado = new Resultado();

    }

    public List<Botao> getBotoes() {
        return botoes;
    }

    public String aoClicarEmUmBotao(TextField textArea){

       this.botoes.forEach(botao ->
               botao.getBotao().setOnAction(actionEvent -> {

                   if(botao.getBotao().getText() != "="){
                       textArea.setText(this.acrescentarNaEquacao(botao, textArea));

                   }else {
                       String equacao = textArea.getText();
                       resultado.pegaNumeros(equacao);
                       resultado.calcular();
                       textArea.setText("");


                   }

               }

               ));
       return textArea.getText();
    }

    private String acrescentarNaEquacao(Botao botao, TextField textArea) {
        if ( this.verificaSeEOperador(botao, textArea)){
            System.out.println("botao clicado");
            String textoNovo = textArea.getText() + botao.getBotao().getText();
            return textoNovo;
        }
        else {
            System.out.println("botao clicado");
            String textoNovo = textArea.getText() + botao.getBotao().getText();
            return textoNovo;
        }
    }

    private boolean verificaSeEOperador(Botao botao, TextField textArea) {

        if(botao.getBotao().getText().equals("+") || botao.getBotao().getText().equals("-") ||
                botao.getBotao().getText().equals("x") || botao.getBotao().getText().equals("÷")){
            return this.verificaSeOperadorEValido(textArea, botao);
        }
        return false;
    }
    private boolean verificaSeOperadorEValido(TextField textArea , Botao botao){
        if (textArea.getText().length() != 0 || botao.getBotao().getText().equals("-")) {
            if (!(textArea.getText().endsWith("+") || textArea.getText().endsWith("-") ||
                    textArea.getText().endsWith("x") || textArea.getText().endsWith("÷"))) {
                return true;
            }
        }
        return false;
    }


}
