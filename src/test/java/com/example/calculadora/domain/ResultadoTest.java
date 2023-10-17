package com.example.calculadora.domain;

import com.example.calculadora.Botoes.Resultado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultadoTest {

    @Test
    public void guardaNumeros(){
        Resultado resultado = new Resultado();
        String equacao = "55+88x66÷2";
        resultado.pegaNumeros(equacao);
        String resultadoEsperado = "[55.0, 88.0, 66.0, 2.0]";
        Assertions.assertEquals(resultadoEsperado, resultado.getNumeros());

    }

    @Test
    public void calculaValorComInicialPositivo(){
        Resultado resultado = new Resultado();
        String equacao = "55+88x66÷2";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(55.0+88.0*66.0/2);
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());

    }

    @Test
    public void calculaValorComInicialNegativo(){
        Resultado resultado = new Resultado();
        String equacao = "-55+88x66÷2";
        resultado.pegaNumeros(equacao);
        resultado.calcular();
        String resultadoEsperado = Double.toString(-55+88*66/2);
        Assertions.assertEquals(resultadoEsperado, resultado.getResultadoFinal());

    }
}
