/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta8;

/**
 *
 * @author Administrador
 */
public class App {
    public static void main(String[] args) {
        ArbolBB<Integer> arbol = new ArbolBB<>();

        System.out.println("=========================EJERCICIO 2=========================");
        arbol.insertar(new TElementoAB<Integer>(12, null));
        arbol.insertar(new TElementoAB<Integer>(25, null));
        arbol.insertar(new TElementoAB<Integer>(14, null));
        arbol.insertar(new TElementoAB<Integer>(1, null));
        arbol.insertar(new TElementoAB<Integer>(33, null));
        arbol.insertar(new TElementoAB<Integer>(88, null));
        arbol.insertar(new TElementoAB<Integer>(45, null));
        arbol.insertar(new TElementoAB<Integer>(2, null));
        arbol.insertar(new TElementoAB<Integer>(7, null));
        arbol.insertar(new TElementoAB<Integer>(66,null));
        arbol.insertar(new TElementoAB<Integer>(5, null));
        arbol.insertar(new TElementoAB<Integer>(99, null));

        System.out.println("El recorrido del árbol en inorden es: " + arbol.inOrden());
        System.out.println("El recorrido del árbol en preorden es: " + arbol.preOrden());
        System.out.println("El recorrido del árbol en postorden es: " + arbol.postOrden());

        System.out.println("El metodo sumaClaves en el nivel 2: " + arbol.sumaClaves(2));
    
        System.out.println("El elemento anterior a la clave 88 es: " + arbol.anterior(88));
        System.out.println("El elemento anterior a la clave 25 es: " + arbol.anterior(25));
        System.out.println("El elemento anterior a la clave 33 es: " + arbol.anterior(33));

        System.out.println("=========================EJERCICIO 3=========================");
        System.out.println("Eliminamos los elementos 14, 7 y 55.");
        arbol.eliminar(14);
        arbol.eliminar(7);
        arbol.eliminar(55);
        System.out.println("El recorrido del árbol en inorden es: " + arbol.inOrden());
        System.out.println("El recorrido del árbol en preorden es: " + arbol.preOrden());
        System.out.println("El recorrido del árbol en postorden es: " + arbol.postOrden());

        System.out.println("La suma de los elementos del nivel 2 es: " + arbol.sumaClaves(2));
        System.out.println("El elemento anterior a la clave 12 es: " + arbol.anterior(12));
    }
}
