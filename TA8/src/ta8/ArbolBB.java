package ta8;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author valentinagonzalez
 * @param <T>
 */
public class ArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (this.raiz == null) {
            this.raiz = unElemento;
            return true;
        }
        return raiz.insertar(unElemento);
    }

    public boolean insertarYContar(TElementoAB<T> unElemento, int[] contador) {
        contador[0]++;
        if (this.raiz == null) {
            this.raiz = unElemento;
            System.out.println("El valor del contador es de " + contador[0]);
            return true;
        }
        boolean resultInsert = raiz.insertarYContar(unElemento, contador);
        System.out.println("El valor del contador es de " + contador[0]);
        return resultInsert;

    }

    public TElementoAB<T> buscarYContar(Comparable unaEtiqueta, int[] contador) {
        if (this.raiz == null) {
            contador[0]--;
            return null;
        }
        return raiz.buscarYContar(unaEtiqueta, contador);
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (this.raiz == null) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    @Override
    public String preOrden() {
        if (this.raiz == null) {
            return "Arbol Vacio";
        } else {
            return raiz.preOrden();
        }
    }

    @Override
    public String inOrden() {
        if (this.raiz == null) {
            return "Arbol Vacio";
        } else {
            return raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if (this.raiz == null) {
            return "Arbol Vacio";
        } else {
            return raiz.postOrden();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (this.raiz != null) {
            this.raiz.eliminar(unaEtiqueta);
        }
        else {
            System.out.println("El arbol esta vacio");
        }
    }

    public int tamaño() {
        if (this.raiz == null) {
            return 0;
        }
        return this.raiz.tamaño();
    }

    public int altura() {
        if (this.raiz == null) {
            return -1;
        }
        return this.raiz.altura();

    }

    public int sumaClaves(Integer nivel) {
        if (this.raiz == null || nivel < 0) {
            return -1;
        } else {
            return raiz.sumaClaves(nivel);
        }
    }

    public Comparable anterior(Comparable clave)
    {   
        //caso arbol vacio
        if(raiz==null) { 
            return null;
        }
        //caso un solo elemento
        if(raiz.getHijoDer()==null && raiz.getHijoIzq()==null) {
            return null;
        }

        Lista<T> inOrder = listaInOrder();
        int indice = inOrder.indexOf(clave);
        if(indice!=0 && indice!=(-1)) {
            return inOrder.get(indice-1).getEtiqueta();
        }
        
        return null;
    }

    public Lista<T> listaInOrder()
    {
        return raiz.listaInOrder();
    }
}
