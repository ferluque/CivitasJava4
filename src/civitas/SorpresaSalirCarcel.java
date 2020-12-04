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
public class SorpresaSalirCarcel extends Sorpresa {
    private MazoSorpresas mazo;
    
    void aplicarAJugador (int actual, ArrayList<Jugador> todos) {
        boolean tienen = false;
        
        if (super.jugadorCorrecto(actual, todos)) {
            super.informe(actual, todos);
            for (int i=0; i<todos.size() && !tienen; i++)
                tienen = todos.get(i).tieneSalvoconducto();
            if (!tienen) {
                todos.get(actual).obtenerSalvoconducto(this);
                salirDelMazo();
            }
        }
    }
    
    void salirDelMazo() {
        mazo.inhabilitarCartaEspecial(this);
    }
    
    void usada() {
        mazo.habilitarCartaEspecial(this);
    }
    
}
