package com.example.calculadora.Botoes;


import java.util.ArrayList;

public class Resultado {

    private final ArrayList<Double> numeros;
    private final ArrayList<String> sinais;
    private String resultadoFinal;

    private String proximoOperador;
    private boolean comNegativo;


    public Resultado() {
        this.numeros = new ArrayList<>();
        this.numeros.add(Double.parseDouble("0"));
        this.sinais = new ArrayList<>();
        this.resultadoFinal = "";
        this.comNegativo = false;
    }

    public void pegaNumeros(String equacao){
        while (equacao.contains("+")||equacao.contains("x")||
                equacao.contains("-")||equacao.contains("÷")){

            int separacaoInicial = verificaProximoOperador(equacao);
            if (!equacao.startsWith(proximoOperador)){
                String numeroRetirado = equacao.substring(0,separacaoInicial);
                this.numeros.add(Double.parseDouble(numeroRetirado));
                this.sinais.add("+");
            }
            equacao = this.retiraNumeroESinal(equacao);


        }

    }

    private String retiraNumeroESinal(String equacao){



        int separacao = verificaProximoOperador(equacao);
        equacao =equacao.substring(separacao+1);

        if (!this.proximoOperador.equals("-")){

            if (this.comNegativo && !this.proximoOperador.equals("+")){
                this.sinais.add(this.proximoOperador);

            }else{
                this.sinais.add(this.proximoOperador);
                separacao = verificaProximoOperador(equacao);
                String numeroRetirado = equacao.substring(0,separacao);
                this.numeros.add(Double.parseDouble(numeroRetirado));
                this.comNegativo = false;
                if (!equacao.equals("")){
                    equacao =equacao.substring(separacao);
                }


            }


        }else{
            if (!this.comNegativo){
                this.sinais.add("+");
            }
            separacao = verificaProximoOperador(equacao);
            String numeroRetirado = equacao.substring(0,separacao);
            this.numeros.add(Double.parseDouble(numeroRetirado )* -1);
            this.comNegativo = false;
            if (!equacao.equals("")){
                equacao =equacao.substring(separacao);
            }
        }

        return equacao;



    }


    private int verificaProximoOperador(String equacao) {


        int posicaoSoma = 1000;
        int posicaoSubtracao = 1000;
        int posicaoMultiplicacao = 1000;
        int posicaoDivisao = 1000;


        if(equacao.contains("-"))
            posicaoSubtracao = equacao.indexOf("-");

        if(equacao.contains("x"))
            posicaoMultiplicacao = equacao.indexOf("x");

        if (equacao.contains("x-")){
            posicaoMultiplicacao = equacao.indexOf("x");
            comNegativo = true;
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
        System.out.println(proximoOperador);
        int posicaoOperador;
        if (proximoOperador.equals("-1") )
            posicaoOperador = equacao.length();
        else
            posicaoOperador= equacao.indexOf(proximoOperador);

        return posicaoOperador;
    }


    public void calcular(){



       //MULTIPLICACAO
        while (this.sinais.contains("x")) {
            for (int i = 0; i < this.sinais.size(); i++) {
                if (this.sinais.get(i).equals("x")) {
                    this.numeros.set(i, this.numeros.get(i) * this.numeros.get(i + 1));
                    this.empurraNumeros(i);

                }
            }
        }


        //DIVISAO

        while(this.sinais.contains("÷")){
            for (int i = 0; i<this.sinais.size();i++){
                if (this.sinais.get(i).equals("÷")){
                    this.numeros.set(i,this.numeros.get(i) / this.numeros.get(i+1));
                    this.empurraNumeros(i);
                }
            }
        }


        //SOMA
        while (this.sinais.contains("+")){
            for (int i = 0; i<this.sinais.size();i++){
                if (this.sinais.get(i).equals("+")){
                    this.numeros.set(i,this.numeros.get(i) + this.numeros.get(i+1));
                    this.empurraNumeros(i);


                }
            }
        }


        this.resultadoFinal = this.numeros.get(0).toString();
        this.numeros.clear();
        this.sinais.clear();


    }

    private void empurraNumeros(int constante) {

        for (int i = constante + 1;i+1<this.numeros.size();i++){
            this.numeros.set(i,this.numeros.get(i+1));
        }
        this.sinais.remove(constante);
        this.numeros.remove(this.numeros.size()-1);
    }


    public String getNumeros() {

       return this.numeros.toString();
    }

    public String getResultadoFinal() {
        return resultadoFinal;
    }

    public String getSinais() {
        return this.sinais.toString();
    }
}
