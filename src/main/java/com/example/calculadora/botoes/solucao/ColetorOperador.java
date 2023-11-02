package com.example.calculadora.botoes.solucao;

public class ColetorOperador {

    private boolean comNegativo = false;

    private int posicaoOperador;

    private String proximoOperador;

    public void verificaProximoOperador(String equacao) {

        int posicaoSoma = 1000;
        int posicaoSubtracao = 1000;
        int posicaoMultiplicacao = 1000;
        int posicaoDivisao = 1000;


        if(equacao.contains("-"))
            posicaoSubtracao = equacao.indexOf("-");

        if(equacao.contains("x")){
            posicaoMultiplicacao = equacao.indexOf("x");

            if (equacao.contains("x-")){

                this.comNegativo = true;
            }
        }






        if(equacao.contains("+"))
            posicaoSoma = equacao.indexOf("+");

        if(equacao.contains("÷")){
            posicaoDivisao = equacao.indexOf("÷");

            if (equacao.contains("÷-")){

                comNegativo = true;
            }
        }



        if (posicaoSoma < posicaoSubtracao){

            if (posicaoSoma < posicaoMultiplicacao){
                if (posicaoSoma < posicaoDivisao){
                    proximoOperador = "+";
                }
            }
        } else {
            if (posicaoSubtracao < posicaoDivisao) {

                if (posicaoSubtracao < posicaoMultiplicacao) {
                    proximoOperador = "-";
                } else {
                    proximoOperador = "x";

                }
            } else {
                if (posicaoDivisao < posicaoMultiplicacao) {

                    proximoOperador = "÷";
                } else {
                    if (posicaoMultiplicacao < posicaoDivisao) {

                        proximoOperador = "x";
                    } else {
                        proximoOperador = "-1";

                    }
                }
            }


        }

        this.pegaPosicaoOperador(equacao);

    }
    private void pegaPosicaoOperador(String equacao){
        if (proximoOperador.equals("-1") )
            posicaoOperador = equacao.length();
        else
            posicaoOperador= equacao.indexOf(proximoOperador);
    }

    public int getPosicaoOperador() {
        return posicaoOperador;
    }

    public String getProximoOperador() {
        return proximoOperador;
    }

    public boolean getComNegativo() {
        return this.comNegativo;
    }

    public void setComNegativo(boolean comNegativo) {
        this.comNegativo = comNegativo;
    }
}
