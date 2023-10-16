package com.example.calculadora.Botoes;


import java.util.ArrayList;

public class Resultado {

    private ArrayList<Double> numeros;
    private ArrayList<String> sinais;
    private  Double resultadoParcial;
    private String resultadoFinal;


    public Resultado() {
        this.numeros = new ArrayList<Double>();
        this.sinais = new ArrayList<String>();
        this.sinais.add("");
        this.resultadoParcial = 0.0;
        this.resultadoFinal = "";
    }

    public void pegaNumeros(String equacao){
        int separacao = 0;
        int inicioSeparacao = 0;
        String proximaOperacao = "";
        while (equacao.contains("+")||equacao.contains("x")||
                equacao.contains("-")||equacao.contains("÷")){

            if(separacao == 0){
                if(equacao.startsWith("-")){

                    this.sinais.set(0, "-");
                    equacao = equacao.substring(equacao.indexOf("-") + 1);
                    proximaOperacao = verificaProximoOperador(equacao);
                    separacao = equacao.indexOf(proximaOperacao);
                    String numeroRetirado = equacao.substring(inicioSeparacao,separacao);
                    this.numeros.add(Double.parseDouble(numeroRetirado));
                    this.sinais.add(String.valueOf(equacao.charAt(separacao)));
                    equacao = equacao.substring(separacao + 1);


                }
            }else {

                System.out.println("entrou2");
                proximaOperacao = verificaProximoOperador(equacao);
                separacao = equacao.indexOf(proximaOperacao);
                String numeroRetirado = equacao.substring(inicioSeparacao,separacao);
                this.numeros.add(Double.parseDouble(numeroRetirado));
                this.sinais.add(String.valueOf(equacao.charAt(separacao)));
                equacao = equacao.substring(separacao + 1);

            }
        }
        this.numeros.add(Double.parseDouble(equacao));



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
            System.out.println(this.sinais.get(0));
            this.sinais.remove(0);
        }
        

        for (int i = 0; i<this.numeros.size();i++){
        //    if (this.sinais.get(i) =="("){

         //   }
        }

       //MULTIPLICACAO
        for (int i = 0; i<this.sinais.size();i++){
            if (this.sinais.get(i).equals("x")){
                System.out.println(this.numeros.get(i) +"*"+this.numeros.get(i+1)+ "="+ this.numeros.get(i) * this.numeros.get(i+1));

                this.numeros.set(i,this.numeros.get(i) * this.numeros.get(i+1));
                this.empurraNumeros(i);

            }
        }


        //DIVISAO
        for (int i = 0; i<this.sinais.size();i++){
            if (this.sinais.get(i).equals("÷")){
                System.out.println(this.numeros.get(i) +"/"+this.numeros.get(i+1)+ "="+ this.numeros.get(i) / this.numeros.get(i+1));
                this.numeros.set(i,this.numeros.get(i) / this.numeros.get(i+1));
                this.empurraNumeros(i);


            }
        }

        //SOMA
        for (int i = 0; i<this.sinais.size();i++){
            if (this.sinais.get(i).equals("+")){
                System.out.println(this.numeros.get(i) +"+"+this.numeros.get(i+1)+ "="+ (this.numeros.get(i) + this.numeros.get(i+1)));

                this.numeros.set(i,this.numeros.get(i) + this.numeros.get(i+1));
                this.empurraNumeros(i);
                System.out.println(this.numeros.get(i));

            }
        }

        //SUBTRACAO
        for (int i = 0; i<this.sinais.size();i++){
            if (this.sinais.get(i).equals("-")){
                System.out.println(this.numeros.get(i) +"-"+this.numeros.get(i+1)+ "="+ (this.numeros.get(i) - this.numeros.get(i+1)));

                this.numeros.set(i,this.numeros.get(i) - this.numeros.get(i+1));
                this.empurraNumeros(i);
                System.out.println(this.numeros.get(i) );
            }
        }

        this.resultadoFinal = this.numeros.get(0).toString();

///////////////////////////////////////////////////////////////////////////////////////////////////////////
        //                          OUTRA FORMA DE CALCULAR
        /*int i = 0;
        String sinal = this.getSinal(i);
        while(sinal!= null){
            switch (sinal){
                case "+" -> {
                    if (this.resultadoParcial ==0){
                        this.resultadoParcialBackup = this.resultadoParcial;
                        this.resultadoParcial = this.numeros[i] + this.numeros[i+1];
                    }else{
                        this.resultadoParcial += this.numeros[i+1];
                    }
                }
                case "-" -> {
                    if (this.resultadoParcial ==0){
                        this.resultadoParcial = this.numeros[i] - this.numeros[i+1];
                    }else{
                        this.resultadoParcial -= this.numeros[i+1];
                    }
                }
                case "x" -> {
                    if (this.resultadoParcial ==0){
                        this.resultadoParcial = this.numeros[i] * this.numeros[i+1];
                    }else{
                        this.resultadoParcial *= this.numeros[i+1];
                    }
                }
                case "÷" -> {
                    if (this.resultadoParcial ==0){
                        this.resultadoParcial = this.numeros[i] / this.numeros[i+1];
                    }else{
                        this.resultadoParcial /= this.numeros[i+1];
                    }
                }
            }
            i++;
            sinal = this.sinais[i];
        }
        resultadoFinal = Double.toString(resultadoParcial);*/
    }

    private void empurraNumeros(int constante) {

        for (int i = constante + 1;i+1<this.numeros.size();i++){
            this.numeros.set(i,this.numeros.get(i+1));
        }
        this.sinais.remove(constante);
    }

    private String getsinais() {
        return this.sinais.toString();
    }

    public String getNumeros() {

      /*  String numeros = "[";
        for (int i = 0;i < 21;i++){
            if (this.numeros[i] != null)
                numeros += this.numeros.get(i) + ",";

        }
        numeros += "]";*/
       return this.numeros.toString();
    }

    public String getResultadoFinal() {
        return resultadoFinal;
    }

}
