package com.example.calculadora.botoes;


import com.example.calculadora.solucao.Resultado;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import java.util.ArrayList;
import java.util.List;

public class BotaoList {
    private final ArrayList<Botao>  botoes;


    Label label;

    public BotaoList() {
        this.botoes = new ArrayList<>();

        Botao botaoSoma = new Botao("+");
        botaoSoma.posicionarBotao(64,80);
        botoes.add(botaoSoma);

        Botao botaoSubtracao = new Botao("-");
        botaoSubtracao.posicionarBotao(128,80);
        botoes.add(botaoSubtracao);

        Botao botaoMultiplicacao = new Botao("x");
        botaoMultiplicacao.posicionarBotao(192,148);
        botoes.add(botaoMultiplicacao);

        Botao botaoDivisao = new Botao("÷");
        botaoDivisao.posicionarBotao(192,80);
        botoes.add(botaoDivisao);


        Botao botaoSolucao = new Botao("=");
        botaoSolucao.posicionarBotao(192,216);
        botaoSolucao.getBotao().setMinHeight(203);
        botoes.add(botaoSolucao);


        Botao botaoUm = new Botao("1");
        botaoUm.posicionarBotao(0,284);
        botoes.add(botaoUm);


        Botao botaoDois = new Botao("2");
        botaoDois.posicionarBotao(64,284);
        botoes.add(botaoDois);


        Botao botaoTres = new Botao("3");
        botaoTres.posicionarBotao(128,284);
        botoes.add(botaoTres);


        Botao botaoQuatro = new Botao("4");
        botaoQuatro.posicionarBotao(0,216);
        botoes.add(botaoQuatro);


        Botao botaoCinco = new Botao("5");
        botaoCinco.posicionarBotao(64,216);
        botoes.add(botaoCinco);

        Botao botaoSeis = new Botao("6");
        botaoSeis.posicionarBotao(128,216);
        botoes.add(botaoSeis);

        Botao botaoSete = new Botao("7");
        botaoSete.posicionarBotao(0,148);
        botoes.add(botaoSete);

        Botao botaoOito = new Botao("8");
        botaoOito.posicionarBotao(64,148);
        botoes.add(botaoOito);

        Botao botaoNove = new Botao("9");
        botaoNove.posicionarBotao(128,148);
        botoes.add(botaoNove);

        Botao botaoZero = new Botao("0");
        botaoZero.posicionarBotao(64,352);

        botoes.add(botaoZero);

        Botao botaoDot = new Botao(",");
        botaoDot.posicionarBotao(0,352);
        botoes.add(botaoDot);
        Botao botaoNada = new Botao("");
        botaoNada.posicionarBotao(128,352);
        botoes.add(botaoNada);

        Botao botaoReset = new Botao("CE");
        botaoReset.posicionarBotao(0,80);
        botoes.add(botaoReset);

        this.botoes.forEach(botao -> botao.padronizaTamanhoBotao(64));

        this.label = new Label();
        label.setLayoutX(200);
        label.setLayoutY(60);

    }

    public List<Botao> getBotoes() {
        return botoes;
    }

    public Label getLabel() {
        return label;
    }

    public String aoClicarEmUmBotao(TextArea textArea){

        Resultado resultado = new Resultado();
        this.botoes.forEach(botao ->
                botao.getBotao().setOnAction(actionEvent -> {

                    if (botao.getBotao().getText().equals("=") ){
                        String equacao = textArea.getText();
                        resultado.pegaNumeros(equacao);
                        resultado.calcular();
                        textArea.setText("");
                        label.setText(resultado.getResultadoFinal());

                    }else {
                        textArea.setText(botao.aoClicar(textArea));

                        }
                    }));

                  return textArea.getText();
    }



}
