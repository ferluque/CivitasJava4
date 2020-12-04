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
public class CasillaJuez extends Casilla {
    private int carcel;
    
    CasillaJuez(int numCasillaCarcel, String nombre) {
        super(nombre);
        carcel = numCasillaCarcel;
    }
    
    void recibeJugador (int actual, ArrayList<Jugador> todos) {
        if (super.jugadorCorrecto(actual, todos)) {
            super.informe(actual, todos);
            todos.get(actual).encarcelar(carcel);
        }
    }

    @Override
    public String toString() {
        return "CasillaJuez{" + "nombre="+ super.getNombre() + ",carcel=" + carcel + '}';
    }
    
    
}
