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
public class Casilla {

    // Se mantiene en la superclase porque la casilla carcel es una casilla de
    // descanso (De tipo Casilla)
    // private int carcel; 

    // Importe será exclusivo de la CasillaImpuesto
    // private float importe;
    private String nombre;

    // Se elimina el TipoCasilla
    // private TipoCasilla tipo;
    
    // El TituloPropiedad será exclusivo de CasillaCalle
    // private TituloPropiedad tituloPropiedad;
    
    // La Sorpresa y MazoSorpresas serán exclusivos de la CasillaSorpresa
    // private Sorpresa sorpresa;
    // private MazoSorpresas mazo;

    //DESCANSO
    Casilla(String nombre) {
        this.nombre = nombre;
    }

    //CALLE
    // A CasillaCalle
    /*
    Casilla(TituloPropiedad titulo) {
        init();
        tituloPropiedad = titulo;
        tipo = TipoCasilla.CALLE;
        nombre = titulo.getNombre();
    }

    //IMPUESTO
    // A CasillaImpuesto
    Casilla(float cantidad, String nombre) {
        init();
        this.nombre = nombre;
        importe = cantidad;
        tipo = TipoCasilla.IMPUESTO;
    }

    //JUEZç
    // A CasillaJuez
    // Se mantiene para que el constructor de CasillaJuez lo llame y asigne el
    // valor carcel para la Casilla Carcel que sera de tipo descanso
    
    Casilla(int numCasillaCarcel, String nombre) {
        this.nombre = nombre;
        carcel = numCasillaCarcel;
    }

    
    //SORPRESA
    // A CasillaSorpresa
    Casilla(MazoSorpresas mazo, String nombre) {
        init();
        this.nombre = nombre;
        tipo = TipoCasilla.SORPRESA;
        this.mazo = mazo;
    }
    */

    public String getNombre() {
        return nombre;
    }

    // A CasillaCalle
    /*
    TituloPropiedad getTituloPropiedad() {
        return tituloPropiedad;
    }
    */

    protected void informe(int actual, ArrayList<Jugador> todos) {
        Diario.getInstance().ocurreEvento("El jugador " + todos.get(actual).getNombre() + " ha caído en la casilla " + getNombre());
    }
    
    // SE elimina el método init()
    /*
    private void init() {
        importe = 0;
        nombre = "";
    }
    */

    public boolean jugadorCorrecto(int actual, ArrayList<Jugador> todos) {
        return (actual >= 0 && actual < todos.size());
    }

    // DUDA QUÉ HACEMOS
    // Se va a eliminar el método
    // Debemos definirlo ahora en cada subclase
    /*
    void recibeJugador(int actual, ArrayList<Jugador> todos) {
        switch (tipo) {
            case CALLE:
                recibeJugador_calle(actual, todos);
                break;
            case IMPUESTO:
                recibeJugador_impuesto (actual, todos);
                break;
            case JUEZ:
                recibeJugador_juez (actual, todos);
                break;
            case SORPRESA:
                recibeJugador_sorpresa (actual, todos);
                break;
            default:
                informe (actual, todos);
        }
    }
    
    // Se va a CasillaCalle
    private void recibeJugador_calle(int actual, ArrayList<Jugador> todos) {
        if (jugadorCorrecto(actual, todos)) {
            informe (actual, todos);
            if (!tituloPropiedad.tienePropietario())
                todos.get(actual).puedeComprarCasilla(); //No sé si debería hacer algo
            else {
                tituloPropiedad.tramitarAlquiler(todos.get(actual));
            }
        }
    }

    private void recibeJugador_impuesto(int actual, ArrayList<Jugador> todos) {
        if (jugadorCorrecto(actual, todos)) {
            informe(actual, todos);
            todos.get(actual).pagaImpuesto(importe);
        }
    }

    private void recibeJugador_juez(int actual, ArrayList<Jugador> todos) {
        if (jugadorCorrecto(actual, todos)) {
            informe(actual, todos);
            todos.get(actual).encarcelar(carcel);
        }
    }

    private void recibeJugador_sorpresa(int actual, ArrayList<Jugador> todos) {
        if (jugadorCorrecto(actual, todos)) {
            Sorpresa sorpresa = mazo.siguiente();
            informe(actual, todos);
            sorpresa.aplicarAJugador(actual, todos);
        }
    }
    */
    
    @Override
    public String toString() {
        return "Casilla{" + "nombre=" + nombre + '}';
    }

    /*
    public static void main(String args[]) {
        //Crea casilla DESCANSO
        Casilla descanso = new Casilla("Descanso");
        System.out.println(descanso.toString());

        //Crea casilla CALLE
        Casilla calle = new Casilla(new TituloPropiedad("Gran Vía", 150, (float) 1.2, 200, (float) 250, 50));
        System.out.println(calle.toString());

        //Crea casilla IMPUESTO
        Casilla impuesto = new Casilla((float) 100, "Impuesto de luz");
        System.out.println(impuesto.toString());

        //Crea casilla JUEZ
        Casilla juez = new Casilla(10, "Cárcel");
        System.out.println(juez.toString());

        //Crea casilla SORPRESA
        Casilla sorpresa = new Casilla(new MazoSorpresas(), "Casilla Sorpresa");
        System.out.println(sorpresa.toString());

    }
    */

}
