package com.example.calculadora.botoes.solucao;


import java.util.ArrayList;

public class Resultado {

    private final ArrayList<Double> numeros;
    private final ArrayList<String> sinais;
    private String resultadoFinal;
    private String equacao;




    public Resultado() {
        this.numeros = new ArrayList<>();
        this.numeros.add(Double.parseDouble("0"));
        this.sinais = new ArrayList<>();
        this.resultadoFinal = "";

    }

    public void pegaNumeros(String equacaoNova){
        ColetorOperador coletor = new ColetorOperador();
        this.equacao = equacaoNova;

        while (equacao.contains("+")||equacao.contains("x")||
                equacao.contains("-")||equacao.contains("÷")){

            coletor.verificaProximoOperador(equacao);
            if (!equacao.startsWith(coletor.getProximoOperador())){
                System.out.println("entrou");
                String numeroRetirado = equacao.substring(0,coletor.getPosicaoOperador());
                this.numeros.add(Double.parseDouble(numeroRetirado));
                this.sinais.add("+");
            }

            coletor = this.retiraNumeroESinal(coletor);


        }

    }

    private ColetorOperador retiraNumeroESinal(ColetorOperador coletor){

        System.out.println(this.numeros.toString());
        System.out.println(equacao);

        coletor.verificaProximoOperador(equacao);

        equacao =equacao.substring(coletor.getPosicaoOperador()+1);
        System.out.println(equacao);


        System.out.println(!coletor.getProximoOperador().equals("-"));

        if (!coletor.getProximoOperador().equals("-")){
            if (coletor.getComNegativo() && !coletor.getProximoOperador().equals("+")){

                this.sinais.add(coletor.getProximoOperador());

            }else{

                this.sinais.add(coletor.getProximoOperador());
                coletor.verificaProximoOperador(equacao);


                String numeroRetirado = equacao.substring(0,coletor.getPosicaoOperador());
                this.numeros.add(Double.parseDouble(numeroRetirado));
                coletor.setComNegativo(false);
                if (!equacao.equals("")){
                    equacao = equacao.substring(coletor.getPosicaoOperador());
                }


            }


        }else{
            if (!coletor.getComNegativo()){
                this.sinais.add("+");
            }
            coletor.verificaProximoOperador(equacao);
            String numeroRetirado = equacao.substring(0,coletor.getPosicaoOperador());
            this.numeros.add(Double.parseDouble(numeroRetirado )* -1);
            coletor.setComNegativo(false);
            if (!equacao.equals("")){
                equacao =equacao.substring(coletor.getPosicaoOperador());
            }
        }

        return coletor;



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
        return resultadoFinal;
    }

    public String getSinais() {
        return this.sinais.toString();
    }
}
