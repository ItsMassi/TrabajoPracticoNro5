package Ejercicios;
import java.util.Iterator;

import Excepciones.InvalidKeyException;
import Sources.*;

/*Lo hice con una lista doblemente enlazada porque mi TDA Lista simplemente enlazada es muy feo
 * nunca uso las propiedades de lista simplemente enlazada*/

public class ejercicio2{
	/*
	 * Se  poseen  dos  correspondencias  (mapeos)  M1  y  M2  cuyas  entradas  tienen  por  dominio  un 
	 * n�mero  de  libreta,  y  por  imagen  la  nota  de  una  materia  (de  0  a  10).  Ambos  mapeos  est�n 
	 * implementados con una lista simplemente enlazada y sin celda de encabezamiento.
	 * */
	
	public ejercicio2() {}
	/**
	 * Escriba un m�todo que reciba los dos mapeos M1 y M2 y devuelva una lista L con aquellos 
	 * elementos  E1  de  M1  y  E2  de  M2  que  coincidan  en  el  valor  del  dominio,  pero  tengan  una 
	 * imagen  diferente. Por ejemplo, si E1= (LU: 29303, Nota: 8) pertenece a M1 y 
	 * E2= (LU:29303, Nota: 7) pertenece a M2, entonces E1 y E2 ser�n puestos en L. 
	 * @param m1
	 * @param m2
	 * @return lista de elementos con misma clave pero distinto valor
	 */
	public ListaDE<Entry<Integer,Integer>> incisioA(Map<Integer,Integer> m1, Map<Integer,Integer> m2){
		//crea iterable de m1
		ListaDE<Entry<Integer,Integer>> list = new ListaDE<Entry<Integer,Integer>>();
		Integer valorM2 = null;
		Iterable<Entry<Integer,Integer>> itm1 = m1.entries();
		/*
		 * para cada entrada de m1, buscar si existe una entrada con clave igual en m2
		 * si existe, si los valores son distintos entonces los agrega a list*/
		
		
		for(Entry<Integer, Integer> c : itm1) {  //para cada entrada de m1
			try {
				
				valorM2 = m2.get(c.getKey()); //buscar si existe una entrada con clave igual en m2
				if(valorM2!=null && valorM2 != c.getValue()) { //si existe, si los valores son distintos
					
					list.addLast(c);											    //lo agrega a list
					list.addLast(new Entrada<Integer,Integer>(c.getKey(), valorM2));//lo agrega a list
					
				}
				
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
			valorM2 = null; //reset
		}
		return list;
	}
	
	public static void main(String[] args) {
		//aca iria el tester pero no se que hacer xDDDDDDDDDDDD
	}

}


/*     NOTAS
 * no se a que se refiere con una lista con celda de encabezamiento nula*/