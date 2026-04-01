package org.example.AplicacionBancaria;

public interface RepositorioBanco {

    double obtenerSaldo(String cuenta);
    void actualizarSaldo(String cuenta, double nuevoSaldo);

}
