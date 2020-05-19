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
public class TElementoAB<T> implements IElementoAB<T> {

    private T dato;
    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;

    public TElementoAB(Comparable eti, T dato) {
        this.dato = dato;
        this.etiqueta = eti;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        hijoDer = elemento;

    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.compareTo(this.etiqueta) == 0) {
            return this;
        }

        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (hijoIzq != null) {
                return hijoIzq.buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else {
            if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
                if (hijoDer != null) {
                    return hijoDer.buscar(unaEtiqueta);
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public TElementoAB<T> buscarYContar(Comparable unaEtiqueta, int[] contador) {
        contador[0]++;
        if (unaEtiqueta.compareTo(this.etiqueta) == 0) {
            return this;
        }

        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (hijoIzq != null) {
                return hijoIzq.buscarYContar(unaEtiqueta, contador);
            } else {
                contador[0] = -1;
                return null;
            }
        } else {
            if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
                if (hijoDer != null) {
                    return hijoDer.buscarYContar(unaEtiqueta, contador);
                } else {
                    contador[0] = -1;
                    return null;
                }
            }
        }
        contador[0] = -1;
        return null;
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        if (this.getEtiqueta() == elemento.getEtiqueta()) {
            return false;
        }
        if (elemento.getEtiqueta().compareTo(this.getEtiqueta()) < 0) {
            if (this.getHijoIzq() == null) {
                this.setHijoIzq(elemento);
                return true;
            } else {
                this.getHijoIzq().insertar(elemento);
                return true;
            }

        } else {
            if (this.getHijoDer() == null) {
                this.setHijoDer(elemento);
                return true;
            } else {
                this.getHijoDer().insertar(elemento);
                return true;
            }
        }
    }

    public boolean insertarYContar(TElementoAB<T> elemento, int[] contador) {

        contador[0]++;

        if (this.getEtiqueta() == elemento.getEtiqueta()) {
            return false;
        }
        if (elemento.getEtiqueta().compareTo(this.getEtiqueta()) < 0) {
            if (this.getHijoIzq() == null) {
                this.setHijoIzq(elemento);
                return true;
            } else {
                return this.getHijoIzq().insertarYContar(elemento, contador);
            }

        } else {
            if (this.getHijoDer() == null) {
                this.setHijoDer(elemento);
                return true;
            } else {
                return this.getHijoDer().insertarYContar(elemento, contador);
            }
        }
    }

    @Override
    public String preOrden() {

        String tempStr = "";

        tempStr = tempStr + this.getEtiqueta().toString();

        if (this.getHijoIzq() != null) {
            tempStr += " -> " + this.hijoIzq.preOrden();
        }
        if (this.getHijoDer() != null) {
            tempStr += " -> " + this.getHijoDer().preOrden();
        }

        return tempStr;
    }

    @Override
    public String inOrden() {

        String tempStr = "";
        if (this.getHijoIzq() != null) {
            tempStr = this.hijoIzq.inOrden() + " -> " ;
        }
        tempStr = tempStr + this.getEtiqueta().toString();
        if (this.getHijoDer() != null) {
            tempStr += " -> " + this.getHijoDer().inOrden();
        }
        return tempStr;
    }

    @Override
    public String postOrden() {

        String tempStr = "";
        if (this.getHijoIzq() != null) {
            tempStr = this.hijoIzq.postOrden() + " -> ";
        }
        if (this.getHijoDer() != null) {
            tempStr = tempStr + this.getHijoDer().postOrden() + " -> ";
        }
        tempStr = tempStr + this.getEtiqueta().toString();
        return tempStr;
    }

    @Override
    public T getDatos() {
        return dato;
    }

    @Override
    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = this.hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        else if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = this.hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        else {
            return this.quitaElNodo();
        }
    }

    public TElementoAB<T> quitaElNodo() {
        if (this.hijoIzq == null) {
            return this.hijoDer;
        }
        if (this.hijoDer == null) {
            return this.hijoIzq;
        }

        // Si es un nodo completo
        TElementoAB<T> elHijo = this.hijoIzq;
        TElementoAB<T> elPadre = this;
        while (elHijo.hijoDer != null) {
            elPadre = elHijo;
            elHijo = elHijo.hijoDer;
        }
        if (elPadre != this) {
            elPadre.hijoDer = elHijo.hijoIzq;
            elHijo.hijoIzq = this.hijoIzq;
        }

        elHijo.hijoDer = this.hijoDer;
        return elHijo;
    }

    public int tamaño() {
        if (this.getHijoIzq() == null && this.getHijoDer() == null) {
            return 1;
        } else if (this.getHijoIzq() != null && this.getHijoDer() != null) {
            return 1 + this.getHijoIzq().tamaño() + this.getHijoDer().tamaño();
        } else if (this.getHijoIzq() != null) {
            return 1 + this.getHijoIzq().tamaño();
        } else {
            return 1 + this.getHijoDer().tamaño();
        }
    }

    public int altura() {
        int subIzq = -1;
        int subDer = -1;
        if (this.getHijoIzq() != null) {
            subIzq = this.getHijoIzq().altura();
        }
        if (this.getHijoDer() != null) {
            subDer = this.getHijoDer().altura();
        }
        return Math.max(subIzq, subDer) + 1;

    }

    public int sumaClaves(Integer nivel) {
        if (nivel == 0) {
            return (int)this.etiqueta;
        }

        int sumaClavesNivel = 0;
        if (hijoIzq != null) {
            sumaClavesNivel += hijoIzq.sumaClaves(nivel-1);
        }

        if (hijoDer != null) {
            sumaClavesNivel += hijoDer.sumaClaves(nivel-1);
        }

        return sumaClavesNivel;
    }

    public Lista<T> listaInOrder()
    {
        Lista<T> inOrder = new Lista<>();      
        if (this.getHijoIzq() != null) {
            inOrder.concat(hijoIzq.listaInOrder());
        }
        inOrder.insertar(new Nodo<T>(etiqueta, null));
        if (this.getHijoDer() != null) {
            inOrder.concat(hijoDer.listaInOrder());
        }
        return inOrder;
    }
}
