package com.example.calculadora.Botoes;


import java.util.ArrayList;

public class Resultado {

    private final ArrayList<Double> numeros;
    private final ArrayList<String> sinais;
    private String resultadoFinal;



    public Resultado() {
        this.numeros = new ArrayList<>();
        this.sinais = new ArrayList<>();
        this.sinais.add("");
        this.resultadoFinal = "";
    }

    public void pegaNumeros(String equacao){
        while (equacao.contains("+")||equacao.contains("x")||
                equacao.contains("-")||equacao.contains("÷")){

            if(equacao.startsWith("-")){
                this.sinais.set(0, "-");
                equacao = equacao.substring(equacao.indexOf("-") + 1);
                equacao = this.retiraNumeroESinal(equacao);
            }

            equacao = this.retiraNumeroESinal(equacao);

        }

        this.numeros.add(Double.parseDouble(equacao));

        System.out.println(this.numeros.toString());
        System.out.println(this.sinais.toString());



    }

    private String retiraNumeroESinal(String equacao){
        String proximaOperacao = verificaProximoOperador(equacao);
        int separacao = equacao.indexOf(proximaOperacao);
        String numeroRetirado = equacao.substring(0,separacao);
        this.numeros.add(Double.parseDouble(numeroRetirado));
        this.sinais.add(String.valueOf(equacao.charAt(separacao)));
        return equacao.substring(separacao + 1);
    }
    private String verificaProximoOperador(String equacao) {

        int posicaoSoma = 1000;
        int posicaoSubtracao = 1000;
        int posicaoMultiplicacao = 1000;
        int posicaoDivisao = 1000;

        String proximoOperador = "/";


        if(equacao.contains("-"))
            posicaoSubtracao = equacao.indexOf("-");

        if(equacao.contains("x"))
            posicaoMultiplicacao = equacao.indexOf("x");

        if(equacao.contains("+"))
            posicaoSoma = equacao.indexOf("+");

        if(equacao.contains("÷"))
            posicaoDivisao = equacao.indexOf("÷");


        if (posicaoSoma < posicaoSubtracao){
            if (posicaoSoma < posicaoMultiplicacao){
                if (posicaoSoma < posicaoDivisao){
                    proximoOperador = "+";
                }
            }
        } else{
            if (posicaoSubtracao < posicaoDivisao) {
                if (posicaoSubtracao < posicaoMultiplicacao){
                    proximoOperador = "-";
                }
            }else {
                if (posicaoDivisao < posicaoMultiplicacao){
                    proximoOperador = "÷";
                }else {
                    proximoOperador = "x";
                }
            }
        }

        return proximoOperador;

    }

    public void calcular(){



        if(this.sinais.get(0).equals("-")){
            this.numeros.set(0,-this.numeros.get(0));
        }
        this.sinais.remove(0);
        System.out.println(this.sinais.toString());
        

        for (int i = 0; i<this.numeros.size();i++){
        //    if (this.sinais.get(i) =="("){

         //   }
        }

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
                    System.out.println(this.numeros.get(0));

                }
            }
        }

        //SUBTRACAO
        while (this.sinais.contains("-")){
            System.out.println("entrou");
            for (int i = 0; i<this.sinais.size();i++){
                if (this.sinais.get(i).equals("-")){
                    this.numeros.set(i,this.numeros.get(i) - this.numeros.get(i+1));
                    this.empurraNumeros(i);
                }
            }
        }


        System.out.println(this.numeros.toString());
        this.resultadoFinal = this.numeros.get(0).toString();


    }

    private void empurraNumeros(int constante) {

        for (int i = constante + 1;i+1<this.numeros.size();i++){
            this.numeros.set(i,this.numeros.get(i+1));
        }
        this.sinais.remove(constante);
        this.numeros.remove(this.numeros.size()-1);
    }

    private String getsinais() {
        return this.sinais.toString();
    }

    public String getNumeros() {

       return this.numeros.toString();
    }

    public String getResultadoFinal() {
        return resultadoFinal;
    }

}
