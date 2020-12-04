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
public class CasillaCalle extends Casilla {
    private TituloPropiedad tituloPropiedad;
    
    CasillaCalle (TituloPropiedad titulo) {
        super(titulo.getNombre());
        tituloPropiedad = titulo;
    }
    
    TituloPropiedad getTituloPropiedad() {
        return tituloPropiedad;
    }
    
    void recibeJugador(int actual, ArrayList<Jugador> todos) {
        if (super.jugadorCorrecto(actual, todos)) {
            super.informe(actual, todos);
            if (!tituloPropiedad.tienePropietario())
                todos.get(actual).puedeComprarCasilla();
            else
                tituloPropiedad.tramitarAlquiler(todos.get(actual));
        }
    }

    @Override
    public String toString() {
        return "CasillaCalle{"+ "nombre=" + super.getNombre() + ", tituloPropiedad=" + tituloPropiedad + '}';
    }
    
    
}
