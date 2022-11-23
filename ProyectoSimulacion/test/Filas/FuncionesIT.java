package Filas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
public class FuncionesIT {
    /**
     * Test of Z method, of class Funciones.
     */
    @Test
    public void testZ() {
        System.out.println("Z");
        //0.8145, 0.1355, 0.7114, 0.8174
        double[] miu = {5, 5, 5, 10};
        double[] sigma2 = {2, 1, 2, 3};
        Funciones instance = new Funciones();
        int[] expResult = {(int)((0.9)*sigma2[0]+miu[0]), (int)((-1.11)*sigma2[1]+miu[1]), (int)((0.56)*sigma2[2]+miu[2]), (int)((0.91)*sigma2[3]+miu[3])};
        for (int i = 0; i < miu.length; i++) {
            int result = instance.Z(miu[i], sigma2[i]);
            assertEquals(expResult[i], result);
        }
    }

    /**
     * Test of Salir method, of class Funciones.
     */
    @Test
    public void testSalir() {
        //0.8145, 0.1355, 0.7114, 0.8174
        System.out.println("Salir");
        double[] lambda = {0.5, 0.3, 0.1, 0};
        int[] n = {1, 0, 10, 50};
        Funciones instance = new Funciones();
        boolean[] expResult = {((1-Math.exp(-lambda[0]*n[0]))>0.8145), false, ((1-Math.exp(-lambda[2]*n[2]))>0.8145), false};
        for (int i = 0; i < lambda.length; i++) {
            boolean result = instance.Salir(lambda[i], n[i]);
            assertEquals(expResult[i], result);
        }
    }
    
}
