/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author ferluque
 */
public class SorpresaPagarCobrar extends Sorpresa{
    private int valor;
    private String texto;
    
    SorpresaPagarCobrar(int valor, String texto) {
        this.valor = valor;
        this.texto = texto;
    }
    
    void aplicarAJugador (int actual, ArrayList<Jugador> todos) {
        if (super.jugadorCorrecto(actual, todos)) {
            super.informe(actual, todos);
            todos.get(actual).modificarSaldo(valor);
        }
    }
    
    int getValor () {return valor;}
    
    void setValor (int valor) {this.valor = valor;}
}
