package org.example.AplicacionBancaria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BancoTest {

    @Test
    void depositar() {

        Banco banco = new Banco();
        banco.depositar("777", 100);


        assertEquals(100, banco.consultarSaldo("777"));
    }

    @Test
    void retirar() {

        Banco banco = new Banco();
        banco.depositar("777", 250);

        banco.retirar("777", 150);

        assertEquals(100, banco.consultarSaldo("777"));

    }

    @Test
    void retirarExcepcion() {
        Banco banco = new Banco();

        try {
            banco.retirar("123", 100.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Fondos insuficientes", e.getMessage());
        }
    }

    @Test
    void consultarSaldo() {

        Banco banco = new Banco();
        banco.depositar("cuentaDavid", 100);
        double saldoCuenta = banco.consultarSaldo("cuentaDavid");
        assertEquals(100, saldoCuenta);

    }
}