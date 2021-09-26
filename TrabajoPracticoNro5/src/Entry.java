package TrabajoPracticoNro5.TrabajoPracticoNro5.src;
public interface Entry<K, V> {
	/**
	 * Retorna la clave asociada al valor
	 * @return clave de tipo K
	 */
	public K getKey();
	
	/**
	 * Retorna el valor sujeto a la calve
	 * @return valor de tipo V
	 */
	public V getValue();
}
