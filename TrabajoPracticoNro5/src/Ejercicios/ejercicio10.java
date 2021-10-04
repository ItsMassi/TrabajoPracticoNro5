package Ejercicios;
import Excepciones.InvalidKeyException;
import Excepciones.NonExistentEntryException;
import Sources.*;
public class ejercicio10<K,V> {
	public ejercicio10() {super();}
	
	public Dictionary<K,V> acomodar(Dictionary<K,V> d) throws Sources.InvalidKeyException, InvalidKeyException, InvalidEntryException, NonExistentEntryException{
		System.out.println("entro");
		Dictionary<K,V> retorno = new DiccionarioConLista<K,V>();
		Iterable<Entry<K, V>> iterable = d.entries();
		Entrada<K,V> entrada = null;
		for(Entry<K, V> e : iterable) {
			entrada = (Entrada<K, V>) e;
			if(retorno.find(e.getKey())==null) {
				retorno.insert(e.getKey(), e.getValue());
			}else {
				retorno.remove(retorno.find(e.getKey()));
				retorno.insert(e.getKey(), e.getValue());
			}

		}
		return retorno;
		
	}
	public static void main(String[] args) {
		ejercicio10<String, Integer> ej = new ejercicio10<String,Integer>();
		Dictionary<String, Integer> d1 = new DiccionarioConLista<String, Integer>();
		Dictionary<String, Integer> d2 = new DiccionarioConLista<String, Integer>();
		
		try {
			d1.insert("Daniel", 1);
			System.out.println("size d1  "+d1.size());
			d1.insert("Bruno", 2);
			System.out.println("size d1  "+d1.size());
			d1.insert("Gino", 3);
			System.out.println("size d1  "+d1.size());
			d1.insert("Nico", 4);
			System.out.println("size d1  "+d1.size());
			d1.insert("Benja", 5);
			System.out.println("size d1  "+d1.size());
			d1.insert("Daniel", 1);
			System.out.println("size d1  "+d1.size());
			
			d2 = ej.acomodar(d1);
			Iterable<Entry<String,Integer>> iterable = d2.entries();
			for(Entry<String, Integer> e : iterable) {
				System.out.println(e.toString());
			}
		} catch ( Sources.InvalidKeyException | InvalidKeyException | InvalidEntryException | NonExistentEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} 
}
