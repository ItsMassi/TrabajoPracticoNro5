package Ejercicios;

import Excepciones.InvalidKeyException;
import Sources.*;

/*extendi Mapeo con lista para evitar problemas de modificaion de codigo si algo pasa es problema de este codigo y no de MapeoConLista*/

public class ejercicio6<K,V> extends MapeoConLista<K,V>{
	public ejercicio6() {
		super();
	}
	
	public Map<V,K> MapeoListaInvertida() {
		@SuppressWarnings("unchecked")
		Map<V,K> retorno = (Map<V, K>) new MapeoConLista<K,V>();//c1
		Iterable<Entry<K,V>> it = entries();//O(n)
		for(Entry<K,V> e : it) {//O(n)
			try {
				retorno.put(e.getValue(), e.getKey());//peor caso O(n)
			} catch (InvalidKeyException e1) {
				e1.printStackTrace();
			}
		}
		return retorno;//c2
		//T(n)= c1+n+n+n+c2 = 3n -> O(n)
	}
	
	public static void main(String[] args) {
		System.out.println("kekw");
		ejercicio6<String,Integer> m1 = new ejercicio6<String,Integer>();
		try {
			m1.put("Daniel", 1);
			m1.put("Bruno", 2);
			m1.put("Gino", 3);
			m1.put("Nico", 4);
			m1.put("Benja", 5);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(m1.toString());
		Map<Integer,String> m2 = m1.MapeoListaInvertida();
		System.out.println(m2.toString());
	}
}
