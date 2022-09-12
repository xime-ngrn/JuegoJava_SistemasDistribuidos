package Logica;

import java.util.ArrayList;

/**
 *
 * 5IV7 Marín Romero Abigail
 * Moreno Noguerón Ximena
 */
public class Caja {
    
    private int piedras;
    private ArrayList<Integer> piedrasTom = new ArrayList<>();
    
    // Deja ponerle colorcito a la cadena de texto que sale en consola
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public Caja(int piedra){
        this.piedras = piedra;
        piedrasTom.clear();
    }
    
    public void setPiedras(int p){
        this.piedras = p;
    }
    
    public int getPiedras(){
        return this.piedras;
    }
    
    public void quitarPiedras(int quitarPiedras){
        int cPiedras = quitarPiedras;
        
        this.piedras -= cPiedras;
        piedrasTom.add(cPiedras);
        System.out.println("Se pueden tomar la cantidad de piedras");
        System.out.println(ANSI_PURPLE +"Piedras sobrantes: "+this.piedras+"\n"+ ANSI_RESET);
        
    }
    
    public int validacionQuitarPiedras(int piedrasTomadas){
        int pt = piedrasTomadas;
        
        int statePiedras = 1;
        // Si se devuelve 1, la cantidad de piedras se pueden tomar
        // si se devuelve -1, no se puede tomar esa cantidad
        
            if(pt <=0 || pt > getPiedras()){
                statePiedras = -1;
                System.out.println(ANSI_PURPLE +"La cantidad de piedras es 0 o "+getPiedras()+"\n"+ ANSI_RESET);
            }else{
                for(int i=0; i<piedrasTom.size(); i++){
                int pt2 = piedrasTom.get(i);
            
                /* Se comprueba que la cantidad de piedras que se envían no sea igual 
                    a un número ya guardado en el array, porque si no, esa cantidad de 
                    piedras ya no podrían tomarse */
                if(pt2 == pt ){
                    statePiedras = -1;
                    System.out.println(ANSI_RED +"Aqui el num de piedras ya ha sido tomado \n"+ ANSI_RESET);
                    break;
                }else{
                    System.out.println("Aquí el num de piedras no ha sido tomado \n");
                    statePiedras = 1;
                }
            }
        }
        
        System.out.println(ANSI_PURPLE +"Estado final de las piedras: "+statePiedras+"\n"+ ANSI_RESET);
        
        return statePiedras;
    }
    
    public int validacionGanador(){
        /* Se debe comprobar que la cantidad de piedras sea igual a 0 o negativo para que el
           jugador gane. Si se cumple esto, regresa 0*/
        int gana = 1;
        if(this.piedras == 0 || this.piedras < 0){
            gana = 0;
            System.out.println(ANSI_PURPLE +"La cantidad de piedras final es 0 o negativo "+this.piedras+"\n"+ ANSI_RESET);
        }
        return gana;
    }
    
    
    
    
    
    
    
}
