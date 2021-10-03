package Sources;

import Excepciones.BoundaryViolationException;
import Excepciones.EmptyListException;
import Excepciones.InvalidPositionException;

public class DiccionarioConLista<K,V> implements Dictionary<K, V> {
	protected ListaDE<Entry<K,V>> D;
	
	public DiccionarioConLista() {
		D = new ListaDE<Entry<K,V>>();
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return D.size();
	}

	@Override
	public boolean isEmpty() {
		return D.isEmpty();
	}

	@Override
	public Entry<K, V> find(K key) throws InvalidKeyException {
		for(Position<Entry<K,V>> p : D.positions()) {
			if(p.element().getKey().equals(key)) {
				return p.element();
			}
		}
		return null;
	}

	@Override
	public Iterable<Entry<K, V>> findAll(K key) throws InvalidKeyException {
		PositionList<Entry<K,V>> l = new ListaDE<Entry<K,V>>();
		for(Position<Entry<K,V>> p : D.positions()) {
			if(p.element().getKey().equals(key)) {
				l.addLast(p.element());
			}
		}
		return l;
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		Entry<K,V> e = new Entrada<K,V>(key, value);
		D.addLast(e);
		return e;
	}

	@Override
	public Entry<K, V> remove(Entry<K, V> e) throws InvalidEntryException{
		for(Position<Entry<K,V>> p : D.positions()) {
			if(p.element() == e) {
				try {
					D.remove(p);
				} catch (InvalidPositionException e1) {
					e1.printStackTrace();
				} return e;
			}
		}
		throw new InvalidEntryException("La entrada es inexistente");
	}

	@Override
	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K,V>> l = new ListaDE<Entry<K,V>>();
		if(!isEmpty()) {
			try {
				Position<Entry<K,V>> recorro;
				for(recorro = D.first() ; recorro != D.last() ; D.next(recorro)) {
					l.addFirst(recorro.element());
				}
				l.addLast(recorro.element());
			}
			catch(InvalidPositionException | BoundaryViolationException | EmptyListException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
