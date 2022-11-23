package Filas;

public class Cliente {
    public static Funciones f = new Funciones();
    //datos
    int num; //Número de cliente
    int aLlegada; //(Actividad) Tiempo entre llegada
    int eLlegadaFila; //(Evento) Tiempo en que llega a la fila
    int aUso; //(Actividad) Tiempo de uso
    int eEntradaProbador; //(Evento) Tiempo en que entra al probador
    int eSalidaProbador; //(Evento) Tiempo en que sale del probador
    boolean eSalidaFila; //(Evento) Salida de la fila
    int sFila; //(Salida) Tiempo en la fila
    int[] sSalidaProbadores; //(Salida) Tiempo en que se desocupa cada probador
    
    /**
     * Constructor de los clientes
     * @param num El número de cliente que tendrá
     * @param nFila El número de clientes que hay en la fila en el momento en que llegó éste
     */
    public Cliente(int num, int nFila){
        this.num = num;
        aLlegada = f.Z(7, 3);
        aUso = f.Z(15, 4);
        eSalidaFila = f.Salir(0.3, nFila);
    }
    
    /**
     * Realiza todas las operaciones para calcular sus datos
     * @param LlegadaAnterior El tiempo en que llegó el cliente anterior a la fila
     * @param SalidasAnterior El timepo en que se desocupa cada probador
     */
    public void Todo(int LlegadaAnterior, int[] SalidasAnterior){
        LlegadaFila(LlegadaAnterior);
        Entrada(SalidasAnterior);
        Salida();
        salidas(SalidasAnterior);
        TiempoFila();
    }
    
    /**
     * Cálculo de el tiempo en que llegará a la fila
     * @param LlegadaAnterior El tiempo en que llegó el cliente anterior a la fila
     */
    public void LlegadaFila(int LlegadaAnterior){
        eLlegadaFila = LlegadaAnterior + aLlegada;
    }
    
    /**
     * Cálculo de el tiempo en que entrará a un probador
     * @param SalidasAnterior El tiempo en que se desocupan los probadores
     */
    public void Entrada(int[] SalidasAnterior){
        if(eSalidaFila){
            eEntradaProbador = -1;
        }
        else{
            int i = menor(SalidasAnterior);
            if(SalidasAnterior[i] > eLlegadaFila){
                eEntradaProbador = SalidasAnterior[i];
            }
            else{
                eEntradaProbador = eLlegadaFila;
            }
        }
    }
    
    /**
     * Cálculo del menor tiempo entre los tiempos de desocupo de los probadores
     * @param Array los tiempos en que se desocupan los probadores
     * @return el menor valor de este arreglo
     */
    public int menor(int[] Array){
        int menor = Array[0];
        int index = 0;
        for (int i = 0; i < Array.length; i++) {
            if (Array[i]<menor){
                menor = Array[i];
                index = i;
            }
        }
        return index;
    }
    
    /**
     * Cálculo del tiempo en que sale el cliente del probador
     */
    public void Salida(){
        if(eSalidaFila){
            eSalidaProbador = -1;
        }
        else{
            eSalidaProbador = eEntradaProbador + aUso;
        }
    }
    
    /**
     * Actualización de los tiempos de desocupo de los probadores
     * @param SalidasAnterior El tiempo en que se desocupan los probadores
     */
    public void salidas(int[] SalidasAnterior){
        if(eSalidaFila){
            sSalidaProbadores = SalidasAnterior;
        }
        else{
            int i = menor(SalidasAnterior);
            sSalidaProbadores = SalidasAnterior;
            sSalidaProbadores[i] = eSalidaProbador;
        }
    }
    
    /**
     * Cálculo del tiempo que estuvo en la fila
     */
    public void TiempoFila(){
        if(eSalidaFila){
            sFila = 0;
        }
        else{
            sFila = eEntradaProbador - eLlegadaFila;
        }
    }

    @Override
    public String toString() {
        String array = "";
        for (int i = 0; i < sSalidaProbadores.length; i++) {
            array += sSalidaProbadores[i];
            if(i!=sSalidaProbadores.length-1){
                array += ", ";
            }
        }
        return "num=" + num + ", aLlegada=" + aLlegada + ", eLlegadaFila=" + eLlegadaFila + ", aUso=" + aUso + ", eEntradaProbador=" + eEntradaProbador + ", eSalidaProbador=" + eSalidaProbador + ", eSalidaFila=" + eSalidaFila + ", sFila=" + sFila + ", sSalidaProbadores=" + array + "\n";
    }
    
}
