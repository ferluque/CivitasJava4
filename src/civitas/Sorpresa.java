/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

/**
 *
 * @author ferluque
 */
import java.util.ArrayList;

public abstract class Sorpresa {
    
    
    
    private String texto;
    private int valor;

    private MazoSorpresas mazo;
    private TipoSorpresa tipo;
    
    // A SorpresaCarcel
    // private Tablero tablero;

    Sorpresa() {
    }
    
    //Sorpresa de cárcel
    // A SorpresaCarcel
    /*
    Sorpresa(TipoSorpresa tipo, Tablero tablero) {
        init();
        this.tipo = tipo;
        this.tablero = tablero;
    }
    */

    //Sorpresa de cambio de casilla
    // A SorpresairCasilla
    /*
    Sorpresa(TipoSorpresa tipo, Tablero tablero, int valor, String texto) {
        init();
        this.tipo = tipo;
        this.tablero = tablero;
        this.valor = valor;
        this.texto = texto;
    }
    */

    //Resto de sorpresas
    /*
    Sorpresa(TipoSorpresa tipo, int valor, String texto) {
        init();
        this.tipo = tipo;
        this.valor = valor;
        this.texto = texto;
    }
    */

    //Sorpresa que EVITA La cárcel
    // A SorpresaSalirCarcel
    /*
    Sorpresa(TipoSorpresa tipo, MazoSorpresas mazo) {
        init();
        this.tipo = tipo;
        this.mazo = mazo;

    }
    */
    /*
    // A SorpresairCasilla
    private void aplicarAJugador_irACasilla(int actual, ArrayList<Jugador> todos) {
        if (jugadorCorrecto(actual, todos)) {
            informe (actual, todos);
            int casillaActual = todos.get(actual).getNumCasillaActual();
            int nueva_posicion = tablero.nuevaPosicion(casillaActual, Dado.getInstance().tirar());
            todos.get(actual).moverACasilla(nueva_posicion);
            //casilla.recibeJugador(actual, todos); Mirar después de implementar Casilla
        }
    }

    // A SorpresaCarcel
    private void aplicarAJugador_irCarcel(int actual, ArrayList<Jugador> todos) {
        if (jugadorCorrecto(actual, todos)) {
            informe(actual, todos);
            todos.get(actual).encarcelar(tablero.getCarcel());
        }
    }

    // A SorpresaPagarCobrar
    private void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos) {
        if (jugadorCorrecto(actual, todos)) {
            informe(actual, todos);
            todos.get(actual).modificarSaldo(valor);
        }
    }

    // A SorpresaPorCasaHotel
    private void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos) {
        if (jugadorCorrecto(actual, todos)) {
            informe(actual, todos);
            todos.get(actual).modificarSaldo(valor * (todos.get(actual).cantidadCasasHoteles()));
        }
    }
    
    // A SorpresaPorJugador
    private void aplicarAJugador_porJugador(int actual, ArrayList<Jugador> todos) {
        if (jugadorCorrecto(actual, todos)) {
            informe(actual, todos);
            //Se crea una sorpresa PAGARCOBRAR y se aplica a todos menos al actual
            Sorpresa pagar = new Sorpresa(TipoSorpresa.PAGARCOBRAR, valor, texto);
            pagar.valor *= -1;
            for (int i = 0; i < todos.size(); i++) {
                if (i != actual) {
                    pagar.aplicarAJugador(i, todos);
                }
            }
            //Se crea una nueva sorpresa PAGARCOBRAR y se aplica al actual
            Sorpresa cobrar = new Sorpresa(TipoSorpresa.PAGARCOBRAR, valor, texto);
            cobrar.valor *= (todos.size() - 1);
            cobrar.aplicarAJugador(actual, todos);
        }
    }
    
    // A SorpresaSalirCarcel
    private void aplicarAJugador_salirCarcel(int actual, ArrayList<Jugador> todos) {
        boolean tienen = false;
        if (jugadorCorrecto(actual, todos)) {
            informe(actual, todos);
            for (int i = 0; i < todos.size() && !tienen; i++) {
                tienen = todos.get(i).tieneSalvoconducto();
            }
            if (!tienen) {
                todos.get(actual).obtenerSalvoconducto(this);
                salirDelMazo();
            }
        }
    }
    */
    
    protected void informe(int actual, ArrayList<Jugador> todos) {
        Diario.getInstance().ocurreEvento("Se aplica una sorpresa al jugador " + todos.get(actual).getNombre());
    }

    

    public boolean jugadorCorrecto(int actual, ArrayList<Jugador> todos) {
        return (actual >= 0 && actual < 4);
    }
    
    // A SorpresaSalirCarcel
    /*
    void salirDelMazo() {
        if (tipo == TipoSorpresa.SALIRCARCEL)
            mazo.inhabilitarCartaEspecial(this);
    }
    void usada() {
        if (tipo == TipoSorpresa.SALIRCARCEL)
            mazo.habilitarCartaEspecial(this);
    }
*/

    @Override
    public String toString() {
        return "Sorpresa{" + "texto=" + texto + ", valor=" + valor + ", tipo=" + tipo + ", tablero=" + tablero + '}';
    }

    
    /*
    
    public static void main (String args[]) {
        ArrayList<Sorpresa> sorpresas = new ArrayList();
        System.out.println("Constructores:");
        sorpresas.add(new Sorpresa(TipoSorpresa.IRCARCEL, new Tablero(-1)));
        sorpresas.add(new Sorpresa(TipoSorpresa.IRCASILLA, new Tablero(-1), 16, "El jugador se desplaza a la casilla nº 16"));
        sorpresas.add(new Sorpresa(TipoSorpresa.SALIRCARCEL, new MazoSorpresas()));
        sorpresas.add(new Sorpresa(TipoSorpresa.PAGARCOBRAR, 50, "El jugador paga 50 por una multa"));
        sorpresas.add(new Sorpresa(TipoSorpresa.PORCASAHOTEL, 1000, "El jugador paga 1000 (por cada casa y cada hotel)"));
        sorpresas.add(new Sorpresa(TipoSorpresa.PORJUGADOR, 20, "El jugador recibe 20 (por cada jugador)"));
        for (int i=0; i<sorpresas.size(); i++)
            System.out.println(sorpresas.get(i).toString());
        
        ArrayList<Jugador> todos = new ArrayList();
        todos.add(new Jugador("Fernando"));
        todos.add(new Jugador("Israel"));
        todos.add(new Jugador("Pedro"));
               
        System.out.println("\nMétodo aplicarAJugador_irCarcel: ");
        sorpresas.get(0).aplicarAJugador_irCarcel(0, todos);
        System.out.println(todos.get(0).toString());
        
        System.out.println("\nMétodo aplicarAJugador_salirCarcel: ");
        sorpresas.get(2).aplicarAJugador(1, todos);
        System.out.println(todos.get(1).toString());
        
        System.out.println("\nMétodo aplicarAJugador_irCasilla: ");
        sorpresas.get(1).aplicarAJugador(0, todos);
        System.out.println(todos.get(0).toString());
                
        System.out.println("\nMétodo aplicarAJugador_pagarCobrar: ");
        sorpresas.get(3).aplicarAJugador(0, todos);
        System.out.println(todos.get(0).toString());
        
    }
*/

}
