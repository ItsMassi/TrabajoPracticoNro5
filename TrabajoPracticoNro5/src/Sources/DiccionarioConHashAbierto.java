package Sources;

import Excepciones.InvalidKeyException;
import Excepciones.NonExistentEntryException;

public class DiccionarioConHashAbierto<K,V> implements Dictionary<K,V>{
	int tamano,maximo;
	protected DiccionarioConLista<K,V>[] buckets;
	
	@SuppressWarnings("unchecked")
	public DiccionarioConHashAbierto() {
		tamano = 0;
		maximo = 13;
		buckets =(DiccionarioConLista<K,V>[]) new DiccionarioConLista[13];
		for(int i=0; i<maximo; i++) {
			buckets[i]= new DiccionarioConLista<K,V>();
		}
	}
	
	private int hash(K key) {
		return (key.hashCode() % maximo);
	}
	
	private boolean esPrimo(int tamaño) {
		if(tamaño<=1) {
			return false;
		}
		if(tamaño<=3) {
			return true;
		}
		if (tamaño%2==0|| tamaño%3==0) {
			return false;
		}
		 for (int i = 5; i * i <= tamaño; i = i + 6) {
	            if (tamaño % i == 0 || tamaño % (i + 2) == 0) {
	              return false;
	            }
		 }
	     return true;
		
	}
	
	private int siguientePrimo(int x) {
		if(maximo<=1) {
			return 2;
		}
		int retorno=maximo;
		boolean encontre =false;
		while(!encontre) {
			retorno++;
			if(esPrimo(retorno))
				encontre=true;
			
		}
		return retorno;
	}
	
	private void rehash() throws InvalidKeyException, Sources.InvalidKeyException{
		maximo = siguientePrimo(2*maximo);
		@SuppressWarnings("unchecked")
		DiccionarioConLista<K,V>[] diccionarioNuevo =(DiccionarioConLista<K,V>[]) new DiccionarioConLista[maximo];
		for(int i=0; i<maximo;i++) {
			diccionarioNuevo[i]=new DiccionarioConLista<K,V>();
		}
		for(Entry<K,V> e : this.entries()) {
			diccionarioNuevo[hash(e.getKey())].insert(e.getKey(), e.getValue());
		}
		buckets=diccionarioNuevo;
	}
	
	
	
	//---------------------------------No hashing--------------------------------------
	
	
	
	public int size() {
		return tamano;
	}

	public boolean isEmpty() {
		return (tamano==0);
	}

	public Entry<K, V> find(K key) {
		boolean found = false;
		Entry<K,V> retorno = null;
		for(int i = 0; i < maximo; i++) {
			try {
				found = buckets[i].find(key) == null;
				if(found) {
					retorno = buckets[i].find(key);
				}
			} catch (Sources.InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return retorno;
	}

	@Override
	public Iterable<Entry<K, V>> findAll(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	//                                                                          vvv   esto que es??????????????????????????
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException, Sources.InvalidKeyException{
		if(key==null) {
			  throw new InvalidKeyException("La key no puede ser nula.");	
		}
		Entry<K,V> retorno =buckets[hash(key)].insert(key, value);
		if(retorno==null) {
			tamano++;
		}
		if((float)tamano / maximo>=0.9f) {
			rehash();
		}
		return retorno;
	}

	@Override
	public Entry<K, V> remove(Entry<K, V> e) throws InvalidEntryException, NonExistentEntryException {
		if(e==null) {
			  throw new InvalidEntryException("La key no puede ser nula.");	
			}
			Entry<K,V> retorno= buckets[hash(e.getKey())].remove(e);
			if(retorno!=null) {
			  tamano--;
			}
		return retorno;
	}

	
	//no se como implementar esto xDDDDDDDDDDDDD
	@Override
	public Iterable<Entry<K, V>> entries() {
		return null;
	}

}
