package com.example.calculadora.solucao;

import java.util.ArrayList;

public class Calculador {

    private ArrayList <Double> numeros;

    private ArrayList<String> sinais;

    public Calculador(ArrayList<Double> numerosACalcular, ArrayList<String> sinaisACalcular) {
        this.numeros = numerosACalcular;
        this.sinais = sinaisACalcular;
    }

    public String run(){
        System.out.println("------------------");
        System.out.println(this.numeros.toString());
        System.out.println(this.sinais.toString());




        //MULTIPLICACAO
        while (this.sinais.contains("x")) {
            this.multiplicar();
            }


    //DIVISAO

        while(this.sinais.contains("÷")){
           this.dividir();
        }


        //SOMA
        while (this.sinais.contains("+")){
           this.somar();
        }


        String resultadoFinal = this.numeros.get(0).toString();
        return resultadoFinal;


    }

    private void multiplicar() {
        for (int i = 0; i < this.sinais.size(); i++) {
            if (this.sinais.get(i).equals("x")) {

                this.numeros.set(i, this.numeros.get(i) * this.numeros.get(i + 1));
                this.empurraNumeros(i);
            }
        }
    }
    private void dividir() {

        for (int i = 0; i<this.sinais.size();i++){
            if (this.sinais.get(i).equals("÷")){

                this.numeros.set(i,(this.numeros.get(i)*-1) / (this.numeros.get(i+1)*-1));
                this.empurraNumeros(i);

            }
        }
    }
    private void somar() {

        for (int i = 0; i<this.sinais.size();i++){

            if (this.sinais.get(i).equals("+")){
                this.numeros.set(i,this.numeros.get(i) + this.numeros.get(i+1));
                this.empurraNumeros(i);


            }
        }

    }

    private void empurraNumeros(int constante) {

        for (int i = constante + 1;i+1<this.numeros.size();i++){
            this.numeros.set(i,this.numeros.get(i+1));
        }
        this.sinais.remove(constante);
        this.numeros.remove(this.numeros.size()-1);
    }
}
