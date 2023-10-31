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
                equacao.substring(separacaoInicial);
                System.out.println(equacao);
            }
            equacao = this.retiraNumeroESinal(equacao);


        }

    }

    private String retiraNumeroESinal(String equacao){



        int separacao = verificaProximoOperador(equacao);
        switch (proximoOperador){
            case "-":
                if (comNegativo){
                    System.out.println("entrou em com negativo");
                    equacao =equacao.substring(separacao+1);
                    separacao = verificaProximoOperador(equacao);
                    String numeroRetirado = equacao.substring(0,separacao);
                    this.numeros.add(Double.parseDouble(numeroRetirado)*-1);
                    if (!equacao.equals("")){
                        equacao =equacao.substring(separacao);
                    }
                    comNegativo = false;

                }else {
                    equacao =equacao.substring(separacao+1);
                    separacao = verificaProximoOperador(equacao);
                    String numeroRetirado = equacao.substring(0,separacao);
                    this.numeros.add(Double.parseDouble(numeroRetirado)*-1);
                    this.sinais.add("+");
                    if (!equacao.equals("")) {
                        equacao = equacao.substring(separacao);
                    }


                }
                break;


            case "+":
                equacao =equacao.substring(separacao+1);
                separacao = verificaProximoOperador(equacao);
                String numeroRetirado = equacao.substring(0,separacao);
                this.numeros.add(Double.parseDouble(numeroRetirado));
                this.sinais.add("+");
                if (!equacao.equals("")){
                    equacao =equacao.substring(separacao);
                }
                break;

            case "x":
                if (comNegativo){
                    equacao =equacao.substring(separacao+1);
                    this.sinais.add("x");

                }else {
                    equacao =equacao.substring(separacao+1);
                    separacao = verificaProximoOperador(equacao);
                    numeroRetirado = equacao.substring(0,separacao);
                    this.numeros.add(Double.parseDouble(numeroRetirado));
                    this.sinais.add("x");
                    if (!equacao.equals("")){
                        equacao =equacao.substring(separacao);
                    }
                }

                break;

            case "÷":
                if (comNegativo){
                    equacao =equacao.substring(separacao+1);
                    this.sinais.add("÷");
                }else {
                    equacao =equacao.substring(separacao+1);
                    separacao = verificaProximoOperador(equacao);
                    numeroRetirado = equacao.substring(0,separacao);
                    this.numeros.add(Double.parseDouble(numeroRetirado));
                    this.sinais.add("÷");
                    if (!equacao.equals("")){
                        equacao =equacao.substring(separacao);
                    }
                }
                break;
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
        int posicaoOperador = 0;
        if (proximoOperador == "-1")
            posicaoOperador = equacao.length();
        else
            posicaoOperador= equacao.indexOf(proximoOperador);

        return posicaoOperador;
    }


    public void calcular(){



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
                    System.out.println(this.numeros.toString() + " " + this.sinais.toString());

                }
            }
        }


        //DIVISAO

        while(this.sinais.contains("÷")){
            for (int i = 0; i<this.sinais.size();i++){
                if (this.sinais.get(i).equals("÷")){
                    this.numeros.set(i,this.numeros.get(i) / this.numeros.get(i+1));
                    this.empurraNumeros(i);
                    System.out.println(this.numeros.toString() + " " + this.sinais.toString());
                }
            }
        }


        //SOMA
        while (this.sinais.contains("+")){
            for (int i = 0; i<this.sinais.size();i++){
                if (this.sinais.get(i).equals("+")){
                    this.numeros.set(i,this.numeros.get(i) + this.numeros.get(i+1));
                    this.empurraNumeros(i);
                    System.out.println(this.numeros.toString() + " " + this.sinais.toString());

                }
            }
        }


        System.out.println(this.numeros.toString());
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

    private String getsinais() {
        return this.sinais.toString();
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
