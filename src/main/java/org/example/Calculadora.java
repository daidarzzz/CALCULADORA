package org.example;

public class Calculadora {

    protected int primerNumero;
    protected int segundoNumero;

    public Calculadora(int primerNumero, int segundoNumero) {
        this.primerNumero = primerNumero;
        this.segundoNumero = segundoNumero;
    }

    public int suma() {
        int resultado = primerNumero + segundoNumero;
        return resultado;
    }

    public int resta() {
        // Error introducido de forma intencionada para detectarlo con JUnit
        int resultado = primerNumero - segundoNumero;
        return resultado;
    }

    public int multiplica() {
        int resultado = primerNumero * segundoNumero;
        return resultado;
    }

    public int divide() {
        // Error introducido de forma intencionada para detectarlo con JUnit
        if (segundoNumero == 0) {
            throw new ArithmeticException("Error. No se puede dividir entre 0");
        } else {
            int resultado = primerNumero / segundoNumero;
            return resultado;
        }
    }

    public int getPrimerNumero() {
        return primerNumero;
    }

    public void setPrimerNumero(int primerNumero) {
        this.primerNumero = primerNumero;
    }

    public int getSegundoNumero() {
        return segundoNumero;
    }

    public void setSegundoNumero(int segundoNumero) {
        this.segundoNumero = segundoNumero;
    }
}



