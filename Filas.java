package Filas;

import java.util.LinkedList;


public class Filas {
    static int n = 1; //Número de probadores
    static Funciones f = new Funciones();
    
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
        int[] probadores = new int[n];
        LinkedList<Cliente> clientes = new LinkedList();
        clientes.add(new Cliente(0, 0));
        clientes.get(0).Todo(0, probadores.clone());
        for (int i = 1; i < 20; i++) {
            int x = nFila(clientes);
            clientes.add(new Cliente(i, x));
            clientes.get(i).Todo(clientes.get(i-1).eLlegadaFila, clientes.get(i-1).sSalidaProbadores.clone());
        }
        System.out.println(clientes);
        
        int cont = 0;
        for (Cliente cli : clientes) {
            if(cli.eSalidaFila){
                cont++;
            }
        }
        System.out.println("Se salieron un total de " + cont + " clientes.");
    }
}
