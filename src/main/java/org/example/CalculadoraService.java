package org.example;

public class CalculadoraService {
    private final Repositorio repositorio;

    public CalculadoraService(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public int sumarValores() {
        return repositorio.obtenerValorA() + repositorio.obtenerValorB();
    }
    //Lo usaremos más tarde en las opciones avanzadas de mockito
    public int sumarValores(int a, int b){
        return a + b;
    }
}
