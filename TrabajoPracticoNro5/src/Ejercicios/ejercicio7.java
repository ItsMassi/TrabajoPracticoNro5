package Ejercicios;

import Excepciones.InvalidKeyException;
import Sources.*;
import java.util.Iterator;

public class ejercicio7<K,V> {
	public ejercicio7() {}
	public boolean incisoA(Map<K,V> m1, Map<K,V> m2) {
		System.out.println(m1.size()<=m2.size());
		boolean retorno = m1.size()<=m2.size();
		V valor = null;
		Iterable<K> itera = m1.keys();
				
		Iterator<K> it = itera.iterator();
		while(it.hasNext() && retorno) {
			try {
				valor = m2.get(it.next());
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			retorno = valor != null;
		}
		
		return retorno;
	}
	
	public static void main(String[] args) {
		ejercicio7<String,Integer> ej =  new ejercicio7<String,Integer>();
		Map<String,Integer> m1 = new MapeoConLista<String,Integer>();
		Map<String,Integer> m2 = new MapeoConLista<String,Integer>();
		System.out.println("size m1  "+m1.size());
		System.out.println("size m2  "+m2.size());
		System.out.println("------------------------");
		
		try {
			m1.put("Daniel", 1);
			System.out.println("size m1  "+m1.size());
			m1.put("Bruno", 2);
			System.out.println("size m1  "+m1.size());
			m1.put("Gino", 3);
			System.out.println("size m1  "+m1.size());
			m1.put("Nico", 4);
			System.out.println("size m1  "+m1.size());
			m1.put("Benja", 5);
			System.out.println("size m1  "+m1.size());
			//m1.put("Sergiogod", 6);
			//System.out.println("size m1  "+d1.size());
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			m2.put("Daniel", 1);
			System.out.println("size m1  "+m2.size());
			m2.put("Bruno", 2);
			System.out.println("size m1  "+m2.size());
			m2.put("Gino", 3);
			System.out.println("size m1  "+m2.size());
			m2.put("Nico", 4);
			System.out.println("size m1  "+m2.size());
			m2.put("Benja", 5);
			System.out.println("size m1  "+m2.size());
			//m2.put("Sergiogod", 6);
			//System.out.println("size m1  "+d1.size());

		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------------------------------");
		System.out.println("size m1  "+m1.size());
		System.out.println("size m2  "+m2.size());
		System.out.println("m2 contiene a m1? "+ ej.incisoA(m1, m2));
	}
}
