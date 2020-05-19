/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta8;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author estudiante.fit
 */
public class ArbolBBTest {
    
    public ArbolBBTest() {
    }

    @Test
    public void testClaveAnteriorarbolVacio() {

        ArbolBB<Integer> instance = new ArbolBB();
        Integer expResult = null;
        Integer actResult = (Integer)instance.anterior(8);
        assertEquals(expResult,actResult);
    }
    @Test
    public void testClaveAnteriorarbolUnElem() {

        ArbolBB<Integer> instance = new ArbolBB();
        instance.insertar(new TElementoAB<Integer>(1, 1));
        Integer expResult = null;
        Integer actResult = (Integer)instance.anterior(1);
        assertEquals(expResult,actResult);
    }
    @Test
    public void testClaveAnteriorarbolDosElem() {

        ArbolBB<Integer> instance = new ArbolBB();
        instance.insertar(new TElementoAB<Integer>(1, 1));
        instance.insertar(new TElementoAB<Integer>(2, 2));
        Integer expResult = 1;
        Integer actResult = (Integer)instance.anterior(2);
        assertEquals(expResult,actResult);
    }
    @Test
    public void testClaveAnteriorAnteriorMenor() {

        ArbolBB<Integer> instance = new ArbolBB();
        instance.insertar(new TElementoAB<Integer>(1, 1));
        instance.insertar(new TElementoAB<Integer>(2, 2));
        Integer expResult = null;
        Integer actResult = (Integer)instance.anterior(1);
        assertEquals(expResult,actResult);
    }
    @Test
    public void testClaveAnteriorarbolTresElem() {

        ArbolBB<Integer> instance = new ArbolBB();
        instance.insertar(new TElementoAB<Integer>(1, 1));
        instance.insertar(new TElementoAB<Integer>(2, 2));
        instance.insertar(new TElementoAB<Integer>(3, 3));
        Integer expResult = 2;
        Integer actResult = (Integer)instance.anterior(3);
        assertEquals(expResult,actResult);
    }
    @Test
    public void testSumaClavesArbolVacio() {

        ArbolBB<Integer> instance = new ArbolBB();
        Integer expResult = -1;
        Integer actResult = instance.sumaClaves(1);
        assertEquals(expResult,actResult);
    }
    @Test
    public void testSumaClavesNivelNegativo() {

        ArbolBB<Integer> instance = new ArbolBB();
        instance.insertar(new TElementoAB<Integer>(1, 1));
        Integer expResult = -1;
        Integer actResult = instance.sumaClaves(-1);
        assertEquals(expResult,actResult);
    }
    @Test
    public void testSumaArbolUnElem() {

        ArbolBB<Integer> instance = new ArbolBB();
        instance.insertar(new TElementoAB<Integer>(5, 5));
        Integer expResult = 5;
        Integer actResult = instance.sumaClaves(0);
        assertEquals(expResult,actResult);
    }
    @Test
    public void testSumaArbolDosElem() {

        ArbolBB<Integer> instance = new ArbolBB();
        instance.insertar(new TElementoAB<Integer>(1, 1));
        instance.insertar(new TElementoAB<Integer>(3, 3));
        Integer expResult = 3;
        Integer actResult = instance.sumaClaves(1);
        assertEquals(expResult,actResult);
    }
    @Test
    public void testSumaArbolTresElem() {

        ArbolBB<Integer> instance = new ArbolBB();
        instance.insertar(new TElementoAB<Integer>(2, 2));
        instance.insertar(new TElementoAB<Integer>(1, 1));
        instance.insertar(new TElementoAB<Integer>(3, 3));
        Integer expResult = 4;
        Integer actResult = instance.sumaClaves(1);
        assertEquals(expResult,actResult);
    } 
    
    

    
    
}
