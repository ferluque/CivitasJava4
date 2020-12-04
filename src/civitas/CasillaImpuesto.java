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
public class CasillaImpuesto extends Casilla {
    private float importe;
    
    CasillaImpuesto(float cantidad, String nombre) {
        super(nombre);
        importe = cantidad;
    }
    
    @Override
    void recibeJugador (int actual, ArrayList<Jugador> todos) {
        if (super.jugadorCorrecto(actual, todos)) {
            super.informe(actual, todos);
            todos.get(actual).pagaImpuesto(importe);
        }
    }

    @Override
    public String toString() {
        return "CasillaImpuesto{" + "nombre=" + super.getNombre() + ",importe=" + importe + '}';
    }
    
    
}
