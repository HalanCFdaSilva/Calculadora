package com.example.calculadora.domain;

import com.example.calculadora.solucao.Resultado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultadoTest {

    @Test
    public void guardaNumeros(){
        Resultado resultado = new Resultado();
        String equacao = "55+88x66÷2";
        resultado.pegaNumeros(equacao);
        String resultadoEsperado = "[0.0, 55.0, 88.0, 66.0, 2.0]";
        String sinaisEsperado = "[+, +, x, ÷]";
        Assertions.assertEquals(resultadoEsperado, resultado.getNumeros());
        Assertions.assertEquals(sinaisEsperado, resultado.getSinais());

    }

    @Test
    public void calculaValorComInicialPositivo(){
        Resultado resultado = new Resultado();
        String equacao = "55+88x66÷2";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(55.0+88.0*66.0/2);
        resultadoEsperado = resultadoEsperado.replace(".",",");
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());

    }

    @Test
    public void calculaValorComInicialNegativo(){
        Resultado resultado = new Resultado();
        String equacao = "-55+88x66÷2";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(-55+ (double) (88 * 66) /2);
        resultadoEsperado = resultadoEsperado.replace(".",",");
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());

    }

    @Test
    public void somaNumerosNegativos(){
        Resultado resultado = new Resultado();
        String equacao ="-55-88";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(-55-88);
        resultadoEsperado = resultadoEsperado.replace(".",",");
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());
    }

    @Test
    public void somaMultiplosNumerosPositivos(){
        Resultado resultado = new Resultado();
        String equacao ="55+88+66";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(55+88+66);
        resultadoEsperado = resultadoEsperado.replace(".",",");
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());
    }

    @Test
    public void MultiplicaMultiplosNumeros(){
        Resultado resultado = new Resultado();
        String equacao ="55x88x66";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(55*88*66);
        resultadoEsperado = resultadoEsperado.replace(".",",");
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());
    }

    @Test
    public void SubtraiMultiplosNumeros(){
        Resultado resultado = new Resultado();
        String equacao ="55÷88÷66";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(55.0/88.0/66.0);
        resultadoEsperado = resultadoEsperado.replace(".",",");
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());
    }

    @Test
    public void SubtracaoNumerosNegativos(){
        Resultado resultado = new Resultado();
        String equacao ="-88÷55";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(-88.0/55.0);
        resultadoEsperado = resultadoEsperado.replace(".",",");
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());
    }

    @Test
    public void multiplicacaoComSegundoNumeroNegativo(){
        Resultado resultado = new Resultado();
        String equacao ="1x-1";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(-1);
        resultadoEsperado = resultadoEsperado.replace(".",",");
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());

    }

    @Test
    public void DivisaoComSegundoNumeroNegativo(){
        Resultado resultado = new Resultado();
        String equacao ="1+1÷-1";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(0);
        resultadoEsperado = resultadoEsperado.replace(".",",");
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());

    }

    @Test
    public void DivisaoComMultiplicacaoENumeroNegativo(){
        Resultado resultado = new Resultado();
        String equacao ="1x-1÷-1";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(1);
        resultadoEsperado = resultadoEsperado.replace(".",",");
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());

    }

    @Test
    public void equacoesEmSequencia(){
        Resultado resultado = new Resultado();
        String equacao ="1x1";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(1);
        resultadoEsperado = resultadoEsperado.replace(".",",");
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());
        equacao ="1x2";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        resultadoEsperado = Double.toString(2);
        resultadoEsperado = resultadoEsperado.replace(".",",");
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());

    }

    @Test
    public void somaComSegundoNumeroNegativo(){
        Resultado resultado = new Resultado();
        String equacao ="1+-1";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(0);
        resultadoEsperado = resultadoEsperado.replace(".",",");
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());

    }

    @Test
    public void guardarNumerosESinaisCorretamenteQuandoHaDoisNumerosNegativosEmSequenciaSomando(){
        Resultado resultado = new Resultado();
        String equacao = "-1+-1";
        resultado.pegaNumeros(equacao);
        String resultadoEsperado = "[0.0, -1.0, -1.0]";
        String sinaisEsperado = "[+, +]";
        Assertions.assertEquals(resultadoEsperado, resultado.getNumeros());
        Assertions.assertEquals(sinaisEsperado, resultado.getSinais());

    }
    @Test
    public void calcularCorretamenteQuandoHaDoisNumerosNegativosEmSequenciaSomando(){
        Resultado resultado = new Resultado();
        String equacao = "-1+-1";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(-2.0);
        resultadoEsperado = resultadoEsperado.replace(".",",");
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());

    }


    @Test
    public void guardarNumerosESinaisCorretamenteComApenasPrimeiroNumerosNegativo(){
        Resultado resultado = new Resultado();
        String equacao = "-1x1";
        resultado.pegaNumeros(equacao);
        String resultadoEsperado = "[0.0, -1.0, 1.0]";
        String sinaisEsperado = "[+, x]";
        Assertions.assertEquals(resultadoEsperado, resultado.getNumeros());
        Assertions.assertEquals(sinaisEsperado, resultado.getSinais());

    }

    @Test
    public void calcularCorretamenteComApenasPrimeiroNumerosNegativo(){
        Resultado resultado = new Resultado();
        String equacao = "-1x1";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(-1.0);
        resultadoEsperado = resultadoEsperado.replace(".",",");
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());

    }

    @Test
    public void ChecaNumeroDeSinaisNaEquacaoCorretamente(){
        Resultado resultado = new Resultado();
        String equacao = "-55+88x66÷2";
        int numeroColetado = resultado.verificaSinais(equacao);
        int numeroEsperado = 4;
        Assertions.assertEquals(numeroEsperado, numeroColetado);

    }


}
