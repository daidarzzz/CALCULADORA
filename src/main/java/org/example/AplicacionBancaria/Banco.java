package org.example.AplicacionBancaria;

public class Banco {

    private double saldo;

    public void depositar(String cuenta, double monto) {
        this.saldo += monto;
    }

    public void retirar(String cuenta, double monto) {
        if (monto > saldo) {
            throw new IllegalArgumentException("Fondos insuficientes");
        }
        this.saldo -= monto;
    }

    public double consultarSaldo(String cuenta) {
        return this.saldo;
    }

}
