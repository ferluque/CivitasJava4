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
public class CasillaSorpresa extends Casilla {
    private Sorpresa sorpresa;
    private MazoSorpresas mazo;
    
    CasillaSorpresa(MazoSorpresas mazo, String nombre) {
        super(nombre);
        this.mazo = mazo;
    }
    
    void recibeJugador (int actual, ArrayList<Jugador> todos) {
        if (super.jugadorCorrecto(actual, todos)) {
            sorpresa = mazo.siguiente();
            super.informe(actual, todos);
            sorpresa.aplicarAJugador(actual, todos);
        }
    }

    @Override
    public String toString() {
        return "CasillaSorpresa{" + "nombre: " + super.getNombre() + ", sorpresa=" + sorpresa + ", mazo=" + mazo + '}';
    }
    
    
}
