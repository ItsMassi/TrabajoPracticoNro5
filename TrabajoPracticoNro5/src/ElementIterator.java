import java.util.Iterator;

import Excepciones.BoundaryViolationException;
import Excepciones.EmptyListException;
import Excepciones.InvalidPositionException;
import Excepciones.NoSuchElementException;

public class ElementIterator<E> implements Iterator<E>
{
    PositionList<E> lista;
    Position<E> cursor;
    
    public ElementIterator(final PositionList<E> lista) {
        try {
            this.lista = lista;
            if (lista.isEmpty()) {
                this.cursor = null;
            }
            else {
                this.cursor = lista.first();
            }
        }
        catch (EmptyListException ex) {}
    }
    
    public boolean hasNext() {
        return this.cursor != null;
    }
    
    public E next() {
        E toReturn = null;
        try {
            if (this.cursor == null) {
                throw new NoSuchElementException("");
            }
            toReturn = this.cursor.element();
            this.cursor = ((this.cursor == this.lista.last()) ? null : this.lista.next(this.cursor));
        }
        catch (InvalidPositionException ex) {}
        catch (BoundaryViolationException ex2) {}
        catch (EmptyListException ex3) {} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return toReturn;
    }
    
    public void remove() {
    }
}

