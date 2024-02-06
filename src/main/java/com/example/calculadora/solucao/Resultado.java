package com.example.calculadora.solucao;


import java.util.ArrayList;

public class Resultado {

    private final ArrayList<Double> numeros;
    private final ArrayList<String> sinais;
    private String resultadoFinal;
    private String equacao;
    private boolean primeiraVezEquacao;


    public Resultado() {
        this.numeros = new ArrayList<>();
        this.sinais = new ArrayList<>();
        this.resultadoFinal = "";

    }

    public void pegaNumeros(String equacaoNova){
        ColetorOperador coletor = new ColetorOperador();
        this.equacao = equacaoNova.replace(",",".");
        this.primeiraVezEquacao = true;
        this.numeros.add(Double.parseDouble("0"));
        while (equacao.contains("+")||equacao.contains("x")||
                equacao.contains("-")||equacao.contains("÷")){


            coletor.verificaProximoOperador(equacao);
            if (!equacao.startsWith(coletor.getProximoOperador())){
                String numeroRetirado = equacao.substring(0,coletor.getPosicaoOperador());
                this.numeros.add(Double.parseDouble(numeroRetirado));
                this.sinais.add("+");
            } else if (equacao.startsWith("-") && primeiraVezEquacao) {
                this.sinais.add("+");

            }

            this.retiraNumeroESinal(coletor);
            primeiraVezEquacao = false;



        }
        if (primeiraVezEquacao){
            this.numeros.set(0, Double.parseDouble(this.equacao));

        }



    }

    private void retiraNumeroESinal(ColetorOperador coletor){



        coletor.verificaProximoOperador(equacao);

        equacao =equacao.substring(coletor.getPosicaoOperador()+1);

        if (!coletor.getProximoOperador().equals("-")){
            if (coletor.getComNegativo()){

                this.sinais.add(coletor.getProximoOperador());

            }else{

                this.sinais.add(coletor.getProximoOperador());
                coletor.verificaProximoOperador(equacao);


                String numeroRetirado = equacao.substring(0,coletor.getPosicaoOperador());
                this.numeros.add(Double.parseDouble(numeroRetirado));
                coletor.setComNegativo(false);
                if (!equacao.isEmpty()){
                    equacao = equacao.substring(coletor.getPosicaoOperador());
                }


            }


        }else{
            if (!coletor.getComNegativo() && !this.primeiraVezEquacao){
                this.sinais.add("+");
            }
            coletor.verificaProximoOperador(equacao);
            String numeroRetirado = equacao.substring(0,coletor.getPosicaoOperador());
            this.numeros.add(Double.parseDouble(numeroRetirado )* -1);
            coletor.setComNegativo(false);
            if (!equacao.isEmpty()){
                equacao =equacao.substring(coletor.getPosicaoOperador());
            }
        }





    }





    public void calcular(){


        Calculador calculador = new Calculador(this.numeros, this.sinais);
        this.resultadoFinal = calculador.run();
        this.numeros.clear();
        this.sinais.clear();


    }

    public String getNumeros() {

       return this.numeros.toString();
    }

    public String getResultadoFinal() {
        return resultadoFinal.replace(".",",");
    }

    public String getSinais() {
        return this.sinais.toString();
    }




    public int verificaSinais(String equacaoNova){

        ArrayList< String> guardaOperacoes = new ArrayList<>();

        ColetorOperador coletor = new ColetorOperador();

        while (equacaoNova.contains("+")||equacaoNova.contains("x")||
                equacaoNova.contains("-")||equacaoNova.contains("÷")){
            coletor.verificaProximoOperador(equacaoNova);
            guardaOperacoes.add(coletor.getProximoOperador());
            equacaoNova = equacaoNova.substring(coletor.getPosicaoOperador()+1);


        }
        return guardaOperacoes.size();

    }
}
