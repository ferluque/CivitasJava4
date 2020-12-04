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
public class SorpresaPorJugador extends Sorpresa {
    private int valor;
    private String texto;
    
    SorpresaPorJugador (int valor, String texto) {
        this.valor = valor;
        this.texto = texto;
    }
    
    void aplicarAJugador (int actual, ArrayList<Jugador> todos) {
        if (super.jugadorCorrecto(actual, todos)) {
            super.informe(actual, todos);
            SorpresaPagarCobrar pagar = new SorpresaPagarCobrar(valor, texto);
            pagar.setValor(pagar.getValor()*-1);
            
            for (int i=0; i<todos.size(); i++)
                if (i!= actual)
                        pagar.aplicarAJugador(i, todos);
            
            SorpresaPagarCobrar cobrar = new SorpresaPagarCobrar(valor, texto);
            cobrar.setValor(cobrar.getValor()*(todos.size()-1));
            cobrar.aplicarAJugador(actual, todos);
        }
    }
}
