package Ejercicios;
import Excepciones.InvalidKeyException;
import Sources.*;
//no se si es posible hacer esto porque la clave de los buckets nop se pueden usar esa forma
//no se puede usar una lista como clave de bucket, en cambio lo que haré sera cambair lo valores de cada elemento
//asociado a la lista de cada bucket
public class ejercicio6b<K,V> extends MapeoConHashAbierto<K,V>{
	
	public ejercicio6b() {super();}
	
	public ejercicio6b<V,K> invertirTablaDeDispersion(){
		ejercicio6b<V,K> retorno = new ejercicio6b<V,K>();
		for(int i = 0; i < buckets.length ; i++) {
			Iterable<Entry<K,V>> entradas = buckets[i].entries();
			for(Entry<K,V> e : entradas) {
				try {
					retorno.put(e.getValue(), e.getKey());
				} catch (InvalidKeyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return retorno;
		
	}
	//añadido para el ejercicio 6 no tomar en cuenta
		public void print() {
			for(int i = 0; i < buckets.length; i++) {
				System.out.println("Bucket: "+i+" / "+buckets[i].toString());
			}
		}
		
	public static void main(String[] args) {
		ejercicio6b<String,Integer> m1 = new ejercicio6b<String,Integer>();
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
		ejercicio6b<Integer,String> m2 = m1.invertirTablaDeDispersion();
		m2.print();
	}
}

