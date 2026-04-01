package org.example.AplicacionBancaria;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BancoServiceTest {

    @Mock
    private RepositorioBanco repositorioBanco;

    @InjectMocks
    private BancoService bancoService;

    @Test
    void testConsultarSaldo() {
        when(repositorioBanco.obtenerSaldo("cuenta1")).thenReturn(100.0, 200.0);

        assertEquals(100.0, bancoService.consultarSaldo("cuenta1"));
        assertEquals(200.0, bancoService.consultarSaldo("cuenta1"));

        verify(repositorioBanco, times(2)).obtenerSaldo("cuenta1");
    }

    @Test
    void testDepositarConOrden() {
        when(repositorioBanco.obtenerSaldo("cuenta1")).thenReturn(100.0);

        bancoService.depositar("cuenta1", 50.0);

        InOrder orden = inOrder(repositorioBanco);
        orden.verify(repositorioBanco).obtenerSaldo("cuenta1");
        orden.verify(repositorioBanco).actualizarSaldo("cuenta1", 150.0);
    }

    @Test
    void testRetirarConExito() {
        when(repositorioBanco.obtenerSaldo("cuenta1")).thenReturn(200.0);

        bancoService.retirar("cuenta1", 50.0);

        verify(repositorioBanco).actualizarSaldo("cuenta1", 150.0);
    }

    @Test
    void testRetirarSinFondosLanzaExcepcion() {
        when(repositorioBanco.obtenerSaldo("cuenta1")).thenReturn(10.0);

        assertThrows(IllegalArgumentException.class, () -> {
            bancoService.retirar("cuenta1", 100.0);
        });

    }

}