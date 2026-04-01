package org.example.AplicacionBancaria;

public class BancoService {

    private final RepositorioBanco repositorioBanco;

    public BancoService(RepositorioBanco repositorioBanco) {

        this.repositorioBanco = repositorioBanco;

    }

    public void depositar(String cuenta, double monto) {
        double saldoActual = consultarSaldo(cuenta);
        repositorioBanco.actualizarSaldo(cuenta, saldoActual + monto);
    }

    public void retirar(String cuenta, double monto) {

        double saldoActual = consultarSaldo(cuenta);
        if (saldoActual < monto) {
            throw new IllegalArgumentException("Fondos insuficientes");
        }
        repositorioBanco.actualizarSaldo(cuenta, saldoActual - monto);
    }

    public double consultarSaldo(String cuenta) {
        return repositorioBanco.obtenerSaldo(cuenta);
    }

}