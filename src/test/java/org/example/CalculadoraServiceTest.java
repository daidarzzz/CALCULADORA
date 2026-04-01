package org.example;

import org.testng.annotations.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculadoraServiceTest {

    @Mock
    private Repositorio repositorio;

    // Inyectamos el mock en calculadoraService
    @InjectMocks
    private CalculadoraService calculadoraService;

    //Inyectamos el mock en el espía calculadoraSpy
    @InjectMocks
    @Spy
    private CalculadoraService calculadoraSpy;

    @Test
    void testSumarValores() {
        when(repositorio.obtenerValorA()).thenReturn(5);
        when(repositorio.obtenerValorB()).thenReturn(3);

        int resultado = calculadoraService.sumarValores();

        assertEquals(8, resultado);
        verify(repositorio).obtenerValorA();
        verify(repositorio).obtenerValorB();
    }

    //En este test vamos a probar la obtención de diferentes valores consecutivos.
    @Test
    void testSumarValoresConMultiplesRetornos() {
        when(repositorio.obtenerValorA()).thenReturn(5, 10);
        when(repositorio.obtenerValorB()).thenReturn(3);

        assertEquals(8, calculadoraService.sumarValores());
        assertEquals(13, calculadoraService.sumarValores());
    }

    @Test
    void testSumarValoresConExcepcion() {
        when(repositorio.obtenerValorA())
            .thenThrow(new RuntimeException("Error al obtener valor A"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            calculadoraService.sumarValores();
        });

        assertEquals("Error al obtener valor A", exception.getMessage());
    }

    //En este test verificamos que las operaciones del repositorio se realizan en el orden indicado
    @Test
    void testVerificacionDeOrden() {
        when(repositorio.obtenerValorA()).thenReturn(5);
        when(repositorio.obtenerValorB()).thenReturn(3);

        calculadoraService.sumarValores();

        InOrder inOrder = inOrder(repositorio);
        inOrder.verify(repositorio).obtenerValorA();
        inOrder.verify(repositorio).obtenerValorB();
    }

    // En este test, hacemos que el espía mantenga funcionalidades del objeto,
    // y mockeamos solo los métodos indicados.
    @Test
    void testUsoDeSpy() {
        doReturn(15).when(calculadoraSpy).sumarValores();

        int resultado = calculadoraSpy.sumarValores();
        assertEquals(15, resultado);
        assertEquals(32, calculadoraService.sumarValores(17, 15));
    }
}