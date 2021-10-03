package Ejercicios;

import Excepciones.InvalidKeyException;
import Sources.*;
import java.util.Iterator;

public class ejercicio7<K,V> {
	public ejercicio7() {}
	public boolean incisoA(Map<K,V> m1, Map<K,V> m2) {
		System.out.println(m1.size()<=m2.size());
		boolean retorno = m1.size()<=m2.size(); //size()-> O(1) por tanto esto es c1
		V valor = null; //c2
		Iterable<K> itera = m1.keys();//keys tiene O(n) porque require recorrer todo el mapeo para hacer el iterable
				
		Iterator<K> it = itera.iterator(); //O(n) por la misma razon que keys
		while(it.hasNext() && retorno) {//en el peor caso hace n iteraciones 
			try {
				valor = m2.get(it.next());//en el peor caso hace m iteraciones
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			retorno = valor != null ;//c3
		}
		
		return retorno;//c4
	}
	/*entonces T(n)= c1 + o(n) o(n) + (n*(o(1)+O(m))+O(1))
	 *         T(n)= (n*o(1)+n*O(m)+O(1))
	 *         T(n)= n*O(m)*/
	
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
