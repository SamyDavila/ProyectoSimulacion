package Filas;

import java.util.LinkedList;

public class Filas {
    static int n = 4; //Número de probadores
    
    /**
     * Calcula el número de clientes que hay en la fila
     * @param clientes El historial de los clientes que han llegado
     * @return el número de clientes en la fila
     */
    public static int nFila(LinkedList<Cliente> clientes){
        int cont = 0;
        int x = clientes.getLast().eLlegadaFila;
        for (int i = clientes.size()-2; i >= 0; i--) {
            if(clientes.get(i).eSalidaFila){
                //nothing
            }
            else if(clientes.get(i).sSalidaProbadores[clientes.get(i).menor(clientes.get(i).sSalidaProbadores)]>x){
                cont++;
            }
            else{
                break;
            }
        }
        return cont;
    }
    
    public static void main(String[] args){
        int Inactividad = 0;
        int[] probadores = new int[n]; //Inicializamos los tiempos en que se desocupan los probadores
        LinkedList<Cliente> clientes = new LinkedList(); //Inicializamos el historial de clientes
        
        //Añadimos al primer cliente (Como no hay anterior le ponemos los valores en 0, y la lista de probadores inicializada
        clientes.add(new Cliente(0, 0));
        clientes.get(0).Todo(0, probadores.clone());
        Inactividad += clientes.get(0).sInactividad;
        
        //Recorremos los clientes que vamos a analizar
        for (int i = 1; i < 205; i++) {
            //Se agrega cada cliente al historial
            int x = nFila(clientes);
            clientes.add(new Cliente(i, x));
            clientes.get(i).Todo(clientes.get(i-1).eLlegadaFila, clientes.get(i-1).sSalidaProbadores.clone());
            Inactividad += clientes.get(i).sInactividad;
        }
        
        //Imprimimos el historial
        //System.out.println(clientes);
        
        //Contamos el número de clientes que salieron de la fila por lo larga que estaba
        int cont = 0;
        for (Cliente cli : clientes) {
            if(cli.eSalidaFila){
                cont++;
            }
        }
        System.out.println("Se salieron un total de " + cont + " clientes.\nLos probadores estuvieron "+Inactividad+" unidades inactivos");
    }
}
