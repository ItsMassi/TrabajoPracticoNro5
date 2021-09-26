package TrabajoPracticoNro5.TrabajoPracticoNro5.src;
public interface Map<K,V> {
	/**
	 * Retorna el numero de entradas de M
	 * @return Tamano del mapa M
	 */
	public int size();
	
	/**
	 * Verifica si el mapeo esta vacio
	 * @return esta vacio?
	 */
	public boolean isEmpty();
	
	/**
	 * Le permite recuperar el valor asociado a la clave, sino retorna null
	 * @param key
	 * @return Valor asociado a K
	 */
	public V get(K key);
	
	/**
	 * Si M no almacena un K igual lo guarda y retorna null. Si existe un elemento de igual K cambia los valores de V y retorna el viejo V.
	 * @param key
	 * @param value
	 * @return Posible valor del viejo valor asociado a K
	 */
	public V put(K key, V value);
	
	/**
	 * Remueve el elemento con clave K y retorna su valor, si no existe retorna null.
	 * @param key
	 * @return Posible valor asociado a la clave k
	 */
	public V remove(K key);
	
	/**
	 * Retorna una coleccion iterable de las claves de M.
	 * keys().iterator()-> retorna un iterador de claves
	 * @return coleccion iterable de las claves de M
	 */
	public Iterable<K> keys();
	
	
	/**
	 * Retorna una coleccion iterable de los valores de M.
	 * values().iterator()-> retorna un iterador de valores
	 * @return coleccion iterable de los valores de M
	 */
	public Iterable<V> values();
	
	/**
	 * Retorna una coleccion iterable de los entradas de M.
	 * entries().iterator()-> retorna un iterador de entradas
	 * @return iterable de entradas
	 */
	public Iterable<Entry<K,V>> entries();
}
