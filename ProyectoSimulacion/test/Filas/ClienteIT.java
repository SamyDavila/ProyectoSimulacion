/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yo_sa
 */
public class ClienteIT {
    
    public ClienteIT() {
    }

    /**
     * Test of Todo method, of class Cliente.
     */
    @Test
    public void testTodo() {
        System.out.println("Todo");
        int[] LlegadaAnterior = {0, 10, 20};
        int[][] SalidasAnterior = {{0, 0, 0},{10, 40, 20},{100, 100, 100}};
        Cliente instance = new Cliente(0, 0);
        int[] expALlegada = {9, 9, 9};
        int[] expAUso = {10, 10, 10};
        int[] expEEntradaProbador = {9, 19, 100};
        int[] expELlegadaFila = {9, 19, 29};
        boolean[] expESalidaFila = {false, false, false};
        int[] expESalidaProbador = {19, 29, 110};
        int[] expSFila = {0, 0, 71};
        int[][] expSSalidaProbadores = {{19}, {29}, {110}};
        for (int i = 0; i < LlegadaAnterior.length; i++) {
            System.out.println("("+i+")");
            instance.Todo(LlegadaAnterior[i], SalidasAnterior[i]);
            assertEquals(expALlegada[i], instance.aLlegada);
            assertEquals(expAUso[i], instance.aUso);
            assertEquals(expEEntradaProbador[i], instance.eEntradaProbador);
            assertEquals(expELlegadaFila[i], instance.eLlegadaFila);
            assertEquals(expESalidaFila[i], instance.eSalidaFila);
            assertEquals(expESalidaProbador[i], instance.eSalidaProbador);
            assertEquals(expSFila[i], instance.sFila);
            assertEquals(expSSalidaProbadores[i][0], instance.sSalidaProbadores[0]);
        }
    }
}
