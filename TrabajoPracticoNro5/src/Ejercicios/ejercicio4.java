package Ejercicios;
import Excepciones.InvalidKeyException;
import Sources.*;




public class ejercicio4 {
	//creo las clases que vamos a usar
	
	
	
	//atributos de instancia
	private MapeoConHashAbierto<String,Alumno> alumnos;
	
	//constructor
	ejercicio4(){alumnos = new MapeoConHashAbierto<String,Alumno>();}
	
	//requiere a!=null
	public void addAlumno(Alumno a) {
		try {
			alumnos.put(a.getlegajo(), a);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
	}
	//requiere a!=null
	public void addFinal(Alumno a, ExamenFinal ex) {
			//si existe el alumno, agrega la materia
			Iterable<Alumno> listaAlumnos = alumnos.values();
			for(Alumno al : listaAlumnos){
				if(al.getlegajo().equals(a.getlegajo())) {
					al.setFinal(ex);
					return;
				}
			}
			//si no existe le alumno hace nada
	}
	
	public Alumno getAlumno(Alumno a) {
		//si existe el alumno, agrega la materia
		Iterable<Alumno> listaAlumnos = alumnos.values();
		for(Alumno al : listaAlumnos){
			if(al.getlegajo().equals(a.getlegajo())) {
				return al;
			}
		}
		return null;
	}
	
	public Iterable<Alumno> iterableAlumnos(){return alumnos.values();}
	
	public static void main(String[] args) {
		ejercicio4 ej = new ejercicio4();
		
		PositionList<ExamenFinal> listaExamenes = new ListaDE<ExamenFinal>();
		
		Alumno a1 = new Alumno("123", "Bruno Parisi", listaExamenes);
		listaExamenes = new ListaDE<ExamenFinal>();
		Alumno a2 = new Alumno("456", "Daniel Massiris", listaExamenes);
		listaExamenes = new ListaDE<ExamenFinal>();
		Alumno a3 = new Alumno("789", "Gino Leonardo", listaExamenes);
		
		ej.addAlumno(a1);
		ej.addAlumno(a2);
		ej.addAlumno(a3);
		
		ExamenFinal examen = new ExamenFinal("Estructuras", 7);
		ej.addFinal(a1, examen);
		examen = new ExamenFinal("TDC", 9);
		ej.addFinal(a1, examen);

		
		examen = new ExamenFinal("Estructuras", 10);
		ej.addFinal(a2, examen);
		examen = new ExamenFinal("TDC", 6);
		ej.addFinal(a2, examen);
		examen = new ExamenFinal("AM2", 8);
		ej.addFinal(a2, examen);
		examen = new ExamenFinal("Estructuras", 5);//caso de prueba si la materia ya existe
		ej.addFinal(a2, examen);
		
		examen = new ExamenFinal("Estructuras", 10);
		ej.addFinal(a3, examen);
		
		Iterable<Alumno> iterableAlumnos = ej.iterableAlumnos();
		for(Alumno i : iterableAlumnos) {
			i.print();
		}
	}
}
/*     Notas     
 * preguntar el una definicion mas certera del iterable para examenes desde la clase ejercicio4*/
