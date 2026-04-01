package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDARTest {

    private Calculadora calc;

    @BeforeEach
    public void inicioPruebas() {
        calc = new Calculadora(30,10);
    }

    @AfterEach
    public void finPruebas() {
        calc = null;
    }

    @Test
    void testSumaEach() {
        int resultado = calc.suma();
        assertEquals(40, resultado);
    }


    @Test
    void testSuma() {
        Calculadora calculadora = new Calculadora(3,3);
        int resultado = calculadora.suma();
        assertEquals(6, resultado);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void testSumaParametrizado(int num) {
        Calculadora calculadora = new Calculadora(num,3);
        int valorEsperado = num + calculadora.getSegundoNumero();
        int resultado = calculadora.suma();
        assertEquals(valorEsperado, resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "4, 5, 9",
            "-1, -2, -3",
            "0, 0, 0"
    })
    void testSumaConCvsSource(int a, int b, int valorEsperado) {
        Calculadora calculadora = new Calculadora(a, b);
        int resultado = calculadora.suma();
        assertEquals(valorEsperado, resultado);
    }

    @Test
    void testResta() {
        Calculadora calculadora = new Calculadora(5,3);
        int resultado = calculadora.resta();
        assertEquals(2, resultado);
    }

    @Test
    void testMultiplica() {
        Calculadora calculadora = new Calculadora(5,3);
        int resultado = calculadora.multiplica();
        assertEquals(15, resultado);
    }

    @Test
    void testDivide() {
        Calculadora calculadora = new Calculadora(10,2);
        int resultado = calculadora.divide();
        assertEquals(5, resultado);
    }

    @Test
    void testDivideException() {
        Calculadora calculadora = new Calculadora(10,0);
        String valorEsperado = "Error. No se puede dividir entre 0";
        String valorDevuelto = "";

        try {
            calculadora.divide();
        } catch (ArithmeticException e) {
            valorDevuelto = e.getMessage();
        }

        assertEquals(valorEsperado, valorDevuelto);
    }

}