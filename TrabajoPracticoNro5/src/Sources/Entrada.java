package Sources;

public class Entrada<K, V> implements Entry<K,V>{
	 private K clave;
	 private V valor;
	 
	 //constructor
	 Entrada(K clave, V valor){this.clave = clave; this.valor = valor;}

	//getters and setters
	public K getKey() {return clave;}
	public V getValue() {return valor;}
	
	/**
	 * Establece la clave a la entrada
	 * @param clave
	 */
	public void setKey(K clave) {this.clave = clave;}
	
	/**
	 * establece el valor de la entrada
	 * @param valor
	 */
	public void setValue(V valor) {this.valor = valor;}
	
	
	/**
	 * retorna el String con los valores de entrada
	 */
	public String toString() {
		return "("+getKey()+","+getValue()+")";
	}
}
