package Logica;

import java.util.ArrayList;

/**
 * 5IV7 Marín Romero Abigail
 * Moreno Noguerón Ximena
 */
public class Jugador {
    
    private int piedrasJugador, intentos;
    private Caja p;
    private ArrayList<Integer> movJugador = new ArrayList<>();
    
    // Deja ponerle colorcito a la cadena de texto que sale en consola
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public Jugador(){
        this.piedrasJugador = 0;
        movJugador.clear();
    }
    
    public int getPiedrasJugador(){
        return this.piedrasJugador;
    }
    
    public int iniciarPiedras(int piedrasIniciales){
        int piedras = piedrasIniciales;
        
        // Si se devuelve 0, la cantidad de piedras tomadas es correcta
        int state = 1;
        
        // se comprueba que la cantidad sea mayor a 5 y menor a 50
        if (piedras >= 5 && piedras <=50){
            p = new Caja(piedras); // se iniciliza Caja
            state = 0;
            System.out.println(ANSI_PURPLE +"La cantidad de piedras en el "
                    + "inicializador es de 5 a 50"+ ANSI_RESET);
        }
        
        return state;
    }
    
    public int tomarPiedras(int piedras){
        int piedrasTomadas = piedras;
        int statusCaja = 0;
        
        /* se debe validar que la cantidad de piedras no se haya tomado con anterioridad,
            para ello, se utiliza la validación del objeto Caja, que recorre el arreglo de 
            movimientos anteriores y los compara con la cantidad que desea quitarse, si la 
            cantidad ya ha sido tomada antes devuelve -1, si se puede tomar devuelve 1 */
        int statusTomar = p.validacionQuitarPiedras(piedrasTomadas);
        
        if(statusTomar == 1){
            /* se pueden tomar la cantidad de piedras, se deben restar las piedras que se encuentran
               en la caja, con el método quitarPiedras, se debe agregar al array de los movimientos
               del jugador la cantidad de piedras que quitó, y se suman las piedras que tiene el jugador*/
            this.piedrasJugador += piedrasTomadas;
            System.out.println(ANSI_PURPLE +"Piedras del jugador: "+this.piedrasJugador+"\n"+ ANSI_RESET);
            movJugador.add(piedrasTomadas);
            p.quitarPiedras(piedrasTomadas);
            
            // el status de la Caja será igual a 1, indicando que se pudieron tomar las piedras
            statusCaja = 1;
            
        }
        
        return statusCaja;
    }
    
    public String consultarMov(){
        String movimientos = "";
        
        for(int i=0; i<movJugador.size(); i++){
            movimientos = "Tomó "+movJugador.get(i)+" piedras.\n";
        }
        
        return movimientos;
    }
    
    public int consultarPiedras(){
        int piedrasRestantes = p.getPiedras();
        return piedrasRestantes;
    }
    
}
