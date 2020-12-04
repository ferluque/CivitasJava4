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
public class SorpresairCasilla extends Sorpresa {
    private Tablero tablero;
    private int valor;
    private String texto;
    
    SorpresairCasilla (Tablero tablero,  int valor, String texto) {
        this.tablero = tablero;
        this.valor = valor;
        this.texto = texto;
    }
    
    void aplicarAJugador (int actual, ArrayList<Jugador> todos) {
        if (super.jugadorCorrecto(actual, todos)) {
            super.informe(actual, todos);
            int casillaActual = todos.get(actual).getNumCasillaActual();
            int nueva_posicion = tablero.nuevaPosicion(casillaActual, Dado.getInstance().tirar());
            todos.get(actual).moverACasilla(nueva_posicion);
        }
    }
}
