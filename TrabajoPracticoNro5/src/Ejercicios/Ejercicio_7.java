package TDAMapeo;

import Excepciones.InvalidKeyException;

public class Ejercicio_7 {
	public <K,V> boolean pertenece(Map<K,V> m1, Map<K,V> m2) {
		boolean verifica = true;
		
		if(m1.size() <= m2.size()) {
			Map<K,V> m3=clone(m2);
			int sizeViejom3=m3.size();
			for(Entry<K,V> e : m1.entries())
				try {
					m3.put(e.getKey(), e.getValue());
				} catch (InvalidKeyException e1) {
					e1.printStackTrace();
				}
			if(sizeViejom3!=m3.size())
				verifica=false;
			
			
		}else {
			verifica = false;
		}
		
		return verifica;
	}
	
	
	private <K,V> Map<K,V> clone(Map<K,V> m){
		Map<K,V> map = new MapeoConLista<K,V>();
		
		for(Entry<K,V> e : m.entries())
			try {
				map.put(e.getKey(), e.getValue());
			} catch (InvalidKeyException e1) {
				e1.printStackTrace();
			}
		
		return map;
	}
	
	
	
	
	public static void main(String[] args) {
        Ejercicio_7 ej =  new Ejercicio_7();
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
            m1.put("Sergiogod", 6);
            System.out.println("size m1  "+m1.size());
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
        try {
            m2.put("Daniel", 1);
            System.out.println("size m1  "+m1.size());
            m2.put("Bruno", 2);
            System.out.println("size m1  "+m1.size());
            m2.put("Gino", 3);
            System.out.println("size m1  "+m1.size());
            m2.put("Nico", 4);
            System.out.println("size m1  "+m1.size());
            m2.put("Benja", 5);
            System.out.println("size m1  "+m1.size());
            //m2.put("Sergiogod", 6);
            //System.out.println("size m1  "+m1.size());

        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("------------------------------");
        System.out.println("size m1  "+m1.size());
        System.out.println("size m2  "+m2.size());
        System.out.println("m2 contiene a m1? "+ ej.pertenece(m1, m2));
    }
}
