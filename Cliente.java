package Filas;

public class Cliente {
    private static Funciones f = new Funciones();
    //Variables
    
    //datos
    int num;
    int aLlegada;
    int eLlegadaFila;
    int aUso;
    int eEntradaProbador;
    int eSalidaProbador;
    boolean eSalidaFila;
    int sFila;
    int[] sSalidaProbadores;
    
    public Cliente(int num, int nFila){
        this.num = num;
        aLlegada = f.Z(7, 3);
        aUso = f.Z(15, 4);
        eSalidaFila = f.Salir(0.3, nFila);
    }

    public void Todo(int LlegadaAnterior, int[] SalidasAnterior){
        LlegadaFila(LlegadaAnterior);
        Entrada(SalidasAnterior);
        Salida();
        salidas(SalidasAnterior);
        TiempoFila();
    }
    
    private void LlegadaFila(int LlegadaAnterior){
        eLlegadaFila = LlegadaAnterior + aLlegada;
    }
    
    private void Entrada(int[] SalidasAnterior){
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
    
    private void Salida(){
        if(eSalidaFila){
            eSalidaProbador = -1;
        }
        else{
            eSalidaProbador = eEntradaProbador + aUso;
        }
    }
    
    private void salidas(int[] SalidasAnterior){
        if(eSalidaFila){
            sSalidaProbadores = SalidasAnterior;
        }
        else{
            int i = menor(SalidasAnterior);
            sSalidaProbadores = SalidasAnterior;
            sSalidaProbadores[i] = eSalidaProbador;
        }
    }
    
    private void TiempoFila(){
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
